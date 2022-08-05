package org.zxbro.store.keeper.utils;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.ArrayList;
import java.util.List;

public class ModelUtils {
    public static <T> T beanConvert(Object from, Class<T> to) {
        return beanConvert(from, to, null);
    }

    public static <T> T beanConvert(Object from, Class<T> clazz, Converter converter) {
        try {
            T t = null;
            if (from != null) {
                t = clazz.newInstance();
                BeanCopier beanCopier = BeanCopier.create(from.getClass(), clazz, converter != null);
                beanCopier.copy(from, t, converter);
            }
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> beanConvertList(List<? extends Object> from, Class<T> clazz) {
        return beanConvertList(from, clazz, null);
    }

    public static <T> List<T> beanConvertList(List<? extends Object> from, Class<T> clazz, Converter converter) {
        try {
            List<T> t = null;
            if (from != null && !from.isEmpty()) {
                t = new ArrayList<>();
                for (Object item : from) {
                    if (null != item) {
                        t.add(beanConvert(item, clazz, converter));
                    }
                }
            }
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
