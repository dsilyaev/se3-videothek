package videothek.pricing;

public interface PricingStrategy {
    double getCharge(int daysRented);
    int getFrequentRenterPoints(int daysRented);
}
