package thinking.before;

import java.util.Random;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-14 13:56
 */

public class ArrayNew {
    public static void main(String[] args) {
        Spiciness spiciness = Spiciness.FLAMING;
        String name = "FLAMING";
        if (name.equals(spiciness.toString())){

            System.out.println("sss==" + spiciness.toString());
        }


        int[] a;
        Random random = new Random(47);
        a = new int[random.nextInt(20)];
        for (int i = 0; i < 4; i++) {
            a[i] = i;
        }
        System.out.println("length of a = " + a.length);
    }
}
