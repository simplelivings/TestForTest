package thinking.chapter12;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-22 10:48
 */

public class LoggingException2 {
    private static Logger logger =
            Logger.getLogger("LoggingException2");
    static void logException2(Exception e) {
        StringWriter trace  = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        } catch(NullPointerException e) {
            logException2(e);
        }
    }
}
