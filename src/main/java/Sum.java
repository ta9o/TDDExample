/**
 * Created with IntelliJ IDEA.
 * User: imbe
 * Date: 8/18/13
 * Time: 3:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sum implements Expression {
    Money augend;
    Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to) {
        int amount = augend.amount + addend.amount;
        return new Money(amount, to);
    }
}
