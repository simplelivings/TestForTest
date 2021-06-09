package thinking.chapter11;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static faraway.sourceCode.MyPrint.print;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-21 14:06
 */

public class Statistics {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        for (int i = 0; i < 10000; i++) {
            int r = rand.nextInt(20);
            Integer freq = m.get(r);
            print("--r:" + r + " freq:" + freq);
            m.put(r, freq == null ? 1 : freq + 1);
        }
        print();
        print(m);
    }
}
