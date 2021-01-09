import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * daiyu
 * 2021/1/6
 */
public class OperationStream {

    // 操作1，筛选和切片
    @Test
    public void test1() {
        List<Student> list = StudentData.getStudents();
        // 1.过滤：过滤出所有年龄大于20岁的同学
        list.stream().filter(item -> item.getAge() > 20).forEach(System.out::println);
        // 2.截断流：筛选出前3条数据
        list.stream().limit(3).forEach(System.out::println);
        // 3.跳过元素：跳过前5个元素
        list.stream().skip(5).forEach(System.out::println);
        // 4.过滤重复元素
        list.stream().distinct().forEach(System.out::println);
    }

    // 操作2：映射
    @Test
    public void test2() {
        // 1. map操作
        List<String> list = Arrays.asList("java", "python", "go");
        Stream<String> stream = list.stream();
        // 此时每一个小写都有一个大写的映射 map 将流中的每一个值换成另外一个值
        stream.map(str -> str.toUpperCase()).forEach(System.out::println);
        // 筛选出所有的年龄，再过滤出所有年龄大于20
        List<Student> studentList = StudentData.getStudents();
        Stream<Student> stream1 = studentList.stream();
        Stream<Integer> ageStream = stream1.map(Student::getAge);
        ageStream.filter(age -> age > 20).forEach(System.out::println);

    }

    //操作3：排序
    @Test
    public void test3() {
        // 1.自然排序
        List<Integer> list = Arrays.asList(4, 2, 4, 5, 76, 8, 6);
        Stream<Integer> stream = list.stream();
        stream.sorted().forEach(System.out::println);

        //2 对象排序：对象类可以先实现 comparable接口，或者是直接指定
        // 第一种，实现comparable接口
        List<Student> studentList = StudentData.getStudents();
        studentList.stream().sorted().forEach(System.out::println);
        // 第二种，直接指定comparable
        List<Student> studentList1 = StudentData.getStudents();
        studentList1.stream().sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())).forEach(System.out::println);
    }

}
