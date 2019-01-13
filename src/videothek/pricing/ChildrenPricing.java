package videothek.pricing;

public class ChildrenPricing implements PricingStrategy {
    @Override
    public double getCharge(int daysRented) {
        double price = 1.5;
        if (daysRented > 3)
            price += (daysRented - 3) * 1.5;
        return price;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
