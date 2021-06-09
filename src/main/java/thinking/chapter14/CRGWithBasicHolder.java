package thinking.chapter14;

import static faraway.sourceCode.MyPrint.printnb;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-25 14:04
 */

class BasicHolder<T> {
    T element;
    void set(T arg) { element = arg;}
    T get() { return element;}
    void f() {
        printnb(element.getClass().getSimpleName());
    }
}

class Subtype extends BasicHolder<Subtype> {}


public class CRGWithBasicHolder {
    public static void main(String[] args) {
        Subtype st1 = new Subtype(), st2 = new Subtype();
        st1.set(st2);
        Subtype st3 = st1.get();
        st1.f();
//        st2.f();
        st3.f();
    }
}
