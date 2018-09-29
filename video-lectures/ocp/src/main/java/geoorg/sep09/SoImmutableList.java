package geoorg.sep09;

import java.util.ArrayList;
import java.util.Collection;

class A {

}

class B extends A {

}
public class SoImmutableList<E> extends ArrayList<E> {

    public E read(E element) {
        return null;
    }

    public static void main(String[] args) {
        SoImmutableList<? extends A> numbers = new SoImmutableList<>();
//        numbers.read(new B());
    }
}
