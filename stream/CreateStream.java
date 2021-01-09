import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * daiyu
 * 2021/1/6
 */
public class CreateStream {

    // 2.创建stream

    // 方式一，通过一个集合创建Stream
    @Test
    public void test1() {
        List<Student> studentList = StudentData.getStudents();
        // 第一种，返回一个顺序流
        Stream<Student> stream = studentList.stream();
        // 第二种，返回一个并行流
        Stream<Student> stream2 = studentList.parallelStream();
    }

    // 方式二，通过一个数组创建Stream
    @Test
    public void test2() {
        // 获取一个整形Stream
        int[] arr = new int[]{1, 2, 34, 4, 56, 7, 78,};
        IntStream intStream = Arrays.stream(arr);
        // 获取一个Student对象Stream
        Student[] students = StudentData.getArrStudents();
        Stream<Student> stream = Arrays.stream(students);
    }

    //方式三，通过Stream.of
    @Test
    public void test3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8);
        Stream<String> stringStream = Stream.of("1", "2", "3", "4", "5");
        Stream<Student> studentStream = Stream.of(
                new Student(1, "刘备", 18, 90.4),
                new Student(2, "张飞", 19, 87.4),
                new Student(3, "关羽", 21, 67.4));
    }

    // 方式四，创建一个无线流
    @Test
    public void test4() {
        // 每隔5个数取一个，从0开始，此时就会无限循环
        Stream.iterate(0, t -> t + 5).forEach(System.out::println);
        // 每隔5个取一个，从0开始，只取前5个数
        Stream.iterate(0, t -> t + 5).limit(5).forEach(System.out::println);
        // 取出一个随机数
        Stream.generate(Math::random).limit(5).forEach(System.out::println);

    }
}
