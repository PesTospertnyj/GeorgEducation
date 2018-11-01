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
public class Examples {

    public static void main(String[] args) {
        Stream<Employee> employeeStream = StreamExamples.createStream();
        employeeStream.forEach(System.out::println);

        employeeStream = StreamExamples.createStream();
        Double averageSalary = employeeStream.collect(Collectors.averagingDouble(
                (employee) -> employee.getSalary()));

        System.out.println("average salary " + averageSalary);

        employeeStream = StreamExamples.createStream();
        Double averageAge = employeeStream.collect(Collectors.averagingInt((employee) -> employee.getAge()));
        System.out.println("averageAge " + averageAge);

        //counting
        Long count = StreamExamples.createStream().collect(Collectors.counting());
        System.out.println("count = " + count);

        System.out.println(StreamExamples.createStream().count());

        //grouping
        Map<Department, List<Employee>> employeesByDepartment = StreamExamples.createStream().collect(
                Collectors.groupingBy((employee) -> employee.getDepartment()));

        System.out.println("employeesByDepartment " + employeesByDepartment);

        String allEmployeesNames = StreamExamples.createStream().map((e) -> e.getName()).
                collect(Collectors.joining(" ; ", "Mr/Mrs ", " - good employee"));

        System.out.println("allEmployeesNames = " + allEmployeesNames);

        //
        Map<Department, Set<Employee>> empoyeesByDepartmentSet = StreamExamples.createStream().collect(
                Collectors.groupingBy((e) -> e.getDepartment(), Collectors.toSet())
        );
        System.out.println("empoyeesByDepartmentSet = " + empoyeesByDepartmentSet);

        //
        Map<Department, List<String>> employeesNamesByDepMap = StreamExamples.createStream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("employeesNamesByDepMap = " + employeesNamesByDepMap);

        Map<Department, Long> employeesNumberByDepartmentMap = StreamExamples.createStream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                Collectors.counting()));

        Map<Department, Double> totalSalaryByDepartmentMap = StreamExamples.createStream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.summingDouble(Employee::getSalary)
                ));

        //
        TreeMap<Department, Set<Employee>> empoyeesByDepartmentTreeMap = StreamExamples.createStream().collect(
                Collectors.groupingBy((e) -> e.getDepartment(), () -> new TreeMap(Comparator.comparing(Department::getName).reversed()), Collectors.toSet())
        );
        System.out.println("empoyeesByDepartmentTreeMap = " + empoyeesByDepartmentTreeMap);

        //max by, mim by
        Optional<Employee> employeeWithMaxSalary = StreamExamples.createStream().collect(Collectors.maxBy(Comparator.comparing((emp) -> emp.getSalary())));
        System.out.println("employeeWithMaxSalary " + employeeWithMaxSalary);

        Map<Boolean, List<Employee>> mapSalaryGreater1100 = StreamExamples.createStream().collect(Collectors.partitioningBy((employee) -> employee.getSalary() > 1100));
        System.out.println("mapSalaryGreater1100 " + mapSalaryGreater1100);

        //summary statistics
        DoubleSummaryStatistics salaryStatistics = StreamExamples.createStream().collect(Collectors.summarizingDouble((employee) -> employee.getSalary()));
        System.out.println("salaryStatistics = " + salaryStatistics);

        List<Employee> employees = StreamExamples.createStream().collect(Collectors.toList());
        Set<Employee> employeesSet = StreamExamples.createStream().collect(Collectors.toSet());

        LinkedList<Employee> linkedList = StreamExamples.createStream().collect
                (Collectors.toCollection(() -> new LinkedList<Employee>()));
        System.out.println("treeSetEmployyes = " + linkedList);

        Set<Employee> set = StreamExamples.createStream().collect
                (Collectors.toCollection(() -> new TreeSet<Employee>(
                        Comparator.comparing(Employee::getAge)
                )));
        System.out.println("set = " + set);

        //toMap
        Map<String, Employee> name2EmployeeMap = StreamExamples.createStream().collect(Collectors.toMap(
                (employee) -> employee.getName(), (employee) -> employee));
        System.out.println();

        //
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears", "bears");
        Map<String, Integer> map = ohMy.collect(
                Collectors.toMap(Function.identity(), String::length, Integer::sum, TreeMap::new));
        System.out.println(map); // {lions=5, bears=5, tigers=6}



    }

    <R> R foo(Collector<Employee, Employee, R> collector) {
        return StreamExamples.createStream().collect(collector);
    }
}
