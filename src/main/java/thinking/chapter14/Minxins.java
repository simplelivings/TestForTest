package thinking.chapter14;

import java.util.Date;

import static faraway.sourceCode.MyPrint.printnb;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-25 14:54
 */

interface TimeStamped { long getStamp();}
class TimeStampedImp implements TimeStamped {
    private final long timeStamp;
    public TimeStampedImp() {
        timeStamp = new Date().getTime();
    }
    public long getStamp() { return timeStamp;}
}

interface SerialNumbered { long getSerialNumber();}
class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;
    public long getSerialNumber() { return serialNumber;}
}

interface Basic {
    public void set(String val);
    public String get();
}
class BasicImp implements Basic {
    private String value;
    public void set(String val) { value = val;}
    public String get() { return value;}
}

class Mixin extends BasicImp implements TimeStamped, SerialNumbered {
    private TimeStamped timeStamp = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();
    public long getStamp() { return timeStamp.getStamp();}
    public long getSerialNumber() { return serialNumber.getSerialNumber();}
}
public class Minxins {
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        printnb(mixin1.get() + " " +
                mixin1.getStamp() + " " + mixin1.getSerialNumber());
        printnb(mixin2.get() + " " +
                mixin2.getStamp() + " " + mixin2.getSerialNumber());
    }
}
