package geoorg;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Runnable runnable = () -> {
            System.out.println("Hello");
        };
        new Thread(runnable).start();
    }
}
