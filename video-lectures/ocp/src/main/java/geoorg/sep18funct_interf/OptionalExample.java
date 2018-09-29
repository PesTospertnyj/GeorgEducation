package geoorg.sep18funct_interf;

import java.util.Optional;

/**
 * Created by gd on 9/18/2018.
 */
public class OptionalExample {
    public static void main(String[] args) {
        Optional<Double> aDouble = Optional.empty();


    }

    double orElse (Optional<Double> aDouble) {
        if (aDouble.isPresent()) {
            return aDouble.get();
        } else {
            return 1.0;
        }
    }
}
