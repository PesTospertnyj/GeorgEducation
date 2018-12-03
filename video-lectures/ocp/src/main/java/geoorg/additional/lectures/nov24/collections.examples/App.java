package geoorg.additional.lectures.nov24.collections.examples;

import java.util.*;

public class App {
    public static void main(String ... args) {
        /// ***************** addAll
//        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2,3));
////        list.set(0, -1);
//        Collections.addAll(list, 4, 5 );
//        System.out.println(list);

        //// ************** asLifoQueue
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);

        Queue<Integer> stack = Collections.asLifoQueue(deque);

        deque.add(4);
        stack.add(5);

        Integer remove1 = deque.remove();//? //5
        Integer remove2 = stack.remove();//4 //1

        //********************* checkedCollection

        List<String> strings2 = new ArrayList<>();
        List<String> strings = Collections.checkedList(strings2, String.class);

        List rawList = strings;
//        rawList.add(new Integer(12));//Attempt to insert class java.lang.Integer element into collection with element type class java.lang.String
        System.out.println(strings);

        String s = strings.get(0);
        System.out.println();




    }
}
