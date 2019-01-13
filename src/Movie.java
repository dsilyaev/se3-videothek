public class Movie {
    private final String title;
    private PricingStrategy pricingStrategy;

    public Movie(String title, PricingStrategy pricingStrategy) {
        this.title = title;
        this.pricingStrategy = pricingStrategy;
    }

    public String getTitle() {
        return title;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }
}
