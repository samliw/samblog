package com.sam.blog.common.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.*;


public class SystemContextUtils {
    /**
     * 对象空字符串转为Null
     * @param obj
     * @param clazz
     * @return
     */
    public static <T> T nullStringToNull(Object obj, Class<T> clazz ){
        String str = JSONObject.toJSONString(obj);
        Map<String, Object> stringObjectMap = JSONObject.parseObject(str, Map.class);
        Iterator<Map.Entry<String, Object>> it = stringObjectMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            if(null != entry.getValue() && "".equals(entry.getValue())){
                it.remove();
            }
        }
        return JSONObject.parseObject(JSONObject.toJSONString(stringObjectMap), clazz);
    }

    /**
     * copy d对象去掉空字符串
     * @param source
     * @param target
     * @return
     */
    public static void copyBean(Object source, Object target){
        BeanUtils.copyProperties(source, target, getNullField(source));
    }

    /**
     * 获取属性中为空的字段
     *
     * @param target
     * @return
     */
    private static String[] getNullField(Object target) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(target);
        PropertyDescriptor[] propertyDescriptors = beanWrapper.getPropertyDescriptors();
        Set<String> notNullFieldSet = new HashSet<>();
        if (propertyDescriptors.length > 0) {
            for (PropertyDescriptor p : propertyDescriptors) {
                String name = p.getName();
                Object value = beanWrapper.getPropertyValue(name);
                if (Objects.isNull(value)) {
                    notNullFieldSet.add(name);
                }
            }
        }
        String[] notNullField = new String[notNullFieldSet.size()];
        return notNullFieldSet.toArray(notNullField);
    }


}
