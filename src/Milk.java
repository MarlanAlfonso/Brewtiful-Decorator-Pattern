import java.math.BigDecimal;

public class Milk extends CoffeeDecorator {

    private static final BigDecimal MILK_COST = new BigDecimal("25.00");

    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return wrappedCoffee.getDescription() + ", Milk";
    }

    @Override
    public BigDecimal getCost() {
        return wrappedCoffee.getCost().add(MILK_COST);
    }
}
