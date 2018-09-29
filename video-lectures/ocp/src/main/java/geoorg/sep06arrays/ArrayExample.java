package geoorg.sep06arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gd on 9/6/2018.
 */
public class ArrayExample {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(2, 12);
        integers.remove(new Integer(12));
        System.out.println(integers);
//        int[] arr = new int[2];
//        final int i = arr[2];
    }
}
