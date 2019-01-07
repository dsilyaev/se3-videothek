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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental r : rentals) {
            double thisAmount = amountFor(r);

            // add frequent renter points, add bonus, etc.
            frequentRenterPoints++;

            // add bonus for a two day new release rental
            if (r.getMovie().getPriceCode() == Movie.NEW_RELEASE &&
                    r.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            // show figures for this rental
            result += "\t" + r.getMovie().getTitle() + "\t" + thisAmount + "\n";

            // add frequent renter points, add bonus
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints
                + " frequent renter points";
        return result;
    }

    private double amountFor(Rental r) {
        double thisAmount = 0;
        switch (r.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (r.getDaysRented() > 2)
                    thisAmount += (r.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += r.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                thisAmount += 1.5;
                if (r.getDaysRented() > 3)
                    thisAmount += (r.getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }
}
