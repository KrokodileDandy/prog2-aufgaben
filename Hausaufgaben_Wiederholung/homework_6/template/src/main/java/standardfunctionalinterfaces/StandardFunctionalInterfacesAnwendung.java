package standardfunctionalinterfaces;

import java.time.LocalDateTime;
import java.util.function.*;

public class StandardFunctionalInterfacesAnwendung {

    public static void main(String[] args) {
        // 1.
        BiPredicate<String, String> fun1 = ((String s1, String s2) -> s1.length() < s2.length() ? true : false);

        // 2. -- own interface
        final double d = 10;
        PrimitiveDoubleSupplierInterface fun2 = () -> d*d;

        // 3.
        BiFunction<Integer, Integer, Double> fun3 = (Integer i1, Integer i2) -> Math.PI * i1 * i2;

        // 4. -- own interface
        PrimitiveIntBiFunction fun4 = (int i1, int i2) -> Math.PI * i1 * i2;

        // 5.
        Consumer<Object> fun5 = c -> {
            String str = c.toString();
            String[] strArr = str.split("\\.");
            System.out.println(strArr.length);
        };

        // 6. -- own interface
        TriConsumer<Object, Object, Object> fun6 = (a, b, c) -> {
            System.out.println(a.toString() + b.toString() + c.toString());
        };

        // 7.
        Supplier<Boolean> fun7 = () -> {
            LocalDateTime time = LocalDateTime.now();
            int minute = time.getMinute();
            if (minute % 2 == 1) return true;
            else return false;
        };

    }

}
