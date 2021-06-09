package thinking.chapter11;

import java.util.*;

import static faraway.sourceCode.MyPrint.*;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-21 13:02
 */

class Snow {}
class Powder extends Snow {}
class Light extends Powder {}
class Heavy extends Powder {}
class Crusty extends Powder {}
class Slush extends Powder {}

public class AsListInference {
    public static void main(String[] args) {

        List<Snow> snow3 = new ArrayList<Snow>();
        Collections.addAll(snow3, new Light(), new Heavy());

        List<Snow> snow4 = Arrays.<Snow>asList(new Light(), new Heavy());
        for (int i = 0; i < snow3.size(); i++) {
            printnb("snow3" + i + " i: " + snow3.get(i));
        }
        for (int i = snow4.size() - 1; i >= 0; i--) {
            printnb("snow4" + i + " i: " + snow4.get(i));
        }
    }
}
