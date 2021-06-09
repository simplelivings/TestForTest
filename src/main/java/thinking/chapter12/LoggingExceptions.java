package thinking.chapter12;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

import static faraway.sourceCode.MyPrint.printnb;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-22 10:28
 */

class LoggingException extends Exception {
    private static Logger logger =
            Logger.getLogger("LoggingException");
    public LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

public class LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch(Exception e) {
            printnb("Caught " + e);
        }

        try{
            throw new LoggingException();
        } catch(LoggingException e) {
            printnb("Caught " + e);
        }
    }
}
