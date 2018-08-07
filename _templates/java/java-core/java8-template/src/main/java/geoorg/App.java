package geoorg;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        foo(new Integer(10));
        foo(new Double(10.0));
        Number number = new Integer(30);
        foo(number);
    }

    private static void foo(final Integer integer) {
        System.out.println("integer");
    }

    private static void foo(final Double d) {
        System.out.println("double");
    }

    private static void foo(final Number d) {
        System.out.println("Number");
    }


}
