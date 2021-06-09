package thinking.before;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-15 16:18
 */

public class PrivateOverride {
    private void f(){
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        Derived po = new Derived();
        po.f();
    }
}

class Derived extends PrivateOverride{
    public void f(){
        System.out.println("public f()");
    }
}
