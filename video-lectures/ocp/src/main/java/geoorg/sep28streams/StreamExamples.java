package geoorg.sep28streams;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by gd on 9/28/2018.
 */
public class StreamExamples {
    public static void main(String[] args) {

        Stream<Employee> stream = createStream();
        System.out.println(stream.count());

        Comparator<Employee> salaryComparator = Comparator.comparing(
                (Employee e) -> {
                    return e.getSalary();
                }
        );

        Comparator<Employee> salaryComparator2 = Comparator.comparing(
                Employee::getSalary);

        Comparator<Employee> ageComparator = (e1, e2) -> e1.getAge() - e2.getAge();

        stream = createStream();
        System.out.println("employee with min salary " + stream.min(salaryComparator));
        stream = createStream();
        System.out.println("employee with max age " + stream.max(ageComparator));

        stream = createStream();
        System.out.println("findAny = " + stream.parallel().findAny());

        stream = createStream();
        System.out.println("findFirst = " + stream.parallel().findFirst());

        stream = createStream();
        System.out.println("allMatch = " + stream.allMatch(
                (e) -> e.getAge() > 18
        ));

        final Predicate<Person> ageGreater20 = (p) -> p.getAge() > 20;

        stream = Stream.generate(() -> new Employee("unknown", 21, Math.random()*1000)
        );
        System.out.println("any Match " + stream.anyMatch(ageGreater20));

        stream = createStream();

        Consumer<Person> personPrint = (p) -> System.out.print(p.getName());
        Consumer<Person> personPrint2 = Person::printMyAge;
        System.out.println("For each result:");
        stream.forEach(personPrint2);

        Stream<Double> doubleStream = Stream.of(1.0, 3.0, -2.0);
        BinaryOperator<Double> addition = (d1, d2) -> d1 + d2;
//        BinaryOperator<Integer> addition2 = Integer::;
        Optional<Double> reduce = doubleStream.reduce(addition);
        System.out.println("reduce " + reduce);




    }

    public static Stream<Employee> createStream() {
        Employee employee1 = new Employee("Ivan", 25, 1000);
        Employee employee2 = new Employee("Ivan", 26, 1200);
        Employee employee3 = new Employee("Peter", 20, 800);
        Employee employee4 = new Employee("Mariya", 23, 1300);
        Employee employee5 = new Employee("Sidor", 19, 1100);

        return Stream.of(employee1, employee2, employee3, employee4, employee5);
    }
}
