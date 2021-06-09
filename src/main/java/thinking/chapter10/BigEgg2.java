package thinking.chapter10;

import static faraway.sourceCode.MyPrint.print;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-21 11:08
 */

class Egg2 {
    protected class Yolk {
        public Yolk() { print("Egg2.Yolk()");}
        public void f() { print("Egg2.Yolk.f()");}
    }
    private Yolk y = new Yolk();
    public Egg2() { print("New Egg2");}
    public void insertYork(Yolk yy) { y = yy;}
    public void g() { y.f();};
}

public class BigEgg2 extends Egg2{
    public class Yolk extends Egg2.Yolk {
        public Yolk() { print("BigEgg2.Yolk()");}
        public void f() { print("BigEgg2.Yolk.f()");}
    }
    public BigEgg2() { insertYork(new Yolk());
    print("BigEgg2 Constructor");
    }

    public static void main(String[] args) {
        Egg2 e2 = new BigEgg2();
        e2.g();
    }


}
