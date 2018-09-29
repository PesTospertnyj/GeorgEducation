package geoorg.sep15functinterf;

import java.util.function.Predicate;

/**
 * Created by gd on 9/15/2018.
 */
public class PredicateExample {
    public static void main(String[] args) {
//        final Predicate<String> emptyStringPredicate = String::isEmpty;
//        System.out.println(emptyStringPredicate.test(""));
//        System.out.println(emptyStringPredicate.test(" "));
//
//        Predicate<String> notEmptyStringPredicate = emptyStringPredicate.negate();
//        System.out.println(notEmptyStringPredicate.test(""));
//        System.out.println(notEmptyStringPredicate.test(" "));
//
//        Predicate<String> orPredicate = emptyStringPredicate.and(notEmptyStringPredicate);
//        System.out.println(orPredicate.test(""));
//        System.out.println(orPredicate.test(" "));
//        System.out.println(orPredicate.test(null));

        Predicate<String> equalsHello = Predicate.isEqual("Hello");
        System.out.println(equalsHello.test("Hi"));
        System.out.println(equalsHello.test("Hello"));

    }
}
