package com.deluxe.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BeanCopyUtils {

    private BeanCopyUtils() {

    }

    /**
     * 对象的复制，无需 new 一个新的对象
     * @param source 老对象
     * @param clazz 新对象字节码
     * @param <V> 新对象泛型
     * @return 返回新对象
     */
    public static <V> V copyBean(Object source, Class<V> clazz) {
        // 创建目标对象
        V result = null;

        try {
            // result = clazz.newInstance() // 旧方法，已被抛弃
            result = clazz.getDeclaredConstructor().newInstance();  // 新方法，异常封装到了一个 InvocationTargetException 类中
            // 实现目标的复制
            BeanUtils.copyProperties(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 返回结果
        return result;
    }

    /**
     *  List 集合对象的拷贝转换
     * @param list 老对象 List 集合
     * @param clazz  新对象字节码
     * @param <O>  老对象泛型
     * @param <V>  新对象泛型
     * @return  返回新对象的 List 集合
     */
    public static <O, V> List<V> copyBeanList(List<O> list, Class<V> clazz) {
        return list.stream()
                .map(o -> copyBean(o, clazz))
                .collect(Collectors.toList());
    }
}
