package geoorg.oct17streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by gd on 9/28/2018.
 */

public class PrimitiveFuncInterExamples {


    public static void main(String[] args) {
        IntToDoubleFunction f = (i) -> i / 2.0;
        IntStream.rangeClosed(1, 5).mapToDouble(f).forEach(System.out::println);

        List<String> cats = new ArrayList<>();
        cats.add("Annie");
        cats.add("Ripley");
        Stream<String> stream = cats.stream().map((s) -> s.substring(0,3));
        cats.add("KC123");
        stream.forEach(System.out::println);

        threeDigit(Optional.empty());
        threeDigit(Optional.of(12));
        threeDigit(Optional.of(123));

        Optional<Integer> integerOptional = Optional.of(34);
        Optional<Integer> integerOptional2 = integerOptional.map((i) -> i + 1);

    }

    private static void threeDigit(Optional<Integer> optional) {
        optional.map(n -> "" + n)             // part 1
                .filter(s -> s.length() == 3)      // part 2
                .ifPresent(System.out::println);   // part 3
    }
}
