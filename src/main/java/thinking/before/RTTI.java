package thinking.before;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-16 14:13
 */

class Useful{
    public void f(){}
    public void g(){}
    public String toString(){
        return ("jjjjjj");
    }
}

class MoreUseful extends Useful{
    public void f(){}
    public void g(){}
    public void u(){}
    public String toString(){
        return ("kkkkkk");
    }
}

public class RTTI {
    public static void main(String[] args) {
        Useful[] x = {new Useful(), new MoreUseful()};
        x[0].f();
        x[1].g();
        ((MoreUseful)x[1]).u();
    }
}
