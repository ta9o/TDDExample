import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * User: imbe
 */
public class MoneyTest {
    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        assertThat(new Dollar(10), is(five.times(2)));
        assertThat(new Dollar(15), is(five.times(3)));
    }

    @Test
    public void testEquality() {
        assertThat(new Dollar(5).equals(new Dollar(5)), is(true));
        assertThat(new Dollar(5).equals(new Dollar(6)), is(false));
    }

    @Test
    public void testFrancMultiplication() {
        Franc five = new Franc(5);
        assertThat(new Franc(10), is(five.times(2)));
        assertThat(new Franc(15), is(five.times(3)));
    }
}
