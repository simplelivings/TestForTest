package thinking.chapter12;

import static faraway.sourceCode.MyPrint.*;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-21 16:21
 */

class SimpleException extends Exception {}

public class InheritingExceptions {
    public void f() throws SimpleException {
        printnb("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        } catch(SimpleException e) {
            printnb("Caught it!");
        }
    }
}
