package myInterface;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-17 16:07
 */

public abstract class StringProcessor{
    public String name() {
        return getClass().getSimpleName();
    }

    public abstract String process(Object input);
    public static String s =
            "If she weighs the same as a duck, she's made of wood";

    public static void main(String[] args) {
        Apply.process(new Upcase(), s);
        Apply.process(new Downcase(), s);
        Apply.process(new Splitter(), s);
    }
}
