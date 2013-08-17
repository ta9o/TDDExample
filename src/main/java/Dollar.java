/**
 * Created with IntelliJ IDEA.
 * User: imbe
 * Date: 8/17/13
 * Time: 12:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Dollar {
    public int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public void times(int multiplier) {
        amount = amount * multiplier;
    }
}
