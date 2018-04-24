import org.junit.Test;
import pl.piotrbartoszak.model.Country;
import pl.piotrbartoszak.repository.CountryRepository;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CountryRepositoryTest {

    @Test
    public void shouldConvertListOfStringsToCountryObjects() {
        Country expectedCarrency =
                new Country("UK", 25, 600, "GBP");

        CountryRepository countryRepository = new CountryRepository();
        countryRepository.getCountriesFromFile();
        List<Country> countries = countryRepository.getCountries();

        Country countryToCheck = countries.get(0);
        assertEquals(expectedCarrency.getCountrySymbol(), countryToCheck.getCountrySymbol());
        assertEquals(expectedCarrency.getTaxPercent(), countryToCheck.getTaxPercent());
        assertEquals(expectedCarrency.getFixedCosts(), countryToCheck.getFixedCosts());
        assertEquals(expectedCarrency.getCurrencySymbol(), countryToCheck.getCurrencySymbol());

    }
}
