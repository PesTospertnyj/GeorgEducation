//package geoorg.sep01;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Collection;
//
//interface Shippable<T extends Number> {
//    void ship(T t);
//
//    static <U> void  foo() {
////        new U();
////        U[] array = new U[]{};
//        new ArrayList<U>();
//        String s = "";
//        int[] arr = null;
//        boolean b = s instanceof U;
//        return ;
//    }
//
//    public static <T> T noGood(T t) { return t; }  // DOES NOT COMPILE
//}
//
//class Crate<T> {
//
////    private static <T> T t;
//
//    private String s;
//    private T contents;
//    public T emptyCrate() {
//        return contents;
//    }
//
//    public Crate(T contents) throws IllegalAccessException, InstantiationException {
//        T t = null;
//        t = (T) t.getClass().newInstance();
//        this.contents = contents;
//    }
//
//    public void packCrate(T contents) {
//        T t;
//        this.contents = contents;
//    }
//
//    public <SOURCE, TARGET> TARGET convert(SOURCE src) {
//        return null;
//    }
//}
//
//public class GenericExamples {
//    public static void main(String[] args) {
//        Collection collection = new ArrayList();
//        collection.add("Str");
//        collection.add(12);
//        collection.add(new int[]{1});
//
//        Collection<String> strings;
//
//
//    }
//}
//
//class AClass {
//    <T> T foo() {
//        return null;
//    }
//
//    <T> void baz(T t) {
//        System.out.println(t.getClass().getName());
//        return ;
//    }
//
//    void bar() {
//        Object foo = foo();
//        String foo1 = this.foo();
//
//        this.<String>baz("");
//        baz(null);
//    }
//}
