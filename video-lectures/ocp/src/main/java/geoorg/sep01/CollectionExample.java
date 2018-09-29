package geoorg.sep01;

import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionExample {
    public static void main(String[] args) {
        new ArrayList<Void>();
        Integer integer = new Integer(12);
        integer = 13;

        List<Integer> integers =
                new ArrayList<>(Arrays.asList(3, 2, 1));

        integers.remove(1);
        System.out.println(integers);

    }
}
