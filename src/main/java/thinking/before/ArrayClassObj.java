package thinking.before;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-14 13:59
 */

public class ArrayClassObj {
    public static void main(String[] args) {
        Random rand = new Random(47);

        Integer[] a = new Integer[rand.nextInt(20)];
        Integer[] b = new Integer[10];
        System.out.println("lengh of a = " + a.length);
        LinkedList<String> linkedList = new LinkedList();

        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(500);
            System.out.println(Arrays.toString(a));
        }
    }
}
