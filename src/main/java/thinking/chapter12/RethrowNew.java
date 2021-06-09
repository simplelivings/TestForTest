package thinking.chapter12;

import static faraway.sourceCode.MyPrint.*;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-22 13:39
 */

class OneException extends Exception {
    public OneException(String s) { super(s);}
}

class TwoException extends Exception {
    public TwoException(String s) { super(s);}
}

public class RethrowNew {
    public static void f() throws OneException {
        printnb("originating the exception in f()");
        throw new OneException("thrown from f()");
    }

    public static void main(String[] args) {
        try {
            try {
                f();
            } catch(OneException e) {
                printnb("Caught in inner try, e.printStackTrace()");
                e.printStackTrace(System.out);
                throw new TwoException("from inner try");
            }
        } catch(TwoException e) {
            printnb("Caught in outer try, e.printStackTrace()");
            e.printStackTrace(System.out);
        }
    }

}
