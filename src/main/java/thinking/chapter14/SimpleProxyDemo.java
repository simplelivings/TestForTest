package thinking.chapter14;

import static faraway.sourceCode.MyPrint.printnb;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-25 10:45
 */

interface Interface {
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface {
    public void doSomething() { printnb("doSomething");}
    public void somethingElse(String arg) {
        printnb("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;
    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }
    public void doSomething() {
        printnb("SimpleProxy doSomething");
        proxied.doSomething();
    }
    public void somethingElse(String arg) {
        printnb("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
    }
}
public class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
