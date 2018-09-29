package geoorg;

import java.time.LocalDate;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.function.Predicate;

/**
 * Hello world!
 *
 */
public class App
{
    private String name;
    private int age;

    public App(String nameV, int age) {
        name = nameV;
        this.age = age;
    }

    public static void main(String[] args )
    {
//        Person nikita = new Person(19);
        final Predicate<Person> predicate = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                System.out.println(null == null);
                return false;
            }
        };

//        Person child = new Person(14);

        NavigableSet<Integer> integers = new TreeSet<>();
        int[] arr = new int[2];
    }

    <X extends Integer> void method5() {   // DOES NOT COMPILE
    }


}
