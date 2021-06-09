package thinking.before;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-14 14:55
 */

public class OverloadingVarargs {
    static void f(float i, Character...args){
        System.out.println("first");
    }
    static void f(String...args){
        System.out.print("second");
    }

    public static void main(String[] args) {
        f("abc","cde");
        f(1,'a');
    }
}
