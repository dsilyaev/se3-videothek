public class NewReleasePricing implements PricingStrategy {
    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        if (daysRented > 2) {
            return 2;
        }
        return 1;
    }
}
