package geoorg.additional.lectures.nov24.collections.examples;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by gd on 12/8/2018.
 */
public class Ex10NewSetFromMap {
    public static void main(String ... args) {
        Map<String, Boolean> map = new HashMap<>();
//        map.put("one", true);
//        map.put("two", true);

        Set<String> set = Collections.newSetFromMap(map);

        set.add("three");
        System.out.println(map);

//        map.put("four", false);
    }
}
