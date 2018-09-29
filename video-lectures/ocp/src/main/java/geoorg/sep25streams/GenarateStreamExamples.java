package geoorg.sep25streams;

import java.util.stream.Stream;

/**
 * Hello world!
 *
 */

public class GenarateStreamExamples
{
    public static void main(String[] args) {
        Stream<Double> doubleStream =
                Stream.generate(Math::random);

        long count = doubleStream.limit(5).filter(d -> {
            System.out.println("process d = " + d);
            return d > 0.5;
        }).count();

        System.out.println(count);
    }
}
