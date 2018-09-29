package geoorg.sep01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SummaryExample {
    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();

        List<Number> numbers2 = new ArrayList<>();
        List<Object> objects = new ArrayList<>();

        Collections.copy(numbers, numbers2);
        Collections.copy(objects, integers );

        bar(new ArrayList<Exception>());
        List<? super IOException> exceptions = null;
        exceptions.add(new IOException());
    }

    static void bar(List<? super IOException> exceptions) {
        exceptions.add(new IOException());
    }
}
