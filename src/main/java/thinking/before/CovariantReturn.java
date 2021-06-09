package thinking.before;

import static faraway.sourceCode.MyPrint.print;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-16 13:54
 */

class Grain{
    public String toString(){ return "Grain";}
}

class Wheat extends Grain{
    void f(){print("hhhhhhhhhhhhh");}
    public String toString(){ return "Wheat";}
}

class Mill{
    Grain process(){ return new Grain();}
}

class WheatMill extends Mill{
    Wheat process(){return new Wheat();}
}

public class CovariantReturn {
    public static void main(String[] args) {
        Grain g = new Mill().process();
        print(g);
        g = new WheatMill().process();
        print(g);

        Grain grain = new Grain();
        Wheat wheat = (Wheat)grain;
    }
}
