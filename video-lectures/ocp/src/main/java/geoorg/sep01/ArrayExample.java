package geoorg.sep01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayExample {
    public static void main(String[] args) {
        String[] array = new String[]{"1"};
        List<Integer> list = Arrays.asList(9,7,5,3);//3, 5, 7 ,9
//        Collections.sort(list);

        int binarySearch = Collections.binarySearch(list, 12);
        System.out.println(binarySearch);

        int binarySearch2 = Collections.binarySearch(list, 3);
        System.out.println(binarySearch2);
    }
}
