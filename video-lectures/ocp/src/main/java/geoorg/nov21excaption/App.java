package geoorg.nov21excaption;

import java.io.*;

public class App {

    public static void main(String[] args) {

        //Reader reader2 = null;



        try (Reader reader1 = new FileReader(new File("some.txt"));
             Reader reader2 = new FileReader(new File("another.txt"))) {
            reader1.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Reader reader1 = null;
        Reader reader2 = null;
        try {
            reader1 = new FileReader(new File("some.txt"));
            reader2 = new FileReader(new File("another.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader1 != null) {
                    reader1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (reader2 != null) {
                    reader2.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        /*
        * I/O
        *
        * Reader | Writer | InputStream | OutputStream
        *
        * JDBC
        *
        * Connection | Statement | ResultSet
        *
        * */
    }

}
