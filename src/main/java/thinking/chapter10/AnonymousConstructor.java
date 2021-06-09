package thinking.chapter10;

import static faraway.sourceCode.MyPrint.print;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-20 9:15
 */

abstract class Base{
    public Base(int i){
        print("Base constructor, i = " + i);
    }
    public abstract void f();
}

public class AnonymousConstructor {
//    public static Base getBase(int i){
//        return new Base(i){
//            {print("Inside instantce initializer");}
//            public void f(){
//                print("In anonymous f()");
//            }
//            int i = 1000;
//            {print("i: " + i);}
//        };
//    }

    public static void main(String[] args) {
//        Base base = getBase(47);
//        base.f();
        Base base1 = new Base(0) {

            public void f() {

            }
        };
    }
}
