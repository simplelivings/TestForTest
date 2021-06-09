package thinking.before;

import static faraway.sourceCode.MyPrint.print;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-16 13:33
 */

class Glyphy{
    void draw(){print("Glyph.draw");}
    Glyphy(){
        print("Glyph() before draw()");
        this.draw();
        print("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyphy{
    private int radius = 1;
    RoundGlyph(int r){
        radius = r;
        print("RoundGlyph.RoundGlyph().radius");
    }
    void draw(){
        print("RoundGlyph.draw().radius = " + radius);
    }
}
public class PolyConstructors {
    public static void main(String[] args) {
        Glyphy g = new Glyphy();
    }
}

