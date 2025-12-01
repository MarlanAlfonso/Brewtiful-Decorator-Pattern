import java.math.BigDecimal;

public class NoAddition extends CoffeeDecorator {

    public NoAddition(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return wrappedCoffee.getDescription(); // no change
    }

    @Override
    public BigDecimal getCost() {
        return wrappedCoffee.getCost(); // no extra cost
    }
}
