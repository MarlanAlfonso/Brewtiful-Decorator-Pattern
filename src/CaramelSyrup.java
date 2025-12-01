import java.math.BigDecimal;

public class CaramelSyrup extends CoffeeDecorator {

    private static final BigDecimal CARAMEL_COST = new BigDecimal("40.00");

    public CaramelSyrup(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return wrappedCoffee.getDescription() + ", Caramel Syrup";
    }

    @Override
    public BigDecimal getCost() {
        return wrappedCoffee.getCost().add(CARAMEL_COST);
    }
}
