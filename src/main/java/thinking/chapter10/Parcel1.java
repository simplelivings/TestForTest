package thinking.chapter10;

import static faraway.sourceCode.MyPrint.print;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-19 13:39
 */

public class Parcel1 {
    class Contents{
        private int i = 11;
        public int value() { return i;}
    }
    class Destination{
        private String label;
        Destination(String whereTo){
            label = whereTo;
        }
        String readLabel(){ return label;}
    }
    public void ship(String dest){
        Contents c = new Contents();
        Destination d = new Destination(dest);
        print(d.readLabel());
        print(c.value());
    }

    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("Tasmania");
    }
}
