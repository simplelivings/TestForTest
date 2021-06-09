package thinking.chapter10;

import static faraway.sourceCode.MyPrint.print;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-19 16:21
 */

public class Parcel9 {
    public Destination destination(final String dest){
        return new Destination() {
           private String label = dest;
           public String readLabel(){ return label;}
        };
    }
    {print("Parcel9======");}

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");
        print(p.destination("sss").readLabel());
    }
}
