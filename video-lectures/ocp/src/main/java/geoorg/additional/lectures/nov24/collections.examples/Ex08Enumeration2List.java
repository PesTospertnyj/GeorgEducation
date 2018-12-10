package geoorg.additional.lectures.nov24.collections.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/**
 * Created by gd on 12/8/2018.
 */
public class Ex08Enumeration2List {
    private static final class MyEnumeration implements Enumeration<Integer> {

        private Integer[] arr = new Integer[] {1, 6 , 8};
        private int index = 0;

        @Override
        public boolean hasMoreElements() {
            return index < arr.length;
        }

        @Override
        public Integer nextElement() {
            return arr[index++];
        }
    }

    public static void main(String ... args) {
        final Enumeration<Integer> enumeration = new MyEnumeration();
        final ArrayList<Integer> list = Collections.list(enumeration);
        System.out.println(list);
    }


}
