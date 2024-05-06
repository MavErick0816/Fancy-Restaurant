import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        PrintMenu();


        boolean doneOrder = false;
        boolean orderGood = false;
        boolean finishedGood = false;
        boolean paymentGood = false;
        boolean paymentEnough = false;
        double totalPrice = 0;
        double cash = 0;
        double change = 0;
        int order;
        int done;
        int caviar = 0;
        int burger = 0;
        int wagyu = 0;
        int oyster = 0;
        int lobster = 0;
        int cake = 0;


        while (doneOrder == false) {

            System.out.println("Choose from the menu options, picking one number at a time");



            while (orderGood == false) {
                order = NumberCheck();

                if (order == 1) {
                    caviar = caviar + 1;
                    orderGood = true;
                } else if (order == 2) {
                    burger = burger + 1;
                    orderGood = true;
                } else if (order == 3) {
                    wagyu = wagyu + 1;
                    orderGood = true;
                } else if (order == 4) {
                    oyster = oyster + 1;
                    orderGood = true;
                } else if (order == 5) {
                    lobster = lobster + 1;
                    orderGood = true;
                } else if (order == 6) {
                    cake = cake + 1;
                    orderGood = true;
                } else if (order > 6 || order < 1) {
                    System.out.println("Sorry that isn't an item.");
                    PrintMenu();
                    System.out.println("Please pick from our menu.");
                }
            }
            orderGood = false;


            System.out.println("Will that be all for today? 1 for Yes, 2 for No.");

            while (finishedGood == false) {
                done = NumberCheck();
                if (done == 1) {
                    doneOrder = true;
                    finishedGood = true;
                } else if (done == 2) {
                    doneOrder = false;
                    finishedGood = true;
                } else {
                    System.out.println("Invalid Number");
                    System.out.println("Was that a yes (1) or a no (2)?");
                }
            }
            finishedGood = false;
        }
        if (doneOrder == true) {

            double caviarPrice = caviar * 79.99;
            double burgerPrice = burger * 22.99;
            double wagyuPrice = wagyu * 59.99;
            double oysterPrice = oyster * 49.99;
            double lobsterPrice = lobster * 69.99;
            double cakePrice = cake * 19.99;
            totalPrice = caviarPrice + burgerPrice + wagyuPrice + oysterPrice + lobsterPrice + cakePrice;

            System.out.println("Your order: ");

            if (caviar == 1) {
                System.out.println(caviar + " Order of Caviar.");
            }
            else if (caviar > 1) {
                System.out.println(caviar + " Orders of Caviar.");
            }

            if (burger == 1) {
                System.out.println(burger + " Gourmet Burger.");
            }
            else if (burger > 1) {
                System.out.println(burger + " Gourmet Burgers.");
            }

            if (wagyu == 1) {
                System.out.println(wagyu + " Wagyu Steak.");
            }
            else if (wagyu > 1) {
                System.out.println(wagyu + " Wagyu Steaks.");
            }

            if (oyster == 1) {
                System.out.println(oyster + " Oyster.");
            }
            else if (oyster > 1) {
                System.out.println(oyster + " Oysters.");
            }

            if (lobster == 1) {
                System.out.println(lobster + " Lobster.");
            }
            else if (lobster > 1) {
                System.out.println(lobster + " Lobsters.");
            }

            if (cake == 1) {
                System.out.println(cake + " Fudge Cake.");
            }
            else if (cake > 1) {
                System.out.println(cake + " Fudge Cakes.");
            }

            System.out.printf("The total price will come out to: $%.2f", totalPrice);
            System.out.println();
            System.out.println();


        }

        System.out.println("Will you be paying in cash or card today?");

        System.out.println("1 for Card, 2 for Cash.");

        while (paymentGood == false) {
            done = NumberCheck();
            if (done == 1) {
                System.out.println("Have a great day.");
                paymentGood = true;
            }
            else if (done == 2) {
                System.out.println("Please enter payment.");

                while (paymentEnough == false) {
                    cash = NumberCheck();
                    change = cash - totalPrice;

                    if (change < 0){
                        System.out.println("Sorry that isn't enough to cover your food.");
                        System.out.println("Please try again.");
                    }
                    else {
                        paymentEnough = true;
                    }
                }

                System.out.printf("The total change will come out to: $%.2f", change);
                System.out.println();
                System.out.println("Have a great day.");
                paymentGood = true;
            }
            else {
                System.out.println("Invalid Number");
                System.out.println("Will that be card (1) or cash (2)?");

            }
        }
    }

    public static void PrintMenu() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("| #1 Caviar: $79.99       #2 Gourmet Burger: $22.99 |");
        System.out.println("| #3 Wagyu Beef: $59.99   #4 Oysters: $49.99        |");
        System.out.println("| #5 Lobster: $69.99      #6 Fudge Cake: $19.99     |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static int NumberCheck(){
        Scanner scanner = new Scanner(System.in);

        int input = 0;
        boolean test = false;

        while (test == false) {
            try {
                input = scanner.nextInt();
                test = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                System.out.println("Please enter a valid number");
                scanner.next();
            }
        }

        return input;
    }
}