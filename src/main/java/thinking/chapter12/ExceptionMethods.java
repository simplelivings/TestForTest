package thinking.chapter12;


import static faraway.sourceCode.MyPrint.*;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-22 11:29
 */

public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        } catch(Exception e) {
            printnb("Caught Exception");
            printnb("getMessage(): " + e.getMessage());
            printnb("getLocalizedMessage(): " +
                    e.getLocalizedMessage());
            printnb("toString():" + e);
            printnb("printStackTrace():");
            e.printStackTrace(System.out);
        }
    }
}
