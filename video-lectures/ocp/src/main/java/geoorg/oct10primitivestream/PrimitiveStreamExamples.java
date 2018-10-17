package geoorg.oct10primitivestream;


import geoorg.sep28streams.Employee;
import geoorg.sep28streams.StreamExamples;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class PrimitiveStreamExamples
{
    private static class DoubleBox {
        private double value;

        public DoubleBox(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        IntStream intStream = IntStream.of(12, 34, (char) 'h', (byte) 12, (short) 34);
        OptionalDouble average = intStream.average();
        System.out.println(average.getAsDouble());

        //
        DoubleStream doubleStream = DoubleStream.iterate(1, (double current) -> current / 2);
        double sum = doubleStream.limit(20).sum();
        System.out.println("sum of sequence is " + sum);

        //
        IntStream rangeClosed = IntStream.range(1, 5);
        rangeClosed.forEach(System.out::println);

        //
        Stream<Employee> employeeStream = StreamExamples.createStream();
        DoubleStream salaryStream = employeeStream.mapToDouble((Employee e) -> {
            return e.getSalary();
        });
        System.out.println("Sum salary is " + salaryStream.sum());

        System.out.println("long map to obj");
        LongStream.of(8, 16, 2, 23, 24, 45).mapToObj((long l) -> Long.toOctalString(l)).forEach(System.out::println);

        double sum1 = LongStream.of(8, 16, 2, 23, 24, 44).mapToDouble(l -> l * 2.5 ).sum();
        System.out.println("sum of double " + sum1);

//        IntStream intStream1 = IntStream.of(2, 4, 8, 9);
//        IntStream squeredStream = intStream1.map(x -> x * x);
//        double s2 = squeredStream.sum();
        //long numberOfElements = intStream1.count();
        //double aver2 =  s2 / IntStream.of(2, 4, 8, 9).count();
        //.out.println("sum of squared values is " + s2);

        //
        IntStream intStream2 = IntStream.of(2, 4, 8, 9);
        IntSummaryStatistics intSummaryStatistics = intStream2.summaryStatistics();
        int max = intSummaryStatistics.getMax();
        int min = intSummaryStatistics.getMin();
        long count = intSummaryStatistics.getCount();
        System.out.println(String.format("statistics = [%d] [%d] [%d]" , min, max, count));
        System.out.println("range = " + (max - min));

        //
        DoubleStream doubleStream1 = DoubleStream.of(2.0, 4);
        final DoubleBox doubleBox = new DoubleBox(0.0);
        DoubleSummaryStatistics doubleSummaryStatistics = doubleStream1.peek(d -> {
            double currentSum = doubleBox.getValue();
            doubleBox.setValue(currentSum + d * d);
        }).summaryStatistics();

        System.out.println("squared / n = " + doubleBox.getValue() / doubleSummaryStatistics.getCount());

    }

    private static void foo() {
        List<? super IOException> exceptions = null;//new ArrayList<Object>();
        bar(new ArrayList<IOException>());
    }

    private static void bar(List<? super IOException> exceptions) {
        exceptions.add(new Exception());	 // DOES NOT COMPILE
        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());
    }


}
