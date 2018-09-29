package geoorg.sep15functinterf;

import java.util.function.Supplier;

/**
 * Created by gd on 9/15/2018.
 */
class MySupplier implements Supplier<StringBuilder> {

    @Override
    public StringBuilder get() {
        return new StringBuilder();
    }
}

public class FunctInterExample {
    public static void main(String[] args) {
        new Supplier<StringBuilder>() {

            @Override
            public StringBuilder get() {
                return new StringBuilder();
            }
        };

        new MySupplier();
    }
}
