package thinking.chapter12;

import static faraway.sourceCode.MyPrint.printnb;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-22 16:00
 */

class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}

abstract class Inning {
    public Inning() throws BaseballException {}
    public void event() throws BaseballException {}
    public abstract void atBat() throws Strike,Foul;
    public void walk() {}
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
    public void event() throws RainedOut;
    public void rainHard() throws RainedOut;
}
public class StormyInning extends Inning implements Storm {
    public StormyInning() throws RainedOut, BaseballException{}
    public StormyInning(String s) throws Foul, BaseballException {}
    public void rainHard() throws RainedOut {}
    public void event() {}
//    public void walk() throws PopFoul {}
    public void atBat() throws PopFoul {}

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch(PopFoul e) {
            printnb("Pop foul");
        } catch(RainedOut e) {
            printnb("Rained out");
        } catch(BaseballException e) {
            printnb("Generic baseball exception");
        }

        try {
            Inning i = new StormyInning();
            i.atBat();
        } catch(Strike e) {
            printnb("Strike");
        } catch(Foul e) {
            printnb("Foul");
        } catch(RainedOut e) {
            printnb("Rained out");
        } catch(BaseballException e) {
            printnb("Generic baseball exception");
        }
    }

}
