package lab01.challenge2;

public class RegularDiscount implements DiscountPolicy {
    @Override
    public double applyDiscount(double total) {
        return total;
    }
}