package thinking.chapter11;

import java.util.*;

import static faraway.sourceCode.MyPrint.print;
import static faraway.sourceCode.MyPrint.printnb;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-21 15:52
 */

public class ModifyingArraysAsList {
    public static void main(String[] args) {
        Random random = new Random(47);
        Integer[] ia = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list1 =
                new ArrayList<Integer>(Arrays.asList(ia));
        printnb("Before shuffling:" + list1);
        Collections.shuffle(list1, random);
        printnb("After shuffling:" + list1);
        print();
        printnb("array: " + Arrays.toString(ia));
        List<Integer> list2 = Arrays.asList(ia);
        printnb("Before shuffling: " + list2);
        Collections.shuffle(list2, random);
        printnb("After shuffling: " + list2);
        printnb("array: " + Arrays.toString(ia));

    }
}
