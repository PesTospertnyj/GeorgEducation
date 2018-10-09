package geoorg.sep28streams;

import java.util.*;
import java.util.function.Consumer;
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
        Supplier<Stream<Employee>> streamEmployeeSupplier = () -> {
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

        Stream<String> stringStream = streamEmployeeSupplier.get().map(employeeObjectFunction);

        Stream<Object> objectStream = streamEmployeeSupplier.get().map(personStringFunction);
        Stream<Object> objectStream2 = streamEmployeeSupplier.get().map(employeeObjectFunction1);

        stringStream.forEach(System.out::println);

        //flat map example
        Supplier<Stream<Departament>> deparatamentStreamSupplier = () -> {
            return StreamExamples.createDepartaments().stream();
        };

        Stream<Employee> employeeStream = deparatamentStreamSupplier.get().flatMap((Departament departament) -> departament.getEmployees().stream());
        employeeStream.forEach(System.out::println);

        Stream<List<Employee>> listStream = deparatamentStreamSupplier.get().map((dep) -> dep.getEmployees());

        //sorted
        System.out.println("sorted method:");
//        streamEmployeeSupplier.get().sorted().forEach(System.out::println);

        //sorted 2
        System.out.println("sorted using comparator:");
        final Comparator<Employee> salaryComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getSalary() - o2.getSalary());
            }
        }.reversed();
        streamEmployeeSupplier.get().sorted(salaryComparator).forEach(System.out::println);

        //reveredOrder example
        System.out.println("reveredOrder example:");
//        Stream.of("1", "two", "3", "two").sorted(Comparator::reverseOrder).forEach(System.out::println);

        //
        System.out.println("peek example");
        final Consumer<Object> toStringConsumer = (Object o) -> System.out.println(o);
        long count = streamEmployeeSupplier.get().peek(toStringConsumer).filter((Person p) -> p.getAge() > 20).count();
        System.out.println("result " + count);

        //hung
        System.out.println("hung example");
        Stream<Integer> generateStream = Stream.generate(() -> 1);
        Stream<Integer> stream2 = generateStream.sorted(Integer::compareTo);
        foo(stream2);
//        stream2.forEach(System.out::println);
    }

    private static void foo(Stream<Integer> stream2) {
        if (new Random().nextBoolean()) {
            stream2.forEach(System.out::println);
        }
    }


}
