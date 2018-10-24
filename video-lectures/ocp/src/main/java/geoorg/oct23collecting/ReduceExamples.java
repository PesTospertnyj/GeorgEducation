package geoorg.oct23collecting;

import geoorg.sep28streams.Department;
import geoorg.sep28streams.Employee;
import geoorg.sep28streams.StreamExamples;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by gd on 9/28/2018.
 */
public class ReduceExamples {



    public static void main(String[] args) {
        //reducing
        Optional<Integer> sum = IntStream.rangeClosed(1, 6)
                .mapToObj(i -> new Integer(i))
                .collect(Collectors.reducing(Integer::sum));
        System.out.println("sum = " + sum);

        Integer sumPlus20 = IntStream.rangeClosed(1, 6).mapToObj(i -> new Integer(i))
                .collect(Collectors.reducing(20, Integer::sum));
        System.out.println("sumPlus20 = " + sumPlus20);

        Integer sumAgePlus2000 = StreamExamples.createStream().collect(Collectors.
                reducing(2000, Employee::getAge, Integer::sum));
        System.out.println("sumAgePlus2000 = " + sumAgePlus2000);
    }

}
