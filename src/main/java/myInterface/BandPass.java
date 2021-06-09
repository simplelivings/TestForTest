package myInterface;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-16 15:51
 */

public class BandPass extends Filter {
    double lowCutoff, highCutoff;
    public BandPass(double lowCut, double highCut){
        lowCutoff = lowCut;
        highCutoff = highCut;
    }
    public Waveform process(Waveform input){ return input;}
}
