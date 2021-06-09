package faraway.sourceCode;


import sun.misc.Unsafe;

import static sun.misc.Unsafe.getUnsafe;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-05-11 11:36
 */

public class DemoString {
    public static void main(String[] args) throws Throwable {


        String s = new String("a") + new String("b");
        String s2 = s.intern();
        String x = "ab";
        Student s1 = new Student();
        long l = location(s1);

        System.out.println(s2 == x);
        System.out.println(s == x);
        System.out.println("s: "+l);
    }


    public static long location(Object object) throws Throwable {

        Unsafe unsafe = getUnsafe();
        Object[] array = new Object[]{object};
        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize();
        long location;
        switch (addressSize) {
            case 4:
                location = unsafe.getInt(array, baseOffset);
                break;
            case 8:
                location = unsafe.getLong(array, baseOffset);
                break;
            default:
                throw new Error("unsupported address size: " + addressSize);

        }return (location);

    }
}
