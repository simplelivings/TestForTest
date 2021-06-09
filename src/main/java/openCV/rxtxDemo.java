package openCV;

import gnu.io.CommPortIdentifier;

import java.util.Enumeration;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-06-02 15:13
 */

public class rxtxDemo {
    public static void main(String[] args) {

        Enumeration<CommPortIdentifier> em = CommPortIdentifier.getPortIdentifiers();
        while (em.hasMoreElements()) {
            String name = em.nextElement().getName();
            System.out.println("name: " + name);
        }
    }
}
