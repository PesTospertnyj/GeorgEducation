package geoorg.unit3.examples;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author artur
 */
public class WrapperClassesDemo {

    public static void main(String[] args) {
        int primitive = Integer.parseInt("123");
        Integer wrapper = Integer.valueOf("123");

        List<Double> weights = new ArrayList<>();
        weights.add(50.5);
        weights.add(new Double(60.));
        System.out.println(weights);
        weights.remove(50.5);
        double first = weights.get(0);
        System.out.println(weights);

    }
}
