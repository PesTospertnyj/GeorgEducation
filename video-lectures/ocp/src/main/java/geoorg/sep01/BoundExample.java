package geoorg.sep01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BoundExample<T extends Number> {

    private T obj;

    private List<T> list = new ArrayList<T>();

    private List<?> l4;

    {
        obj.byteValue();
        List listUnsafe = list;
        listUnsafe.add(new Object());
        List<T> list;
    }

    void foo(List<T> list) {
        
    }
    public static void main(String[] args, List<?> l3) {
        List<?> l2 ;

        BoundExample<Integer> exceptionBoundExample = null;

        List<Object> list = new ArrayList<>();
        list.add(new Integer(0));
        list.add(new int[]{});

        //exceptionBoundExample.list.add(new Double(0));
    }
}
