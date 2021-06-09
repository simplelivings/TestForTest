package myInterface;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-16 15:50
 */

public class HighPass extends Filter{
    double cutoff;
    public HighPass(double cutoff){ this.cutoff = cutoff;}
    public Waveform process(Waveform input){ return input; }
}
