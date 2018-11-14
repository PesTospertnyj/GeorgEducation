package geoorg.exception;

public class ArrayStoreExceptionExample {
    public static void main(String ... args) {
        String[] arrStr = new String[]{""};
        Object[] objStr = arrStr;
//        Integer[] intArr = arrStr;

        objStr[0] = new Integer(1);

    }
}
