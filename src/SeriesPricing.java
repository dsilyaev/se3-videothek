public class SeriesPricing implements PricingStrategy {
    @Override
    public double getCharge(int daysRented) {
        double weekPrice = 3;
        double price = (daysRented / 7) * weekPrice;
        if (daysRented % 7 != 0) {
            price += weekPrice;
        }
        return price;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 2;
    }
}
