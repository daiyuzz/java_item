package com.daiyu.shiroexample.testOne;


import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * created by dyx on 2021/8/11
 **/
public class test_1 {
    public static void main(String[] args) {
        Student stuA = new Student(1, "A", "M", 184);
        Student stuG = new Student(1, "A", "M", 100);
        Student stuB = new Student(2, "B", "G", 163);
        Student stuC = new Student(3, "C", "M", 175);
        Student stuD = new Student(4, "D", "G", 158);
        Student stuE = new Student(5, "A", "M", 158);
        List<Student> list = new ArrayList<>();
        list.add(stuA);
        list.add(stuB);
        list.add(stuC);
        list.add(stuD);
        list.add(stuE);

        // stream-forEach循环
        System.out.println("***********stream-forEach***********");
        list.stream().forEach(stu -> System.out.println("stream-forEach: " + stu.getName()));

        // stream-filter过滤即执行逻辑
        System.out.println("***********stream-filter count***********");
        long count = list.stream().filter(stu -> stu.height > 180).count();
        list.stream().filter(stu -> stu.height > 180)
                .forEach(stu -> System.out.println("stream-filter: " + stu));

        // Stream-toMap 为了避免key冲突情况，(key1, key2) -> key1 表示冲突时取前者
        System.out.println("***********Stream-toMap 字段:对象***********");
        Map<String, List<Student>> maps = list.stream().collect(Collectors.toMap(Student::getName,
                e -> new ArrayList<>(Arrays.asList(e)),
                (List<Student> oldList, List<Student> newList) -> {
                    oldList.addAll(newList);
                    return oldList;
                }));

        System.out.println("key-对象" + maps);

        Map<String, Object> newMaps = list.stream()
                .collect(Collectors.toMap(Student::getName, Student::getHeight, (key1, key2) -> key1));
        System.out.println("key-字段" + newMaps);

        // Stream-distinct 去重
        System.out.println("***********Stream-distinct去重  必须重写equals和hashcode方法***********");
        list.stream()
                .distinct()
                .forEach(b -> System.out.println("Stream-distinct去重  " + b.getName() + "," + b.getHeight()));


        // 过滤后得到新集合
        System.out.println("***********Stream操作后获取聚合集合***********");
        List<Student> newList = list.stream().filter(stu -> stu.height > 165)
                .collect(Collectors.toList());
        System.out.println("新集合: " + newList);

        // stream-聚合操作  最大值，最小值
        System.out.println("**************stream-聚合操作  最大值，最小值************");
        System.out.println("sum: " + list.stream().mapToDouble(Student::getHeight).sum());
        System.out.println("max: " + list.stream().mapToDouble(Student::getHeight).max().getAsDouble());
        System.out.println("min: " + list.stream().mapToDouble(Student::getHeight).min().getAsDouble());
        System.out.println("avg: " + list.stream().mapToDouble(Student::getHeight).average().getAsDouble());

        // Stream排序
        System.out.println("**************stream-聚合操作  排序************");
        List<Student> collect = list.stream().filter(stu -> stu.getHeight() > 165)
                .sorted((e1, e2) -> Float.compare(e1.getHeight(), e2.getHeight()))
                .collect(Collectors.toList());
        System.out.println("stream 排序" + collect);
    }
}

