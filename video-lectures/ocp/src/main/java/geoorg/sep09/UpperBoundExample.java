package geoorg.sep09;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundExample {
    public static void main(String[] args) {

    }

    void bar() {
        final List<Integer> integers = new ArrayList<Integer>();
        final List<Double> doubles = new ArrayList<Double>();
        foo(doubles);
        foo(integers);
        List<? extends Number> numbers = doubles;
    }

    void foo(List<? extends Number> numbers) {
        numbers.get(0);
        for (Number number : numbers) {

        }
    }


}
