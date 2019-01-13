import java.util.ArrayList;
import java.util.List;

public class CustomerTest {
    private Customer customer = new Customer("John Smith");
    private List<Movie> movies = new ArrayList<>();

    @org.junit.Before
    public void setUp() {
        movies.add(new Movie("Avengers: Infinity War", new NewReleasePricing()));
        movies.add(new Movie("Guardians of the Galaxy", new RegularPricing()));
        movies.add(new Movie("Lion King", new ChildrenPricing()));

        customer.addRental(new Rental(movies.get(0), 3));
        customer.addRental(new Rental(movies.get(1), 5));
        customer.addRental(new Rental(movies.get(2), 7));
    }

    @org.junit.Test
    public void statement() {
        System.out.println(customer.statement());
    }
}