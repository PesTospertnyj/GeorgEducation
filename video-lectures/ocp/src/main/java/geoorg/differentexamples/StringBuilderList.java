package geoorg.differentexamples;

import geoorg.Person;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class StringBuilderList
{
    public static void main(String[] args) {
        List list = Arrays.asList(new StringBuilder(10).append("Webby"), new String());
        Object obj = list.get(0);
        list.set(0, obj.toString().length());

        System.out.println(list);

        List<StringBuilder> list2 = new ArrayList(Arrays.asList(new StringBuilder(10).append("Webby"),
                new StringBuilder(20).append("Guffy")));

        Stream<String> stringStream = list2.stream().map((strBuilder) -> strBuilder.toString());
        List<String> collect = stringStream.collect(Collectors.toList());
        System.out.println(collect);

    }


}
