import java.math.BigDecimal;

public class BlackCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Black Coffee";
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal("100.00");
    }
}
