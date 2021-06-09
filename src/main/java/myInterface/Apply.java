package myInterface;

import java.util.Arrays;

import static faraway.sourceCode.MyPrint.print;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-16 15:21
 */

class Upcase implements Processor{
    public String name() {
        return null;
    }

    public String process(Object input){
        return ((String)input).toUpperCase();
    }
}

class Downcase implements Processor{
    public String name() {
        return null;
    }

    public String process(Object input){
        return ((String)input).toLowerCase();
    }
}

class Splitter implements Processor{
    public String name() {
        return null;
    }

    public String process(Object input){
        return Arrays.toString(((String)input).split(" "));
    }
}

public class Apply {
    public static void process(Processor p, Object s){
        print("Using Processor " + p.name());
        print(p.process(s));
    }
    public static String s =
            "Disagreement with beliefs is by definition incorrect";

    public static void main(String[] args) {
        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter() ,s);
    }
}
