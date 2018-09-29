package geoorg.sep09;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundedExample {
    void foo(List<? super Exception> objects) {
        Object object = objects.get(0);
    }

    void bar() {
        List<Exception> exceptionList = new ArrayList<>();
        List<Throwable> throwables = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        List<String> strings = new ArrayList<>();
//        foo(strings);
    }
}
