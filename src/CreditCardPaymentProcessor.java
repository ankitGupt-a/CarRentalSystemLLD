public class CreditCardPaymentProcessor implements PaymentProcessor {

    public void makePayment(final double amount) {
        System.out.println("Payment is successful using credit card for amount " + amount);
    }
}
