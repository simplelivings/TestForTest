package thinking.before;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-15 15:22
 */

class Poppet{
    public int i;
    Poppet(int i){ this.i = i;};
}

public class BlankFinal {
    private final int i = 0;
    private final int j;
    private final Poppet p;

    public BlankFinal(){
        j = 1;
        p = new Poppet(1);
        System.out.println("j: " + j);
    }

    public BlankFinal(int x){
        j = x;
        p = new Poppet(x);
        System.out.println("j: " + j);

    }

    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
        Poppet p = new Poppet(4);
        System.out.println(" pi: " + p.i);
    }
}
