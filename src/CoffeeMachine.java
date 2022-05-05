import java.util.Scanner;

public class CoffeeMachine {

    static final Scanner scanner = new Scanner(System.in);
    static int waterInStock = 400;
    static int milkInStock = 540;
    static int coffeeBeansInStock = 120;
    static int salesAmount = 550;
    static int disposableCups = 9;
    static boolean enoughWater = true;
    static boolean enoughMilk = true;
    static boolean enoughCoffeeBeans = true;
    static boolean enoughDisposableCups = true;
    static final int WATER_AMT_REQUIRED_ESPR = 250;
    static final int COFFEE_BEAN_AMT_REQUIRED_ESPR = 16;
    static final int COST_PER_SERVING_ESPR = 4;
    static final int WATER_AMT_REQUIRED_LAT = 350;
    static final int MILK_AMT_REQUIRED_LAT = 75;
    static final int COFFEE_BEAN_AMT_REQUIRED_LAT = 20;
    static final int COST_PER_SERVING_LAT = 7;
    static final int WATER_AMT_REQUIRED_CAP = 200;
    static final int MILK_AMT_REQUIRED_CAP = 100;
    static final int COFFEE_BEAN_AMT_REQUIRED_CAP = 12;
    static final int COST_PER_SERVING_CAP = 6;
    static final int ZERO = 0;

    static void runCoffeeMachine() {
        boolean exit = false;

        while(!exit) {

            switch (getAction()) {

                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    inventory();
                    break;
                case "exit":
                    exit = true;
                    break;
            }
        }
    }

    static void inventory() {
        System.out.format("%d ml of water \n", waterInStock);
        System.out.format("%d ml of milk \n", milkInStock);
        System.out.format("%d g of coffee beans \n", coffeeBeansInStock);
        System.out.format("%d disposable cups \n", disposableCups);
        System.out.format("$%d of money \n", salesAmount);
    }

    static String getAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String actionInput = scanner.next();
        return actionInput;
    }

    static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, " +
                "2 - latte, 3 - cappuccino:");
        String coffeeChoice = scanner.next();

        switch (coffeeChoice) {
            case "1":
                availableCondiments(coffeeChoice);
                displayMessage(coffeeChoice);
                if (enoughWater && enoughCoffeeBeans &&
                        enoughDisposableCups) {

                    waterInStock = waterInStock - WATER_AMT_REQUIRED_ESPR;
                    coffeeBeansInStock = coffeeBeansInStock -
                            COFFEE_BEAN_AMT_REQUIRED_ESPR;
                    disposableCups -= 1;
                    salesAmount = salesAmount + COST_PER_SERVING_ESPR;
                }
                break;
            case "2":
                availableCondiments(coffeeChoice);
                displayMessage(coffeeChoice);
                if (enoughWater && enoughMilk && enoughCoffeeBeans &&
                        enoughDisposableCups) {
                    waterInStock = waterInStock - WATER_AMT_REQUIRED_LAT;
                    milkInStock = milkInStock - MILK_AMT_REQUIRED_LAT;
                    coffeeBeansInStock = coffeeBeansInStock -
                            COFFEE_BEAN_AMT_REQUIRED_LAT;
                    disposableCups -= 1;
                    salesAmount = salesAmount + COST_PER_SERVING_LAT;
                }

                break;
            case "3":
                availableCondiments(coffeeChoice);
                displayMessage(coffeeChoice);
                if (enoughWater && enoughMilk && enoughCoffeeBeans &&
                        enoughDisposableCups) {
                    waterInStock = waterInStock - WATER_AMT_REQUIRED_CAP;
                    milkInStock = milkInStock - MILK_AMT_REQUIRED_CAP;
                    coffeeBeansInStock = coffeeBeansInStock -
                            COFFEE_BEAN_AMT_REQUIRED_CAP;
                    disposableCups -= 1;
                    salesAmount = salesAmount + COST_PER_SERVING_CAP;
                }
                break;
            case "back":
                break;
        }
        enoughWater = true;
        enoughMilk = true;
        enoughCoffeeBeans = true;
        enoughDisposableCups = true;
    }

    static void displayMessage(String coffeeChoice) {

        switch (coffeeChoice) {
            case "1":
                if (enoughWater && enoughCoffeeBeans &&
                        enoughDisposableCups) {
                    System.out.println("I have enough resources, making you a coffee!");
                } else {
                    if (!enoughWater) {
                        System.out.println("Sorry, not enough water!");
                    }
                    if (!enoughCoffeeBeans) {
                        System.out.println("Sorry, not enough coffee beans!");
                    }
                    if (!enoughDisposableCups) {
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                }
                break;
            case "2":
                if (enoughWater && enoughMilk && enoughCoffeeBeans &&
                        enoughDisposableCups) {
                    System.out.println("I have enough resources, making you a coffee!");
                } else {
                    if (!enoughWater) {
                        System.out.println("Sorry, not enough water!");
                    }
                    if (!enoughMilk) {
                        System.out.println("Sorry, not enough milk!");
                    }
                    if (!enoughCoffeeBeans) {
                        System.out.println("Sorry, not enough coffee beans!");
                    }
                    if (!enoughDisposableCups) {
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                }
                break;
            case "3":
                if (enoughWater && enoughMilk && enoughCoffeeBeans &&
                        enoughDisposableCups) {
                    System.out.println("I have enough resources, making you a coffee!");
                } else {
                    if (!enoughWater) {
                        System.out.println("Sorry, not enough water!");
                    }
                    if (!enoughMilk) {
                        System.out.println("Sorry, not enough milk!");
                    }
                    if (!enoughCoffeeBeans) {
                        System.out.println("Sorry, not enough coffee beans!");
                    }
                    if (!enoughDisposableCups) {
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                }
                break;
        }
    }

    static void availableCondiments(String coffeeChoice) {

        switch (coffeeChoice) {
            case "1":
                if (WATER_AMT_REQUIRED_ESPR > waterInStock) {
                    enoughWater = false;
                }
                if (COFFEE_BEAN_AMT_REQUIRED_ESPR > coffeeBeansInStock) {
                    enoughCoffeeBeans = false;
                }
                if (disposableCups == ZERO) {
                    enoughDisposableCups = false;
                }
                break;
            case "2":
                if (WATER_AMT_REQUIRED_LAT > waterInStock) {
                    enoughWater = false;
                }
                if (MILK_AMT_REQUIRED_LAT > coffeeBeansInStock) {
                    enoughCoffeeBeans = false;
                }
                if (COFFEE_BEAN_AMT_REQUIRED_LAT > coffeeBeansInStock) {
                    enoughCoffeeBeans = false;
                }
                if (disposableCups == ZERO) {
                    enoughDisposableCups = false;
                }
                break;
            case "3":
                if (WATER_AMT_REQUIRED_CAP > waterInStock) {
                    enoughWater = false;
                }
                if (MILK_AMT_REQUIRED_CAP > coffeeBeansInStock) {
                    enoughCoffeeBeans = false;
                }
                if (COFFEE_BEAN_AMT_REQUIRED_CAP > coffeeBeansInStock) {
                    enoughCoffeeBeans = false;
                }
                if (disposableCups == ZERO) {
                    enoughDisposableCups = false;
                }
                break;

        }
    }

    static void fill() {

        System.out.println("Write how many ml of water you want to add:");
        int waterAmount = scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        int milkAmount = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        int coffeeBeanAmount = scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee you want to add:");
        int numOfDispCups = scanner.nextInt();

        waterInStock = waterInStock + waterAmount;
        milkInStock = milkInStock + milkAmount;
        coffeeBeansInStock = coffeeBeansInStock + coffeeBeanAmount;
        disposableCups = disposableCups + numOfDispCups;
    }

    static void take() {
        System.out.format("I gave you $%d \n", salesAmount);
        salesAmount = salesAmount - salesAmount;

    }
}

class CoffeeMachineRunner {
    public static void main(String[] args) {

        CoffeeMachine.runCoffeeMachine();

    }
}