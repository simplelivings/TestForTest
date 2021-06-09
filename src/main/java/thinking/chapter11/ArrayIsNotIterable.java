package thinking.chapter11;

import java.util.Arrays;

import static faraway.sourceCode.MyPrint.print;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-21 15:09
 */

public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> ib) {
        for(T t : ib) {
            print(t + " ");
        }
    }

    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));
        String[] strings = { "A", "B", "C"};
        test(Arrays.asList(strings));
    }
}
