package thinking.chapter13;

import java.util.Random;

import static faraway.sourceCode.MyPrint.print;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-23 12:37
 */

public class UsingStringBuilder {
    public static Random rand = new Random(47);
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < 25; i++) {
            result.append(rand.nextInt(100));
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("] ");
        return result.toString();
    }

    public static void main(String[] args) {
        UsingStringBuilder usb = new UsingStringBuilder();
        print(usb);
    }
}
