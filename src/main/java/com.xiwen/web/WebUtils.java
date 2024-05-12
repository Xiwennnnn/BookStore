package com.xiwen.web;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {
    public static <T>  T copyParamToBean(Map value, T bean) {
        try{
            BeanUtils.populate(bean, value);
            return bean;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
