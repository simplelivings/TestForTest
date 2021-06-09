package thinking.chapter14;

import static faraway.sourceCode.MyPrint.print;
import static faraway.sourceCode.MyPrint.printnb;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-23 14:07
 */

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    Toy() {}
    Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() { super(1);}
}
public class ToyTest {
    static void printInfo(Class cc) {
        printnb("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        printnb("Simple name: " + cc.getSimpleName());
        printnb("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("thinking.chapter14.FancyToy");
        } catch(ClassNotFoundException e) {
            printnb("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        print();
        for(Class face : c.getInterfaces()) {
            printInfo(face);
        }
        print();
        Class up = c.getSuperclass();
        Object obj = null;
        try{
            obj = up.newInstance();
        } catch(InstantiationException e) {
            printnb("Cannot instantiate");
            System.exit(1);
        } catch(IllegalAccessException e) {
            printnb("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
