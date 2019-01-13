public class RegularPricing implements PricingStrategy {
    @Override
    public double getCharge(int daysRented) {
        double price = 2;
        if (daysRented > 2)
            price += (daysRented - 2) * 1.5;
        return price;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
