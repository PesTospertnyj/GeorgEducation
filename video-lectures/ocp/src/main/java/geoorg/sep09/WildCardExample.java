package geoorg.sep09;

import java.util.ArrayList;
import java.util.List;

public class WildCardExample {
    void foo(List<Object> list) {

    }

    void baz(List<?> list) {
        Object o = list.get(0);
        System.out.println(o.getClass());
    }

    void bar() {
        foo(new ArrayList<Object>());
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        //List<Object> objects = integers;

        //objects.add(new String());
        //foo(integers);

        List<Object> objectList = null;
        baz(integers);
//        baz(objectList);
//        baz(null);

    }

    public static void main(String[] args) {
        WildCardExample wildCardExample = new WildCardExample();
        wildCardExample.bar();
    }


}
