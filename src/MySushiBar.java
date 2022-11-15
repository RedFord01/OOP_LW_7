import java.util.Scanner;
abstract class Sushi {
    public void prepareIngredients() {
    }
    public void addSauce() {
    }
}

class SpaceStyleSashimi extends Sushi {}
class SpaceStyleNigiri extends Sushi {}
class SpaceStyleChirashi extends Sushi {}
class SpaceStyleMaki extends Sushi {}
class SpaceStyleUramaki extends Sushi {}
class SpaceStyleTemaki extends Sushi {}

enum SushiType {
    SASHIMI,
    NIGIRI,
    CHIRASHI,
    MAKI,
    URAMAKI,
    TEMAKI
}

abstract class SushiBar {
    public Sushi orderSushi(SushiType type) {
        Sushi sushi = createSushi(type);
        sushi.prepareIngredients();
        sushi.addSauce();
        System.out.println("You have a good taste, enjoy");
        return sushi;
    }
    protected abstract Sushi createSushi(SushiType type);
}

class SpaceSushiBar extends SushiBar {
    @Override
    public Sushi createSushi(SushiType type) {
        Sushi sushi = null;

        switch (type) {
            case SASHIMI:
                sushi = new SpaceStyleSashimi();
                break;
            case NIGIRI:
                sushi = new SpaceStyleNigiri();
                break;
            case CHIRASHI:
                sushi = new SpaceStyleChirashi();
                break;
            case MAKI:
                sushi = new SpaceStyleMaki();
                break;
            case URAMAKI:
                sushi = new SpaceStyleUramaki();
                break;
            case TEMAKI:
                sushi = new SpaceStyleTemaki();
                break;
        }
        return sushi;
    }
}
public class MySushiBar {
    public static void main(String[] args) {
        SushiBar spaceSushiBar = new SpaceSushiBar();
        System.out.println("Welcome to <<JungWo>> SushiBar!");
        Scanner in = new Scanner(System.in);
        System.out.println("Here is assortment: ");
        for (SushiType type : SushiType.values()) {
            System.out.println(type);
        }
        System.out.println("Which do you prefer?");
        String userInput = in.next();
        in.close();
        switch (userInput) {
            case "NIGIRI" ->  spaceSushiBar.orderSushi(SushiType.NIGIRI);
            case "SASHIMI" -> spaceSushiBar.orderSushi(SushiType.SASHIMI);
            case "MAKI" -> spaceSushiBar.orderSushi(SushiType.MAKI);
            case "CHIRASHI" -> spaceSushiBar.orderSushi(SushiType.CHIRASHI);
            case "URAMAKI" -> spaceSushiBar.orderSushi(SushiType.URAMAKI);
            case "TEMAKI" -> spaceSushiBar.orderSushi(SushiType.TEMAKI);
            default -> System.out.println("Sorry, we temporary have a lack of " + userInput + ", come tomorrow.");
        }
    }
}
