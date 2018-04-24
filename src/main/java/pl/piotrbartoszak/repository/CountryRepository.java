package pl.piotrbartoszak.repository;

import org.springframework.stereotype.Repository;
import pl.piotrbartoszak.model.Country;
import pl.piotrbartoszak.service.CheckCurrencyService;
import pl.piotrbartoszak.service.ReadFileService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CountryRepository {

    private List<Country> countries;

    public void getCountriesFromFile() {
        this.countries = new ArrayList<>();
        List<String> currenciesList = ReadFileService.readFile();

        for (String s : currenciesList) {
            Country c = convertStringToCountry(s);
            if (c != null) {
                BigDecimal rate = CheckCurrencyService.getCurrencyExchangeRate(c.getCurrencySymbol());
                if (rate != null) {
                    c.setExchangeRate(rate);
                    countries.add(c);
                }
            }
        }
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    private static Country convertStringToCountry(String s) {
        String[] parts = s.split(",");
        if (parts.length != 4) {
            return null;
        }

        String countrySymbol = parts[0].trim();
        String currencySymbol = parts[3].trim();

        int taxPercent;
        int fixedCosts;

        try {
            taxPercent = Integer.parseInt(parts[1].trim().replace("%", ""));
            fixedCosts = Integer.parseInt(parts[2].trim());
        } catch (NumberFormatException e) {
            return null;
        }

        Country country = new Country(countrySymbol, taxPercent, fixedCosts, currencySymbol);

        return country;
    }
}
