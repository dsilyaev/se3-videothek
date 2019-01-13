package videothek;

import videothek.pricing.ChildrenPricing;
import videothek.pricing.NewReleasePricing;
import videothek.pricing.RegularPricing;
import videothek.pricing.SeriesPricing;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class CustomerTest {
    private Customer customer = new Customer("John Smith");
    private List<Movie> movies = new ArrayList<>();

    @org.junit.Before
    public void setUp() {
        movies.add(new Movie("Avengers: Infinity War", new NewReleasePricing()));
        movies.add(new Movie("Guardians of the Galaxy", new RegularPricing()));
        movies.add(new Movie("Lion King", new ChildrenPricing()));
        movies.add(new Movie("Friends", new SeriesPricing()));

        customer.addRental(new Rental(movies.get(0), 3));
        customer.addRental(new Rental(movies.get(1), 5));
        customer.addRental(new Rental(movies.get(2), 7));
        customer.addRental(new Rental(movies.get(3), 30));
    }

    @org.junit.Test
    public void statement() {
        System.out.println(customer.statement());
    }

    @org.junit.Test
    public void statementHtml() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("rental-record.html"), "UTF-8"))) {
            writer.write(customer.statementHtml());
        }
    }
}