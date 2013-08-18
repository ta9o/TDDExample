/**
 * User: imbe
 */
public class Franc extends Money {

    Franc(int amount, String currency) {
        super(amount, currency);
    }
    Money times(int multiplier) {
        return Money.franc(amount * multiplier);
    }

    @Override
    public String currency() {
        return currency;
    }
}
