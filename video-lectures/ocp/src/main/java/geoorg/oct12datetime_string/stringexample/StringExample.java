package stringexample;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class StringExample {
    public static void main(String[] args) {
        String str1 = "abc", str2 = "";
        str2 += "d";
        StringBuilder stringBuilder = new StringBuilder("");

        Instant before = Instant.now();
        for (int i = 0; i<50000; i++) {
//            str2+="a";

            stringBuilder.append("a");

        }
        Instant after = Instant.now();
        Duration duration = Duration.between(before, after);
        System.out.println("Duration "+duration.getNano()/1000);

        String string = "abcdefgh";


        System.out.println(string.replace('a','A').replace('c', 'C'));
        System.out.println(string.replaceAll("de", "ed"));
        System.out.println(string.endsWith("g"));

        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("a");
        System.out.println(sBuilder);
        sBuilder.insert(0,"A");
        System.out.println(sBuilder);
        sBuilder.insert(1,"-");
        System.out.println(sBuilder);
        System.out.println(string.substring(0,4)+"-"+string.substring(4));

        String str3 = "Hello World, From Underground";
        String[] sSplit = str3.split(", ");
        System.out.println(sSplit.length);
        System.out.println(sSplit[0]);
        System.out.println(sSplit[1]);
//        System.out.println(sSplit[2]);
//        System.out.println(sSplit[3]);

        System.out.println(String.join(":->", "a", "b", "c"));
        List<String> list = new ArrayList<String>() {
            {
                add("element 1");
                add("element 2");
                add("element 3");
                add("element 4");
                add("element 5");
            }

            @Override
            public boolean add(String s) {
                boolean r = super.add(s);
                System.out.println("add");
                return r;
            }
        };

        System.out.println(String.join("->", list));









    }
}
