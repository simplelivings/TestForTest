package thinking.before;

import java.util.Random;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-15 14:50
 */

class Value{
    int i;
    public Value(int j){
        i = j;
    }
}

public class FinalData {
    private static Random rand = new Random(47);
    private String id;
    public FinalData(String id){this.id = id;}

    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;
    public static final int VALUE_THREE = 39;
    private final int i4 = rand.nextInt(20);
    static final int INT_5 = rand.nextInt(20);
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(33);
    private final int[] a = { 1, 2, 3, 4, 5, 6 };
    public String toString(){
        return id + ": " + "i4 = " + i4 + ", INT_5 = " + INT_5;
    }

    public static void main(String[] args) {
        FinalData finalData = new FinalData("fd1");
        int c = finalData.valueOne;
        finalData.v2.i++;
        finalData.v1 = new Value(9);
        for (int i = 0; i < finalData.a.length; i++) {
            finalData.a[i]++;
        }
        System.out.println(finalData);
        System.out.println("Creating new FinalData");
        FinalData finalData1  = new FinalData("fd2");
        System.out.println(finalData);
        System.out.println(finalData1);
    }
}
