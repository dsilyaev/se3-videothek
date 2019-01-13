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
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    public String statementHtml() {
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<!DOCTYPE html>" + "\n")
                .append("<html>" + "\n")
                .append("<head>" + "\n")
                .append("\t" + "<title>Videothek</title>" + "\n")
                .append("\t" + "<style>table, th, td {border: 1px solid black;}</style>" + "\n")
                .append("</head>" + "\n")
                .append("<body>" + "\n")
                .append(String.format("\t" + "<p>Rental Record for %s</p>" + "\n", getName()))
                .append("\t" + "<table>" + "\n")
                .append("\t\t" + "<tr><th>Title</th><th>Price</th></tr>" + "\n");
        for (Rental r : rentals) {
            htmlBuilder.append(String.format("\t\t" +"<tr><td>%s</td><td>%.2f</td></tr>" + "\n",
                    r.getMovie().getTitle(), r.getCharge()));
        }
        htmlBuilder.append("\t" + "</table>" + "\n")
                .append(String.format("\t" + "<p>Amount owed is %.2f</p>" + "\n", getTotalCharge()))
                .append(String.format("\t" + "<p>You earned %d frequent renter points</p>" + "\n",
                        getTotalFrequentRenterPoints()))
                .append("</body>" + "\n")
                .append("</html>" + "\n");
        return htmlBuilder.toString();
    }

    private double getTotalCharge() {
        return rentals.stream().mapToDouble(Rental::getCharge).sum();
    }

    private int getTotalFrequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
    }
}
