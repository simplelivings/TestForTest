package thinking.before;

import java.util.Random;

import static faraway.sourceCode.MyPrint.print;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-17 18:31
 */

public class RandomDoubles {
    private static Random rand = new Random(47);
    public double next(){ return rand.nextDouble();}

    public static void main(String[] args) {
        RandomDoubles rd = new RandomDoubles();
        for (int i = 0; i < 7; i++) {
            print(rd.next() + " ");
        }
    }
}
