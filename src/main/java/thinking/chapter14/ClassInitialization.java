package thinking.chapter14;

import java.util.Random;

import static faraway.sourceCode.MyPrint.printnb;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-23 14:33
 */

class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 =
            ClassInitialization.rand.nextInt(1000);
    static {
        printnb("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        printnb("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        printnb("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;
        printnb("After creating Initable ref");
        printnb(Initable.staticFinal);
        printnb(Initable.staticFinal2);
        printnb(Initable2.staticNonFinal);
        Class initable3 = Class.forName("thinking.chapter14.Initable3");
        printnb("After creating Initable3 ref");
        printnb(Initable3.staticNonFinal);
    }
}
