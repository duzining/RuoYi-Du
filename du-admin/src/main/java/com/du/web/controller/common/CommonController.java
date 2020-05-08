package com.du.web.controller.common;

import com.du.common.config.Global;
import com.du.common.config.ServerConfig;
import com.du.common.constant.Constants;
import com.du.common.core.domain.AjaxResult;
import com.du.common.utils.FileUploadUtils;
import com.du.common.utils.FileUtils;
import com.du.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通用请求处理
 *
 */

@Controller
public class CommonController {

    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private ServerConfig serverConfig;

    /**
     * 通用下载请求
     *
     * @param fileName 文件名称
     * @param delete 是否删除
     */
    @GetMapping("common/download")
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request){
        try {
            if (!FileUtils.isValidFilename(fileName)){
                throw new Exception(StringUtils.format("文件名称（{}）非法，不允许下载。",fileName));
            }
            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = Global.getDownloadPath() + fileName;

            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/from-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName = " +FileUtils.setFileDownloadHeader(request, fileName));
            FileUtils.writeBytes(filePath,response.getOutputStream());
            if (delete){
                FileUtils.deleteFile(filePath);
            }
        }catch (Exception e){
            logger.error("下载文件失败",e);
        }
    }

    /**
     * 通用上传请求
     */
    @PostMapping("/common/upload")
    @ResponseBody
    public AjaxResult uploadFile(MultipartFile file) throws Exception{

        try{
            // 上传文件路径
            String filePath = Global.getUploadPath();
            // 上传文件路径
            String fileName = FileUploadUtils.upload(filePath,file);
            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName",fileName);
            ajax.put("url",url);
            return ajax;

        }catch (Exception e){
            return AjaxResult.error(e.getMessage());
        }
    }


    /**
     * 本地资源通用下载
     */
    public void resourceDownload(String resource,HttpServletRequest request,
                                    HttpServletResponse response) throws Exception{
        // 本地资源路径
        String localPath = Global.getProfile();
        // 数据库资源地址
        String downPath = localPath + StringUtils.substringAfter(resource, Constants.RESOURCE_PREFIX);

        String downloadName = StringUtils.substringAfterLast(downPath,"/");
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/from-data");
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + FileUtils.setFileDownloadHeader(request,downloadName));
        FileUtils.writeBytes(downPath,response.getOutputStream());


    }

}
