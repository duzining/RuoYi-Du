package com.du.common.annotation;

import com.du.common.enums.DataSourceType;

import java.lang.annotation.*;

/**
 * 数据源注解
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource {

    /**
     * 切换数据源名称
     */
    public DataSourceType value() default DataSourceType.MASTER;
}
