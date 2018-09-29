package geoorg.sep13.iteration;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by gd on 9/13/2018.
 */

class Bag<T> implements Iterable<T> {

    private List<T> stringList;

    public Bag(List<T> stringList) {
        this.stringList = stringList;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < stringList.size();
            }

            @Override
            public T next() {
                return stringList.get(i++);
            }
        };
    }

}
public class IterationExample {
    public static void main(String[] args) {
        final Bag<String> bag = new Bag<>(Arrays.asList("1", "two", "drei"));
        for (String s : bag) {
            System.out.println(s);
        }

        bag.forEach(s -> System.out.println(s));

        bag.forEach(System.out::println);
    }
}
