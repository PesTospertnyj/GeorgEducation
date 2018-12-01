package geoorg.additional.lectures.nov24.collections.examples;

import java.util.*;

/**
 * Created by gd on 12/1/2018.
 */
public class Ex03EmptyExamples {
    public static void main(String ... args) {
        Enumeration<Integer> emptyEnumeration = Collections.<Integer>emptyEnumeration();
        boolean b = emptyEnumeration.hasMoreElements();
        assert !b;

        Iterator<Object> emptyIterator = Collections.emptyIterator();
//        emptyIterator.next();// java.util.NoSuchElementException

        ListIterator<Object> emptyListIterator = Collections.emptyListIterator();
//        emptyListIterator.add(new Object());//java.lang.UnsupportedOperationException

        List<Integer> list = getList(0);
        for (Integer integer : list) {
            System.out.println();
        }

    }

    public static List<Integer> getList(int i) {
        if (i < 1) {
            return Collections.emptyList();
        }
        return new ArrayList<>(i);
    }
}
