package geoorg.oct17streams;

import geoorg.sep28streams.Employee;

import java.util.List;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;

/**
 * Created by gd on 9/28/2018.
 */
@FunctionalInterface
public interface ShortSupplier {

    short get();

    public static void main(String[] args) {
        double d = 1.0;

        //DoubleToIntFunction f1 = x -> 1;
        Function<Double, Integer> f1 = x -> 1;
        f1.apply(d);


    }
}
