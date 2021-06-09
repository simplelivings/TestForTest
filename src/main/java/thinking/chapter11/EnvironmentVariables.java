package thinking.chapter11;

import java.util.Map;

import static faraway.sourceCode.MyPrint.print;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-21 15:07
 */

public class EnvironmentVariables {
    public static void main(String[] args) {
        for(Map.Entry entry : System.getenv().entrySet()) {
            print(entry.getKey() + "==" +
                    entry.getValue());
        }
    }
}
