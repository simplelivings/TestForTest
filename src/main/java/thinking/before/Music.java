package thinking.before;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-15 16:04
 */

public class Music {
    public static void tune(Instrument i){
        i.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute);
    }
}
