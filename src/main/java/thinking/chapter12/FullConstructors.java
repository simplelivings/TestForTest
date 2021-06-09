package thinking.chapter12;

import static faraway.sourceCode.MyPrint.*;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-22 9:34
 */

class MyException extends Exception {
    public MyException() {}
    public MyException(String msg) { super(msg);}
}

public class FullConstructors {
    public static void f() throws MyException {
        printnb("Throwing MyException from f()");
        throw new MyException();
    }
    public static void g() throws MyException {
        printnb("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch(MyException e) {
            e.printStackTrace();
        }
        try {
            g();
        } catch(MyException e) {
            e.printStackTrace(System.out);
        }
    }
}
