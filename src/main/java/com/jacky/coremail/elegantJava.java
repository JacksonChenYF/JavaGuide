package com.jacky.coremail;

import javax.xml.transform.Result;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * 1、工具类不应该被实例化，应为每个工具类 显示定义私有构造函数来屏蔽隐式公有构造函数。
 */
public class elegantJava {

    /**
     * 1 当循环中只需要 Map 的主键时，迭代 keySet() 是正确的。
     * 但是，当需要主键和取值时，迭代 entrySet() 才是更高效的做法，
     * 比先迭代 keySet() 后再去 get 取值性能更佳。
     */
    public static void useMap() {
        Map<String, String> map = new HashMap<>();
        //反例
        for (String key : map.keySet()) {
            String value = map.get(key);
        }
        //正例
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
        }

    }

    /**
     * 在 java 集合类库中，List 的 contains 方法普遍时间复杂度是 O(n) ，
     * 如果在代码中需要频繁调用 contains 方法查找数据，可以先将 list 转换成 HashSet 实现，
     * 将 O(n) 的时间复杂度降为 O(1) 。
     */
    public void useList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            //时间复杂度O（n）
            list.contains(i);
        }

        Set<Integer> set = new HashSet(list);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            //时间复杂度O（1）
            set.contains(i);
        }
    }


    /**
     * 返回空数组和空集合而不是 null
     * 返回 null ，需要调用方强制检测 null ，否则就会抛出空指针异常。返回空数组或空集合，
     * 有效地避免了调用方因为未检测 null 而抛出空指针异常，还可以删除调用方检测 null 的语句使代码更简洁。
     *
     * @return
     */
    public static List<Result> getResultList() {
        //return null;
        return Collections.emptyList();
    }

    public static void main(String[] args) {

        List<Result> resultList = getResultList();
        for (Result result : resultList) {
            System.out.println("ok");
        }
        /*if (resultList != null) {
            for (Result result : resultList) {
            System.out.println("ok");
            }
        }*/


        //禁止使用构造方法BigDecimal(double)
        BigDecimal value = new BigDecimal(0.1D); // 0.100000000000000005551115...
        BigDecimal trueValue = BigDecimal.valueOf(0.1D);// 0.1
        System.out.println(value + "  " + trueValue);


        // 新特性新的时间表示
        LocalDate jdk14 = LocalDate.of(2020, 3, 17);
        LocalDate nowDate = LocalDate.now();
        System.out.println("距离JDK 14 发布还有：" + nowDate.until(jdk14, ChronoUnit.DAYS) + "天");
        System.out.println();

    }
}
