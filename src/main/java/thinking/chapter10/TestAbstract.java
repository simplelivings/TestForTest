package thinking.chapter10;

import static faraway.sourceCode.MyPrint.print;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-20 10:10
 */
abstract class Animal {
    public Animal(int i) {
        print("Animal" + i);
    }
    public abstract void f();

}

public class TestAbstract {
    public static void main(String[] args) {
        Animal animal = new Animal(1) {
            public void f() {
                print("Main Animal");
            }
        };
    }
}
