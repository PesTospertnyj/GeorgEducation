package geoorg.unit3.examples;
import java.util.*;
/**
 *
 * @author artur
 */
public class ArrayAndListConvertingDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hawk");
        list.add("robin");
        Object[] objectArray = list.toArray();
        System.out.println(objectArray.length);     // 2
        String[] stringArray = list.toArray(new String[0]);
        System.out.println(stringArray.length);     // 2
    }
}
