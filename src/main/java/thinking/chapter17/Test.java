package thinking.chapter17;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-26 11:30
 */

public abstract class Test<C> {
    String name;
    public Test(String name) { this.name = name;}
    abstract int test(C container, TestParam tp);
}
