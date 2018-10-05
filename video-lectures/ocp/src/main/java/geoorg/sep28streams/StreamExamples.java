package geoorg.sep28streams;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
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
        BinaryOperator<Double> addition2 = Double::sum;
        Optional<Double> reduce = doubleStream.reduce(addition2);
        System.out.println("reduce " + reduce);

        Stream<Integer> integerStream = Stream.empty();//Stream.of(5, 8, -3);
        Integer reduce1 = integerStream.reduce(2, (i1, i2) -> i1*i2);
        System.out.println("reduce 1 = " + reduce1);

        Function<Integer, Integer> identityFunction = Function.identity();
        Integer apply = identityFunction.apply(23);
        System.out.println("identity function result = " + apply);

        //reduce 3
        stream = createStream();
        final Double sumSalary = stream.reduce(0.0, (final Double oldSum, final Employee currentEmployee) ->
                {
                    return oldSum + currentEmployee.getSalary();
                }
                , Double::sum);
        System.out.println("sum salary " + sumSalary);

        final BiFunction<Integer, Person, Integer> ageFunction =
                (Integer oldSumAge, Person person) -> oldSumAge + person.getAge();
        final int sumAge = createStream().reduce(0, ageFunction, Integer::sum);
        System.out.println("sumAge = " + sumAge);

        //collect 1
        ArrayList<Employee> collect = createStream().parallel().collect(
                () -> {
                    System.out.println("supplier was invoked");
                    return new ArrayList<Employee>();
                },
                (ArrayList<Employee> list, Employee employee) -> {
                    System.out.println("accumulator was invoked list size = " + list.size() + " emp = " + employee);
                    list.add(employee);
                },
                (ArrayList<Employee> list1, ArrayList<Employee> list2) -> {
                    System.out.println("combiner was invoked " + list1 + " " + list2);
                    list1.addAll(list2);
                }
        );
        System.out.println("collect size = " + collect.size() + " result " + collect);

        List<Employee> collect1 = createStream().collect(Collectors.toList());
        System.out.println("collect size = " + collect1.size() + " result " + collect1);


    }

    public static List<Departament> createDepartaments() {
        Employee employee1 = new Employee("Ivan", 25, 1000);
        Employee employee2 = new Employee("Ivan", 26, 1200);
        Departament departament = new Departament("IT", Arrays.asList(employee1, employee2));

        Employee employee3 = new Employee("Peter", 20, 800);
        Employee employee4 = new Employee("Mariya", 23, 1300);
        Employee employee5 = new Employee("Sidor", 19, 1100);
        Departament departament2 = new Departament("Support", Arrays.asList(employee3, employee4, employee5 ));
        return Arrays.asList(departament, departament2);
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
