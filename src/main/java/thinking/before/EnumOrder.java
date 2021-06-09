package thinking.before;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-14 15:34
 */

public class EnumOrder {
    public static void main(String[] args) {
        for (Spiciness s: Spiciness.values()) {
            System.out.println(s + " , ordinal " + s.ordinal());
        }
    }
}

enum Spiciness{
    NOT, MILD, MEDIUM, HOT, FLAMING
}


