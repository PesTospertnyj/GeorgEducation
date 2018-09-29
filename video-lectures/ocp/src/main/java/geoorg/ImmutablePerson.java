package geoorg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ImmutablePerson {
    private final int age;
    private final List<String> names;

    public ImmutablePerson(int age, List<String> names) {
        this.age = age;
        this.names = new ArrayList<>(names);
    }

    public static void main(String[] args) {
        final List<String> names = new ArrayList<>(Arrays.asList("Chuck", "Noris"));
        ImmutablePerson chuck = new ImmutablePerson(60, names);
        System.out.println(chuck);
        names.add("another name");
        System.out.println(chuck);

        chuck.getNames().add("second name");
        System.out.println(chuck);

//        new ImmutablePerson(){
//
//        };
    }

//    public ImmutablePerson increaseAge(int delta) {
//        return new ImmutablePerson(age + delta, names);
//    }

    public int getAge() {
        return age;
    }

    public List<String> getNames() {
        return new ArrayList<>(names);
    }

    @Override
    public String toString() {
        return "ImmutablePerson{" +
                "age=" + age +
                ", names=" + names +
                '}';
    }
}
