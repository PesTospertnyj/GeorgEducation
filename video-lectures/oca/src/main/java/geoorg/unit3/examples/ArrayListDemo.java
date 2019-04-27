package geoorg.unit3.examples;

import java.util.*;

public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList(10);
        ArrayList list3 = new ArrayList(list2);
        ArrayList<String> list4 = new ArrayList<String>();
        ArrayList<String> list5 = new ArrayList<>();
        List<String> list6 = new ArrayList<>();
        list.add("Hawk");
        list.add(Boolean.TRUE);
        System.out.println(list);
        ArrayList<String> safer = new ArrayList<>();
        safer.add("sparrow");
        List<String> birds = new ArrayList<>();
        birds.add("hawk");
        birds.add(1, "robin");
        birds.add(0, "blue jay");
        birds.add(1, "cardinal");
        System.out.println(birds);
        System.out.println(birds.remove("cardinal"));
        System.out.println(birds.remove("hawk"));
        System.out.println(birds.remove(0));
        System.out.println(birds);
        List<String> birds1 = new ArrayList<>();
        birds1.add("hawk");
        System.out.println(birds1.size());
        birds1.set(0, "robin");
        System.out.println(birds1.size());
        try {
            birds1.set(1, "robin");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error! Element isn't in the list!");
        }
        System.out.println(birds.isEmpty());
        System.out.println(birds.size());
        birds.add("hawk");
        birds.add("hawk");
        System.out.println(birds.isEmpty());
        System.out.println(birds.size());

        List<String> birds2 = new ArrayList<>();
        birds2.add("hawk");
        birds2.add("hawk");
        System.out.println(birds2.isEmpty());
        System.out.println(birds2.size());
        birds2.clear();
        System.out.println(birds2.isEmpty());
        System.out.println(birds2.size());

        List<String> birds3 = new ArrayList<>();
        birds3.add("hawk");
        System.out.println(birds3.contains("hawk"));
        System.out.println(birds3.contains("robin"));

        List<String> one = new ArrayList<>();
        List<String> two = new ArrayList<>();
        System.out.println(one.equals(two));
        one.add("a");
        System.out.println(one.equals(two));
        two.add("a");
        System.out.println(one.equals(two));
        one.add("b");
        two.add(0, "b");
        System.out.println(one.equals(two));
    }
}
