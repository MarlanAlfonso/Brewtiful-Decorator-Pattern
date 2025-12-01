import java.math.BigDecimal;

public abstract class CoffeeDecorator implements Coffee {

    protected Coffee wrappedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.wrappedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return wrappedCoffee.getDescription();
    }

    @Override
    public BigDecimal getCost() {
        return wrappedCoffee.getCost();
    }
}
