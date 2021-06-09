package thinking.chapter17;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-26 9:39
 */

class Groundhog2 extends Groundhog {
    public Groundhog2(int n) { super(n);}
    public int hashCode() { return number; }
    public boolean equals(Object o) {
        return o instanceof Groundhog2 && (number == ((Groundhog2)o).number);
    }
}

public class SpringDetector2 {
    public static void main(String[] args) throws Exception {
        SpringDetector.detectSprint(Groundhog2.class);
    }
}
