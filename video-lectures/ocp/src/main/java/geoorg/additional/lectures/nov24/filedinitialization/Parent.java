package geoorg.additional.lectures.nov24.filedinitialization;

import java.util.List;

public class Parent {

    private String string = "default";
    private int another;
    private List list;

    public Parent() {
    }

    public Parent(int another) {
        this.another = another;
    }

//    public Parent(String string, int another) {
//        this.string = string;
//        this.another = another;
//    }

    private String getString() {
        if (true) {
            throw new RuntimeException();
        }
        return "some value";
    }
}
