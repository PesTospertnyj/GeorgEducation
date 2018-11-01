package geoorg.oct27additional.stream;

import geoorg.sep28streams.Department;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by gd on 10/27/2018.
 */
public class AdditionalStreamExamples {

    public static void main(final String ... args) {
        Stream.Builder<Integer> builder = Stream.<Integer>builder()
                .add(12)
                .add(13)
                .add(34);

        System.out.println("some logic gor=es here");

        builder.add(-1);

        Stream<Integer> stream = builder.build();
//        Stream<Integer> stream2 = builder.build();

        stream.forEach(System.out::println);
//        System.out.println("stream 2");
//        stream2.forEach(System.out::println);

//        builder.add(-2);

        List<Integer> integers = Arrays.asList(1, 2, 3);
        Stream<Integer> stream3 = integers.stream();
        Stream<Integer> stream4 = integers.stream();
        Stream<Integer> stream5 = integers.stream();
        Stream<Integer> stream6 = integers.stream();

        Stream<Integer> concatStream = Stream.concat(stream3, stream4);
        Stream.concat(stream5, stream6);
//        concatStream = Stream.concat(concatStream, stream5);

//        stream3.count();//Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        System.out.println("concat stream size = " + concatStream.count());


        Department department = null;
        department.staticMethod();

        System.out.println("parallel stream:");
        integers.stream().parallel().forEach(System.out::println);

        Object[] objects = integers.stream().toArray();
        System.out.println();

        integers.stream().toArray();

        Integer[] integerArray = Stream.iterate(0, (i) -> i + 1).limit(50)
                .toArray((i) -> new Integer[i]);
        System.out.println();

        Integer[] integers1 = integers.toArray(new Integer[3]);
        System.out.println();
    }
}
