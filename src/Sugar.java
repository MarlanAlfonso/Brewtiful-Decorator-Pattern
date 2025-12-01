import java.math.BigDecimal;

public class Sugar extends CoffeeDecorator {

    private static final BigDecimal SUGAR_COST = new BigDecimal("10.00");

    public Sugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return wrappedCoffee.getDescription() + ", Sugar";
    }

    @Override
    public BigDecimal getCost() {
        return wrappedCoffee.getCost().add(SUGAR_COST);
    }
}
