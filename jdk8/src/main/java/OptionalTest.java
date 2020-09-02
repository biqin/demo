import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalTest {
    public static void test(){

        OptionalTest java8Tester = new OptionalTest();
        Integer value1 = null;
        Integer value2 = new Integer(10);

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        System.out.println(java8Tester.sum(a,b));

        Optional<List<Integer>> listOptional = Optional.ofNullable(Arrays.asList(1,23));
        System.out.println(listOptional.map(List::size).orElse(0));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b){

        // Optional.isPresent - 判断值是否存在

        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());

        Optional<Integer> c = b.filter(aa -> aa == 10);
        Optional<Integer> d = b.filter(aa -> aa == 12);
        Optional<Integer> e = a.filter(aa -> aa == 12);

        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get - 获取值，值需要存在
        Integer value2 = b.get();
        return value1 + value2;
    }
}