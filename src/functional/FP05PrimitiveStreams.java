package functional;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FP05PrimitiveStreams {

    public static void main(String[] args) {
        //Boxing
        System.out.println(IntStream.of(1, 2, 3).boxed().collect(Collectors.toList()));
        //Arrays to Stream
        int[] array = {4, 5, 6};
        Arrays.stream(array).forEach(System.out::println);
        //Factorial
        System.out.println(LongStream.rangeClosed(1, 10).reduce(1, (x, y) -> x * y));
        System.out.println(LongStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));
    }

}
