package geoorg.sep15functinterf;

import java.util.function.Function;

/**
 * Created by gd on 9/18/2018.
 */
public class FunctionExample {
    public static void main(String[] args) {
        Function<Double, Double> sin = (Double d) -> {
            return Math.sin(d);
        };

        Function<Double, Double> sin2 = Math::sin;

        Function<Double, Double> square = (Double d) -> {
            return d*d;
        };

        Function<Double, Double> sinSquare = (Double d) -> {
            return Math.sin(d*d);
        };

        Function<Double, Double> sinSquare2 = sin.compose(square);

        Function<Double, Double> sinSquare3 = square.andThen(sin);

        System.out.println(sinSquare.apply(1.0));

        System.out.println(sinSquare2.apply(1.0));

        System.out.println(sinSquare3.apply(1.0));







    }
}
