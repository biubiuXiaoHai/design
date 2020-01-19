package com.yunduo.utils;


import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.github.pagehelper.Page;

public class CloneUtil {
    static Logger logger = LoggerFactory.getLogger(CloneUtil.class);

    public static <T> T cloneObj(Object source, Class<T> tClass) {
        try {
            if (source == null) {
                return null;
            }
            T target = tClass.newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static <T> List<T> cloneList(List<?> source, Class<T> tClass){
        if(source == null){
            return null;
        }
        return source.stream().map(p -> CloneUtil.cloneObj(p, tClass)).collect(Collectors.toList());
    }

    public static <T> Page<T> clonePage(List<?> source, Class<T> tClass){
        if(source == null){
            return null;
        }
        Page<T> page = cloneObj(source, Page.class);
        List<T> list = cloneList(source, tClass);
        page.clear();
        page.addAll(list);
        return page;
    }
}
