package com.du.common.core.controller;

import com.du.common.core.domain.AjaxResult;
import com.du.common.core.page.PageDomain;
import com.du.common.core.page.TableDataInfo;
import com.du.common.core.page.TableSupport;
import com.du.common.utils.DateUtils;
import com.du.common.utils.ServletUtils;
import com.du.common.utils.SqlUtil;
import com.du.common.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

/**
 * web层通用数据处理
 *
 */
public class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    public void initBinder(WebDataBinder binder){
        //Date类型转换
        binder.registerCustomEditor(Date.class,new PropertyEditorSupport(){
            @Override
            public void setAsText(String text){
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * 设置请求分页数据
     */
    protected void startPage(){
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize)){
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            PageHelper.startPage(pageNum,pageSize,orderBy);
        }
    }

    /**
     * 设置请求排序数据
     */
    protected void startOrderBy(){
        PageDomain pageDomain = TableSupport.buildPageRequest();
        if (StringUtils.isNotEmpty(pageDomain.getOrderBy())){
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            PageHelper.orderBy(orderBy);
        }
    }

    /**
     * 获取request
     */
    public HttpServletRequest getRequest(){
        return ServletUtils.getRequest();
    }

    /**
     * 获取response
     */
    public HttpServletResponse getResponse(){
        return ServletUtils.getResponse();
    }

    /**
     * session
     */
    public HttpSession getSession(){
        return getRequest().getSession();
    }

    /**
     * 响应请求分页数据
     */

    protected TableDataInfo getDataTable(List<?> list){
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }


    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected AjaxResult toAjax(int rows){
        return rows > 0 ? success() : error();
    }


    /**
     * success
     */
    public AjaxResult success(){
        return AjaxResult.success();
    }

    public AjaxResult success(String message){
        return AjaxResult.success(message);
    }
    /**
     * fail
     */

    public AjaxResult error(){
        return AjaxResult.error();
    }

    public AjaxResult error(String message){
        return AjaxResult.error(message);
    }

    public AjaxResult error(AjaxResult.Type type,String message){
        return new AjaxResult(type,message);
    }


    /**
     * 页面跳转
     */
    public String redirect(String url){
        return StringUtils.format("redirect:{}",url);
    }

}
