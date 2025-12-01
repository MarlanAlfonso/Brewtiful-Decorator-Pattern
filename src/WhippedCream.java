import java.math.BigDecimal;

public class WhippedCream extends CoffeeDecorator {

    private static final BigDecimal WHIPPED_COST = new BigDecimal("35.00");

    public WhippedCream(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return wrappedCoffee.getDescription() + ", Whipped Cream";
    }

    @Override
    public BigDecimal getCost() {
        return wrappedCoffee.getCost().add(WHIPPED_COST);
    }
}
