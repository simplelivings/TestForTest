package thinking.chapter14;
import static faraway.sourceCode.MyPrint.*;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-23 13:45
 */

class Candy { static { printnb("Loading Candy");}}

class Gum { static { printnb("Loading Gum");}}

class Cookie { static { printnb( "Loading Cookie");}}

public class SweetShop {
    public static void main(String[] args) {
        printnb("inside main");
        new Candy();
        printnb("After creating Candy");
        try {
            Class.forName("Gum");
        } catch(ClassNotFoundException e) {
            printnb("Couldn't find Gum");
        }
        printnb("After Class.forName(\"Gum\")");
        new Cookie();
        printnb("After creating Cookie");
    }
}
