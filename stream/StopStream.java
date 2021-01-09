import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * daiyu
 * 2021/1/6
 */
public class StopStream {
    // 终止 Stream
    // 操作1：匹配和查找
    @Test
    public void test1() {
        List<Student> list = StudentData.getStudents();
        // 1.判断所有的学生年龄是否都大于20岁
        boolean allMatch = list.stream().allMatch(item -> item.getAge() > 20);
        // 2.判断是否存在学生的年龄大于20岁
        boolean anyMatch = list.stream().anyMatch(item -> item.getAge() > 20);
        // 3. 判断是否存在学生叫曹操
        boolean noneMath = list.stream().noneMatch(item -> item.getName().equals("曹操"));
        // 4.查找第一个学生
        Optional<Student> first = list.stream().findFirst();
        // 5.查找所有学生数量
        long count = list.stream().count();
        long count1 = list.stream().filter(item -> item.getScore() > 20.0).count();
        // 6. 查找当前流中的元素
        Optional<Student> any = list.stream().findAny();
        // 7.查找学生最高的分数：Student 实现了comparable 接口的话，可直接比较
        Stream<Double> doubleStream = list.stream().map(item -> item.getScore());
        doubleStream.max(Double::compare);
    }

    // 操作2：规约
    @Test
    public void test2() {
        // 1.计算数的总和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        // 2.计算学生的总分数
        List<Student> studentList = StudentData.getStudents();
        Stream<Double> doubleStream = studentList.stream().map(Student::getScore);
        Optional<Double> reduce1 = doubleStream.reduce(Double::sum);
    }


    // 操作3：收集
    @Test
    public void test3() {
        List<Student> studentList = StudentData.getStudents();
        // 返回一个List
        List<Student> listStream = studentList.stream().filter(e -> e.getAge() > 18).collect(Collectors.toList());
        // 返回一个set
        Set<Student> setStream = studentList.stream().filter(e -> e.getAge() > 18).collect(Collectors.toSet());
    }
}
