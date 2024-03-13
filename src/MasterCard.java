/**
 * Visa class, creates a MasterCard card with balance and cardholder's name on it
 *
 * @author Ivan Popovych
 */
public class MasterCard implements PaymentMethod, Plastic, NFC {
    private double balance;
    public String cardholder;

    public MasterCard(double balance, String cardholder) { // constructor
        this.balance = balance;
        this.cardholder = cardholder;
    }

    /**
     * Function that takes money from your card and in case if there is not enough money, outputs an alert
     *
     * @param amount - amount of money you need to pay from your bank account
     */
    @Override
    public void pay(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            System.out.println("The transaction was completed successfully! Amount payed is: " + amount + '$' + ". The balance of " + this.cardholder + " MasterCard card is: " + this.balance + "$.");
        } else {
            System.out.println("Error! Your balance is too small to pay. It must be " + (amount - this.balance) + "$ higher.");
        }
    }

    /**
     * Digital payment using NFC action
     */
    @Override
    public void digital() {
        System.out.println("Unlocking the phone and paying with google pay or apple pay with your MasterCard.");
    }

    /**
     * Physical card payment using a plastic card
     */
    @Override
    public void plastic() {
        System.out.println("Taking your MasterCard out of the wallet and paying with it.");
    }

}
