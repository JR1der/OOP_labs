/**
 * Intefrace PaymentMethod which has a function.
 *
 * @author Ivan Popovych
 */
interface PaymentMethod {
    /**
     * Function for all the payments methods
     *
     * @param amount - indicates the amount of money needed to pay
     */
    void pay(double amount);
}
