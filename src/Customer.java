import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        for (Rental r : rentals) {
            // show figures for this rental
            result += "\t" + r.getMovie().getTitle() + "\t" + r.getCharge() + "\n";
        }
        // add footer lines
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints()
                + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        for (Rental r : rentals) {
            result += r.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
    }
}
