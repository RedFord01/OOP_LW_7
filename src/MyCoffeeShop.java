import java.util.Scanner;
abstract class Coffee {
    public void makeCoffee() {
    }
    public void pourIntoCup() {
    }
    public void addSomeSpecial() {
    }
}

class SpaceStyleAmericano extends Coffee {
    @Override
    public void addSomeSpecial() {
        System.out.println("Moon dust in this will taste amazing, i think...");
    }
}
class SpaceStyleCappuccino extends Coffee {
    @Override
    public void addSomeSpecial() {
        System.out.println("Lets add a drop of intergalactic octopus ink...");
    }
}
class SpaceStyleCaffeLatte extends Coffee {
    @Override
    public void addSomeSpecial() {
        System.out.println("In this i will add a few schnible-frible slices, he-he...");
    }
}
class SpaceStyleEspresso extends Coffee {
    @Override
    public void addSomeSpecial() {
        System.out.println("Adding suma-shrum juice from sector JABBA-fdfd2315, as for my favourite customer...");
    }
}
enum CoffeeType {
    ESPRESSO,
    AMERICANO,
    CAFFE_LATTE,
    CAPPUCCINO
}

abstract class CoffeeShop {
    public Coffee orderCoffee(CoffeeType type) {
        Coffee coffee = createCoffee(type);
        coffee.makeCoffee();
        coffee.pourIntoCup();
        coffee.addSomeSpecial();
        System.out.println("Here you go, enjoy!");
        return coffee;
    }
    protected abstract Coffee createCoffee(CoffeeType type);
}

class SpaceCoffeeShop extends CoffeeShop {
    @Override
    public Coffee createCoffee (CoffeeType type) {
        Coffee coffee = null;

        switch (type) {
            case AMERICANO:
                coffee = new SpaceStyleAmericano();
                break;
            case ESPRESSO:
                coffee = new SpaceStyleEspresso();
                break;
            case CAPPUCCINO:
                coffee = new SpaceStyleCappuccino();
                break;
            case CAFFE_LATTE:
                coffee = new SpaceStyleCaffeLatte();
                break;
        }
        return coffee;
    }
}
public class MyCoffeeShop {
    public static void main(String[] args) {
        CoffeeShop spaceCoffeeShop = new SpaceCoffeeShop();
        System.out.println("Welcome to <<Frible-Shnaps>>, my own open-space CoffeeShop!");
        Scanner in = new Scanner(System.in);
        System.out.println("I have: ");
        for (CoffeeType type : CoffeeType.values()) {
            System.out.println(type);
        }
        System.out.println("Which do you prefer?");
        String userInput = in.next();
        in.close();
        switch (userInput) {
            case "AMERICANO" ->  spaceCoffeeShop.orderCoffee(CoffeeType.AMERICANO);
            case "ESPRESSO" -> spaceCoffeeShop.orderCoffee(CoffeeType.ESPRESSO);
            case "CAPPUCCINO" -> spaceCoffeeShop.orderCoffee(CoffeeType.CAPPUCCINO);
            case "CAFFE_LATTE" -> spaceCoffeeShop.orderCoffee(CoffeeType.CAFFE_LATTE);
            default -> System.out.println("I don`t have a coffee you want!");
        }
    }
}
