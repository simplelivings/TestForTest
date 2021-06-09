package thinking.chapter17;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static faraway.sourceCode.MyPrint.print;
import static faraway.sourceCode.MyPrint.printnb;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-26 9:22
 */
class Groundhog {
    protected int number;
    public Groundhog(int n) { number = n;}
    public String toString() {
        return "Groundhog #" + number;
    }
}

class Prediction {
    private static Random rand  = new Random(47);
    private boolean shadow = rand.nextDouble() > 0.5;
    public String toString() {
        if(shadow) {
            return "Six more weeks of Winter!";
        } else {
            return "Early Spring!";
        }
    }
}

public class SpringDetector {
    public static <T extends Groundhog> void detectSprint(Class<T> type) throws Exception {
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<Groundhog,Prediction> map = new HashMap<Groundhog,Prediction>();
        for (int i = 0; i < 10; i++) {
            map.put(ghog.newInstance(i), new Prediction());
        }
        print("map = " + map);
        Groundhog gh = ghog.newInstance(3);
        print("Looing up prediction for " + gh);
        if (map.containsKey(gh)) {
            printnb(map.get(gh));
        } else {
          printnb("Key not found: " + gh);
        }
    }

    public static void main(String[] args) throws Exception {
        detectSprint(Groundhog.class);
    }
}
