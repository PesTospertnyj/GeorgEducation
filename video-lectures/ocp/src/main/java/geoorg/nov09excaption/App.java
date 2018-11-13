package geoorg.nov09excaption;

public class App {

    public static void main(String[] args) {
           Employee employee = new Employee("Nick", "Podlesny");

           employee.setSalary(1000);

           try {
               employee.setAge(18);
           } catch (MinorExcaption e) {
               e.printStackTrace();
           } catch (IllegalArgumentException  e) {
               System.out.println("cause: " + e.getMessage());
           } catch (Throwable throwable) {
               throwable.printStackTrace();
           } finally {
               System.out.println("Finnaly");
           }

           System.out.println(employee);

        try {
            employee.printFIO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
