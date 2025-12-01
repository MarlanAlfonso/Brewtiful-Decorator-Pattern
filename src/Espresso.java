import java.math.BigDecimal;

public class Espresso implements Coffee {

    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal("100.00");
    }
}
