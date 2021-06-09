package myInterface;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-16 15:46
 */

public class Waveform {
    private static long counter;
    private final long id = counter++;
    public String toString(){ return "Waveform " + id;}
}
