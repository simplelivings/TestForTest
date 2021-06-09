package myInterface;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-16 15:49
 */

public class LowPass extends Filter{
    double cutoff;
    public LowPass(double cutoff){ this.cutoff = cutoff;}
    public Waveform process(Waveform input){ return input;}
}
