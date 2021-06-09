package faraway.sourceCode;

import java.io.PrintStream;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-16 10:19
 */

public class MyPrint {

    public static void print(Object obj){
        System.out.print(obj);
    }

    public static void print(){
        System.out.println();
    }

    public static void printnb(Object obj){
        System.out.println(obj);
    }

    public static PrintStream printf(String format, Object... args){
        return System.out.printf(format, args);
    }
}
