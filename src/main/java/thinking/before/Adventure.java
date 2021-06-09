package thinking.before;

import static faraway.sourceCode.MyPrint.print;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-17 16:30
 */

interface CanFight{
    void fight();
}
interface CanSwim{
    void swim();
}
interface CanFly{
    void fly();
}
class ActionCharacter{
    public void fight(){print("ActionCharacter....");};
}
class Hero extends ActionCharacter implements CanFight,CanSwim,CanFly{

    public void swim() {

    }

    public void fly() {

    }
    public void flight(){
        print("Hero......");
    }
}
public class Adventure {
    public static void t(CanFight x){ x.fight();}
    public static void u(CanSwim x){ x.swim();}
    public static void v(CanFly x){ x.fly();}
    public static void w(ActionCharacter x){ x.fight();}

    public static void main(String[] args) {
        Hero h = new Hero();
        t(h);
        u(h);
        v(h);
        w(h);
        h.flight();
    }
}
