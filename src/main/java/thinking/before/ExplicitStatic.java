package thinking.before;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-14 13:35
 */

class Cup {
    Cup(int marker) {
        System.out.println("Cup(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}

class Cups {
   static Cup cup1;
    Cup cup2;
    int number;

    {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    Cups() {
        System.out.println("Cups()");
    }
}

public class ExplicitStatic {
    public static void main(String[] args) {
        System.out.println("Inside main()");
        Cup cup = Cups.cup1;
        System.out.println("cup::" + cup);
//        Cups cups = new Cups();
//        Cups.cup1.f(99);
    }
}
