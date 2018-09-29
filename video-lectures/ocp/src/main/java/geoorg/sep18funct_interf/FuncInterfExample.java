package geoorg.sep18funct_interf;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.function.*;

/**
 * Created by gd on 9/18/2018.
 */
public class FuncInterfExample {
    public static void main(String[] args) {
        Predicate<List> ex1 = x -> {
            return "".equals(x.get(0));
        };
        Consumer<Long> ex2 = (Long l) -> {
            System.out.println(l);
            return;
        };

        BiPredicate<String, String> ex3 = (String s1, String s2) ->
        {
            return false;
        };

        Function<List<String>, String> ex4 = (List<String> x) -> {
            return x.get(0);
        };

        UnaryOperator<Long> ex5 = (Long l) -> {
            return (long)3.14;
        }; // DOES NOT COMIPLE

        Predicate<String> ex6 = (String x) ->
        {
            return x.isEmpty();
        };

        Predicate<String> ex7 = String::isEmpty;
    }
}
