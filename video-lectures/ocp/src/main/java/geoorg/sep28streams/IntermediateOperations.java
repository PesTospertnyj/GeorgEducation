package geoorg.sep28streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static geoorg.sep28streams.StreamExamples.createStream;

/**
 * Hello world!
 *
 */
public class IntermediateOperations
{
    public static void main(String[] args) {
        Predicate<Person> older26 = (Person person) -> {
            System.out.println("predicate was invoked for person " + person);
            return person.getAge() > 20;
        };


        StreamExamples.createStream().limit(3).filter(older26).distinct().forEach((Employee employee) -> {
            System.out.println("terminal operation for employee " + employee);
        });

        createStream().filter(( emp) ->
            emp.getAge() > 500.0
        ).forEach(System.out::println);

        Stream.of("1", "two", "3", "two").skip(2).limit(2).distinct().forEach(System.out::println);

        //map example
        Supplier<Stream<Employee>> streamSupplier = () -> {
            return createStream();
        };

        Function<Employee, String> employeeObjectFunction = (Employee employee) -> {
            return employee.getName();
        };

        Function<Person, String> personStringFunction = (Person person) -> {
            return person.getName();
        };
        Function<Employee, Object> employeeObjectFunction1 = (Employee person) -> {
            return person.getName();
        };

        Stream<String> stringStream = streamSupplier.get().map(employeeObjectFunction);

        Stream<Object> objectStream = streamSupplier.get().map(personStringFunction);
        Stream<Object> objectStream2 = streamSupplier.get().map(employeeObjectFunction1);

        stringStream.forEach(System.out::println);

        //flat map example
        Supplier<Stream<Departament>> deparatamentStreamSupplier = () -> {
            return StreamExamples.createDepartaments().stream();
        };

        Stream<Employee> employeeStream = deparatamentStreamSupplier.get().flatMap((Departament departament) -> departament.getEmployees().stream());
        employeeStream.forEach(System.out::println);

        Stream<List<Employee>> listStream = deparatamentStreamSupplier.get().map((dep) -> dep.getEmployees());

    }

}
