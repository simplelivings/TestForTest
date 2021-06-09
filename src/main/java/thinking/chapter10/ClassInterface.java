package thinking.chapter10;

import static faraway.sourceCode.MyPrint.print;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-20 11:27
 */

public interface ClassInterface {
    void howdy();
    class Test implements ClassInterface{
        public void howdy(){
            print("Howdy! ");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
