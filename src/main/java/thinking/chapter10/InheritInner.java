package thinking.chapter10;

import static faraway.sourceCode.MyPrint.print;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-21 10:56
 */

class WithInner {
    public WithInner(){
        print("WithInner..");
    }

    public void say(int num){
        print("String: " + num);
    }

    class Inner {
        public Inner() {
            print("Inner..");
        }
        public void say(int num){
            print("num: " + num);
        }
    }
}

public class InheritInner extends WithInner.Inner{
    InheritInner(WithInner wi) {
        wi.super();
        print("InheritInner: ");
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
        ii.say(1);
    }
}
