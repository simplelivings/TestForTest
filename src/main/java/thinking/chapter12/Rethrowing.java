package thinking.chapter12;

import static faraway.sourceCode.MyPrint.*;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-22 13:05
 */

public class Rethrowing {
    public static void f() throws Exception {
        printnb("originating the exception in f()");
        throw new Exception("thrown from f()");
    }
    public static void g() throws Exception {
        try{
            f();
        } catch(Exception e) {
            printnb("Inside g().e.printStackTrace()");
            e.printStackTrace(System.out);
            throw e;
        }
    }
    public static void h() throws Exception {
        try {
            f();
        } catch(Exception e) {
            printnb("Inside h().e.printStackTrace()");
            e.printStackTrace(System.out);
            throw (Exception)e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch(Exception e) {
            printnb("main: printStackTrace()");
            e.printStackTrace(System.out);
        }

        printnb("=================");
        try {
            h();
        } catch(Exception e) {
            printnb("main: printStackTrace()");
            e.printStackTrace(System.out);

        }
    }
}
