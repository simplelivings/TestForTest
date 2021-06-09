package thinking.chapter13;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-23 12:58
 */

public class Turtle {
    private String name;
    private Formatter f;
    public Turtle(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }
    public void move(int x, int y) {
        f.format("%s The Turtle is at (%d,%d)\n", name, x, y);
    }

    public static void main(String[] args) {
        PrintStream outAlias = System.out;
        Turtle tommy = new Turtle("Tommy",
                new Formatter(System.out));
        Turtle terry = new Turtle("Terry",
                new Formatter(System.out));
        tommy.move(0, 0);
    }
}
