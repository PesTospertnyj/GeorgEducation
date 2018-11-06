package geoorg.nov03additional.collectors;

import geoorg.sep28streams.Department;
import geoorg.sep28streams.Employee;
import geoorg.sep28streams.StreamExamples;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by gd on 11/3/2018.
 */
public class AdditionalCollectorsExamples {
    public static void main(String ... args) {
        Stream<Employee> employeeStream = StreamExamples.createStream();
        employeeStream.forEach(System.out::println);

        //
        Function<List<Employee>, Integer> sizeFunction = Collection::size;

        Integer size = StreamExamples.createStream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), sizeFunction));

        List<Employee> employees = StreamExamples.createStream().collect(Collectors.toList());
        Integer sizeEmployees = sizeFunction.apply(employees);

        System.out.println();
        
    }
}
