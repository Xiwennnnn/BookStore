package com.xiwen.web;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {
    /**
     * 用来将requst中的参数导入bean中
     * @param value req.getParameterMap()
     * @param bean JavaBean类
     * @return 返回一个JavaBean类
     * @param <T>
     */
    public static <T>  T copyParamToBean(Map value, T bean) {
        try{
            BeanUtils.populate(bean, value);
            return bean;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static int parseInt(String value, int defaultValue) {
        try {
            if(value != null && !"".equals(value)) {
                return Integer.parseInt(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

    public static Double parseFloat(String value, Double defaultValue) {
        try {
            if(value != null && !"".equals(value)) {
                return Double.parseDouble(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
