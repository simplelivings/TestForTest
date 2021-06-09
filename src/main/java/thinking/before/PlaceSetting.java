package thinking.before;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-15 13:45
 */

class Plate{
    Plate(int i){
        System.out.println("Plate constructor" + i);
    }
}
class DinnerPlate extends Plate{
    DinnerPlate(int i){
        super(i);
        System.out.println("DinnerPlate constructor" + i);
    }
}

class Utensil{
    Utensil(int i){
        System.out.println("Utensil constructor" + i);
    }
}
class Spoon extends Utensil{
    Spoon(int i){
        super(i);
        System.out.println("Spoon constructor" + i);
    }
}
class Fork extends Utensil{
    Fork(int i){
        super(i);
        System.out.println("Fork constructor" + i);
    }
}
class Knife extends Utensil{
    Knife(int i){
        super(i);
        System.out.println("Knife constructor" + i);
    }
}

class Custom{
    Custom(int i){
        System.out.println("Custom constructor" + i);
    }
}


public class PlaceSetting extends Custom{
    private Spoon spoon;
    private Fork fork;
    private Knife knife;
    private DinnerPlate plate;

    public PlaceSetting(int i){
        super(i + 1);
        spoon = new Spoon(i + 2);
        fork = new Fork(i + 3);
        knife = new Knife(i + 4);
        plate = new DinnerPlate(i + 5);
        System.out.println("PlaceSetting constructor" + i);
    }

    public static void main(String[] args) {
        PlaceSetting x = new PlaceSetting(9);
    }
}
