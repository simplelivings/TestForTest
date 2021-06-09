package thinking.chapter11;

import java.util.*;

import static faraway.sourceCode.MyPrint.print;


/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-21 12:55
 */

public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        Integer[] moreInts = { 6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));
        Collections.addAll(collection, 11, 12, 13,14, 15);
        Collections.addAll(collection,moreInts);
        List<Integer> list = Arrays.asList(16, 17, 19,19,20);
        list.set(1, 99);
        for (Integer i : collection) {
            print(i);
        }
        print();
        for (Integer i : list) {
            print(i);
        }
    }
}
