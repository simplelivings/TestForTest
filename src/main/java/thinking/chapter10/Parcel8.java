package thinking.chapter10;

import static faraway.sourceCode.MyPrint.print;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-19 15:24
 */

public class Parcel8 {
    int hex = 100;

    public Wrapping wrapping(int x) {
        return new Wrapping() {
            public int value() {
                print("super::" + super.getClass());
                print("this::" + this.getClass());
                print(super.value() * 47);
                return super.value() * 47;
            }
            {print("hhhhhhhhhhhhhh");}
        };
    }

    void getHex(){
        int hex = 10;
        print("hex..." + hex);
        print("super hex..." + this.hex);
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10);
        w.value();
        p.getHex();

    }
}
