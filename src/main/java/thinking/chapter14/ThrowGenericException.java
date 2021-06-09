package thinking.chapter14;

import java.util.ArrayList;
import java.util.List;

import static faraway.sourceCode.MyPrint.printnb;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-25 14:22
 */

interface Processor<T, E extends Exception> {
    void process(List<T> resultCollector) throws E;
}

class ProcessRunner<T, E extends Exception> extends ArrayList<Processor<T,E>> {
    List<T> processAll() throws E {
        List<T> resultCollector = new ArrayList<T>();
        for(Processor<T,E> processor : this) {
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}

class Failurel extends Exception {}

class Processor1 implements Processor<String, Failurel> {
    static int count = 3;
    public void process(List<String> resultCollector) throws Failurel {
        if(count-- > 1) {
            resultCollector.add("Hep!");
        } else {
            resultCollector.add("Ho!");
        }
        if (count < 0) {
            throw new Failurel();
        }
    }
}

class Failure2 extends Exception {}

class Processor2 implements Processor<Integer,Failure2> {
    static int count = 3;
    public void process(List<Integer> resultCollector) throws Failure2{
        if (count-- == 1){
            resultCollector.add(47);
        } else {
            resultCollector.add(11);
        }
        if (count < 0) {
            throw new Failure2();
        }

    }
}

public class ThrowGenericException {
    public static void main(String[] args) {
        ProcessRunner<String,Failurel> runner = new ProcessRunner<String,Failurel>();
        for (int i = 0; i < 3; i++) {
            runner.add(new Processor1());
        }
        try { printnb(runner.processAll());}
        catch(Failurel e) {
            printnb(e);
        }

        ProcessRunner<Integer,Failure2> runner2 = new ProcessRunner<Integer,Failure2>();
        for (int i = 0; i < 3; i++) {
            runner2.add(new Processor2());
        }
        try { printnb(runner2.processAll());}
        catch(Failure2 e) {
            printnb(e);
        }
    }
}
