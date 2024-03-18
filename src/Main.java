import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Main function of the program in which we set up our cards and start our menu.
 *
 * @author Ivan Popovych
 */
public class Main {
    private static Visa visaCard;
    private static MasterCard masterCard;
    private static Crypto metaMask;

    public static void main(String[] args) {
        visaCard = new Visa(1337.77, "Ivan Popovych"); // setting up a Visa card
        masterCard = new MasterCard(0.05, "Ivan Popovych"); // setting up a MasterCard
        metaMask = new Crypto(0.05, "Ivan Popovych"); // setting up a crypto wallet
        Scanner scan = new Scanner(System.in); // creating a scanner
        int userChoice;
        boolean exitRequested = false; // boolean to check if you had pressed the exit button (3)
        while (!exitRequested) { // loop until user decides to exit the program
            userChoice = Menu(); // user choice variable that collects inout from the user
            switch (userChoice) { // switch menu
                case 1:
                    Payment(); // calling our payment function
                    break;
                case 2:
                    System.out.println("Exiting the program");
                    exitRequested = true; // bool is true - exits the program
                default:
                    System.out.println("...");
            }
        }
    }

    /**
     * Main menu function that outputs choices to pick
     *
     * @return choice of the user in menu
     */
    public static int Menu() {
        Scanner scan = new Scanner(System.in);
        int choice = 0; // init of choice variable
        System.out.println("Choose what you want to do:");
        System.out.println("___________________________");
        System.out.println("1 - Pay");
        System.out.println("2 - Exit");
        System.out.println("___________________________");
        try {
            System.out.println("You picked:");
            choice = scan.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR! Insert an integer to choose your future actions!");
        }
        return choice; // returns choice in the main
    }

    /**
     * Method function, which outputs methods of payment and returns the user input
     *
     * @return method - number which indicates the method of payment the user chose.
     */
    public static int Method() {
        Scanner scan = new Scanner(System.in);
        int method = 0;
        System.out.println("Choose your payment method:");
        System.out.println("___________________________");
        System.out.println("1 - Visa");
        System.out.println("2 - MasterCard");
        System.out.println("3 - Crypto");
        System.out.println("___________________________");
        try {
            System.out.println("You picked:");
            method = scan.nextInt();
            if (method < 1 || method > 3) {
                System.out.println("ERROR! Insert a correct integer tho choose your payment method!");
                method = Method();
            }

        } catch (Exception e) {
            System.out.println("ERROR! Insert an integer to choose your payment method!");
            method = Method();
        }
        return method;
    }

    /**
     * Payment function which requires amount of money user needs to pay, then puts user choice of method of payment and passes it into a switch case
     */
    public static void Payment() {
        double amount = Amount();
        int userChoice = Method(); // user choice variable that collects inout from the user
        switch (userChoice) { // switch menu
            case 1:
                visaCard.digital();
                visaCard.pay(amount);
                break;
            case 2:
                masterCard.plastic();
                masterCard.pay(amount);
                break;
            case 3:
                metaMask.digital();
                metaMask.pay(amount);
                break;
            default:
                System.out.println("...");
        }
    }

    public static double Amount() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose the amount you need to pay:");
        System.out.println("___________________________");
        double amount = scan.nextDouble();
        while (BigDecimal.valueOf(amount).scale() > 2 || amount <= 0) {
            System.out.println("ERROR! Print an amount with not more than 2 decimals!");
            System.out.println("Choose the amount you need to pay:");
            System.out.println("___________________________");
            amount = scan.nextDouble();
        }
        return amount;
    }
}