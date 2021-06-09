package thinking.chapter12;

import static faraway.sourceCode.MyPrint.*;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-22 10:56
 */

class MyException2 extends Exception {
    private int x;
    public MyException2() {}
    public MyException2(String msg) { super(msg);}
    public MyException2(String msg, int x) {
        super(msg);
        this.x = x;
    }
    public int val() { return x;}
    public String getMessage() {
        return "Detail Message: " + x + " " + super.getMessage();
    }
}

public class ExtraFeatures {
    public static void f() throws MyException2 {
        printnb("Throwing MyException2 from f()");
        throw new MyException2();
    }
    public static void g() throws MyException2 {
        printnb("Throwing MyException2 from g()");
        throw new MyException2("Originated in g()");
    }
    public static void h() throws MyException2 {
        printnb("Throwing MyException2 from h()");
        throw new MyException2("Originated in h()", 47);
    }

    public static void main(String[] args) {
        try {
            f();
        } catch(MyException2 e) {
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch(MyException2 e) {
            e.printStackTrace(System.out);
        }
        try {
            h();
        } catch(MyException2 e) {
            e.printStackTrace();
            printnb("e.val() = " + e.val());
        }
    }
}
