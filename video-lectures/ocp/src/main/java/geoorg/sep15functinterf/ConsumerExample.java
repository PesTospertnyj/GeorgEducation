package geoorg.sep15functinterf;

import java.util.function.Consumer;

/**
 * Created by gd on 9/15/2018.
 */
public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<Integer> integerConsumer = ((i) ->
            System.out.println(i)
        );

        Consumer<Integer> integerConsumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("save " + integer + " to database");
            }
        };

        Consumer<Integer> compoundConsumer = integerConsumer.andThen(integerConsumer2);

        compoundConsumer.accept(12);
    }
}
