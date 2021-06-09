package thinking.chapter12;

import static faraway.sourceCode.MyPrint.*;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-22 11:38
 */

public class WhoCalled {
    static void f() {
        try {
            throw new Exception();
        } catch(Exception e) {
            for(StackTraceElement ste : e.getStackTrace()) {
                printnb(ste.getMethodName());
            }
        }
    }
    static void g() { f();}
    static void h() { g();}

    public static void main(String[] args) {
        f();
        printnb("----------------");
        g();
        printnb("----------------");
        h();
    }
}
