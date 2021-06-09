package thinking.before;

import static faraway.sourceCode.MyPrint.print;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-19 12:34
 */

class A{
    interface B{
        void f();
    }
    public class BImp implements B{
        public void f() {print("BImp....");}
    }
    private class BImp2 implements B{
        public void f(){print("BImp2....");}
    }

    public interface C{
        void f();
    }
    class CImp implements C{
        public void f(){print("CImp....");}
    }
    private class CImp2 implements C{
        public void f(){print("CImp2....");}
    }
    private interface D{
        void f();
    }
    private class DImp implements D{
        public void f(){print("DImp....");}
    }
    public class DImp2 implements D{
        public void f(){print("DImp2....");}
    }
    public D getD(){ return new DImp2();}
    private D dRef;
    public void receiveD(D d){
        dRef = d;
        dRef.f();
    }
    interface E{
         interface G{
            void  f();
        }
        public interface H{
             void f();
        }
        void g();
    }
}

public class NestingInterfaces {
    public class BImp implements A.B{
        public void f(){}
    }
    class CImp implements A.C{
        public void f(){}
    }
    class EImp implements A.E{
        public void g(){}
    }
    class EGImp implements A.E.G{
        public void f(){}
    }
    class EImp2 implements A.E {
        public void g() { }
    }

    public static void main(String[] args) {
        A a = new A();
        A a2 = new A();
        a2.receiveD(a.getD());
    }
}
