import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * User: imbe
 */
public class MoneyTest {
    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assertThat(Money.dollar(10), is(five.times(2)));
        assertThat(Money.dollar(15), is(five.times(3)));
    }

    @Test
    public void testEquality() {
        assertThat(Money.dollar(5).equals(Money.dollar(5)), is(true));
        assertThat(Money.dollar(5).equals(Money.dollar(6)), is(false));
        assertThat(Money.franc(5).equals(Money.dollar(5)), is(false));
    }

    @Test
    public void testFrancMultiplication() {
        Money five = Money.franc(5);
        assertThat(Money.franc(10), is(five.times(2)));
        assertThat(Money.franc(15), is(five.times(3)));
    }

    @Test
    public void testCurrency() {
        assertThat(Money.dollar(1).currency(), is("USD"));
        assertThat(Money.franc(1).currency(), is("CHF"));
    }

    @Test
    public void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertThat(reduced, is(Money.dollar(10)));
    }

    @Test
    public void testReturnsSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertThat(sum.augend, is(five));
        assertThat(sum.addend, is(five));
    }

    @Test
    public void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertThat(result, is(Money.dollar(7)));
    }

    @Test
    public void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertThat(result, is(Money.dollar(1)));
    }

    @Test
    public void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertThat(result, is(Money.dollar(1)));
    }

    @Test
    public void testArrayEquals() {
        assertThat(new Object[] {"abc"}, is(new Object[] {"abc"}));
    }

    @Test
    public void testIdentityRate() {
        assertThat(new Bank().rate("USD", "USD"), is(1));
    }
}
