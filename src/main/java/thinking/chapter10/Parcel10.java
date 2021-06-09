package thinking.chapter10;

import static faraway.sourceCode.MyPrint.print;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-20 9:33
 */

public class Parcel10 {
    public Destination destination(final String dest, final float price){
        return new Destination(){
            private int cost;
            {
                cost = Math.round(price);
                if(cost > 100){
                    print("Over budget!");
                }
            }
            private String label = dest;
            public String readLabel() { return label;}
        };
    }

    public static void main(String[] args) {
        Parcel10 p = new Parcel10();
        Destination d = p.destination("Tasmania", 101.395F);
    }
}
