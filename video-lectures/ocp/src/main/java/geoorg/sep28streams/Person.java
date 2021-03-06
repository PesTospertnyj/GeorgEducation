package geoorg.sep28streams;

import java.util.Comparator;

/**
 * Created by gd on 9/28/2018.
 */
public class Person //implements Comparable<Person>
{

    private String name;
    private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printMyAge() {
        System.out.println(this.getAge());
    }

    public int compareTo(Person o) {
        final Comparator<Person> ageComparator = Comparator.comparingInt(Person::getAge);
        return ageComparator.compare(this, o);
    }
}
