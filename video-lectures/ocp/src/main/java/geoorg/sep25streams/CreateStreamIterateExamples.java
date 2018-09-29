package geoorg.sep25streams;

import java.util.stream.Stream;

/**
 * Hello world!
 *
 */

public class CreateStreamIterateExamples
{
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.iterate(5,
                (Integer i) ->
                {
                    return i * 2;
                });

        //integerStream.limit(6).forEach(System.out::print);

        integerStream.forEach((Integer i)
                ->
        {
            System.out.println(i);
        });




    }
}
