package geoorg.sep13.iteration;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by gd on 9/13/2018.
 */

class Bag<TYPE> implements Iterable<TYPE> {

    private List<TYPE> stringList;

    public Bag(List<TYPE> stringList) {
        this.stringList = stringList;
    }

    @Override
    public Iterator<TYPE> iterator() {
        return new Iterator<TYPE>() {

            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < stringList.size();
            }

            @Override
            public TYPE next() {
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
