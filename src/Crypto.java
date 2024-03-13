/**
 * Visa class, creates a crypto wallet with balance and cardholder's name on it
 *
 * @author Ivan Popovych
 */
public class Crypto implements PaymentMethod, NFC {
    private double balance;
    public String cardholder;

    public Crypto(double balance, String cardholder) { // constructor
        this.balance = balance;
        this.cardholder = cardholder;
    }

    /**
     * Function that takes money from your wallet and in case if there is not enough money, outputs an alert
     *
     * @param amount - amount of money you need to pay from your bank account
     */
    @Override
    public void pay(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            System.out.println("The transaction was completed successfully! Amount payed is: " + amount + '$' + ". The balance of " + this.cardholder + " crypto wallet is: " + this.balance + "$.");
        } else {
            System.out.println("Error! Your balance is too small to pay. It must be " + (amount - this.balance) + "$ higher.");
        }
    }

    /**
     * Digital payment using NFC action
     */
    @Override
    public void digital() {
        System.out.println("Unlocking the phone and paying with your crypto wallet using NFC.");
    }
}
