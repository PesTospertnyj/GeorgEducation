package geoorg.nov21excaption;

public class Car implements AutoCloseable {

    final private int number;

    public Car(int number) {
        System.out.println("Car "+ number +" is created");
        this.number = number;
    }

    public Car() {
        this(0);
    }

    public void start() throws Exception {
        System.out.println("Car " + number + " is started");
        throw new Exception("Car cannot be started");
    }

    @Override
    public void close() {
        System.out.println("Car " + number + " is closed");
        //throw new Exception("Car " + number + " cannot e closed");
    }

    public static void foo() {
        try (Car car1 = new Car(1)) {
            throw new IllegalStateException("some problem");
        } finally {
            throw new RuntimeException("problem-2");
        }
    }


  //  static Car car0 = null;


    public static  int square(int a) {
        assert a > 0;
        return a * a * a;
    }

    public static void main(String[] args) {

        try (Car car1 = null) {

            System.out.println("try section");
        }
        System.out.println("after try");


/*
        try {
            foo();
        } catch (Exception e) {
            System.out.println("caught: "+ e.getMessage());
            for (Throwable t: e.getSuppressed())
                System.out.println("suppresed: "+t.getMessage());
        }

        try (Car car1 = new Car()) {
            car1.start();
        } catch (Exception e) {
            System.out.println("caught: "+ e.getMessage());

            for (Throwable t: e.getSuppressed())
                 System.out.println("suppresed: "+t.getMessage());

        } finally {
            System.out.println("finally block");
            //throw new RuntimeException("finally excatpion");
        }

        System.out.println("after try");
*/
    }

}
