package faraway.sourceCode;

import static faraway.sourceCode.MyPrint.printnb;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-28 14:21
 */

public class Tester {
    public static void main(String[] args) {
        Student student = new Student();
        Student student1 = new Student();
//        printnb("s:" + student);
//        printnb("s1:" + student1);

        int i = 10, j = 10;
        printnb("i:" + ((i++) + (i++) + (i++)) + " i=" + i);
        printnb("j:" + ((++j) + (++j) + (++j)) + " j=" + j);



    }
}
