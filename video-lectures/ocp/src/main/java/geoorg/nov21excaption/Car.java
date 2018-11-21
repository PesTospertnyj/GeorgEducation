package geoorg.nov21excaption;

public class Car implements AutoCloseable {

    final private int number;

    public Car(int number) {
        System.out.println("Car "+ number +" is created");
        this.number = number;
    }

    public Car() {
        System.out.println("Car is created");
        this.number = 0;
    }

    public void start() throws Exception {
        System.out.println("Car " + number + " is started");
        //throw  new Exception("Car cannot be started");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Car " + number + " is closed");
        throw new Exception("Car " + number + " cannot e closed");
    }

    public void foo() {
        foo();
    }

    static Car car0 = null;
    public static void main(String[] args) {
        Car car2 = null;
        try (Car car1 = new Car(1)) {
            car1.close();
            car1.start();

            //car1 = new Car();
            //Car car3 = new Car(3);
            //car1.start();
            //throw new Exception("try excaption");
        } catch (Exception e) {
            System.out.println("caught: "+ e.getMessage());
            for (Throwable t: e.getSuppressed())
                 System.out.println("suppresed: "+t.getMessage());
        } finally {
            System.out.println("finally block");
            //throw new RuntimeException("finally excatpion");
        }

        System.out.println("after try");

    }

}
