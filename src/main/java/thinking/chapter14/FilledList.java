package thinking.chapter14;

import java.util.ArrayList;
import java.util.List;

import static faraway.sourceCode.MyPrint.printnb;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-23 15:31
 */
class CountedInteger {
    private static long counter;
    private final long id = counter++;
    public String toString() {
        return Long.toString(id);
    }
}

public class FilledList<E> {
    private Class<E> type;
    public FilledList(Class<E> type) { this.type = type;}
    public List<E> create(int nElements) {
        List<E> result = new ArrayList<E>();
        try {
            for(int i = 0; i < nElements; i++) {
                result.add(type.newInstance());
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> f1 = new FilledList<CountedInteger>(CountedInteger.class);
        printnb(f1.create(15));
    }
}
