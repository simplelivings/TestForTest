package thinking.before;

import static faraway.sourceCode.MyPrint.print;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-14 11:26
 */

public class InitialValues {
    public  int number =1;
    public String name;
    public boolean check;


    InitialValues(){
        System.out.println("number: " + number);
        System.out.println("name: " + name);
        System.out.println("check: " + check);
    }

    public void getName(){
        int size=0 ;
        System.out.println("size: " + size);
    }


    public static void main(String[] args) {
        InitialValues initialValues = new InitialValues();
        initialValues.getName();
        print("ssss");

    }
}
