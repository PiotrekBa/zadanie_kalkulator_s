package pl.piotrbartoszak.repository;

import org.springframework.stereotype.Repository;
import pl.piotrbartoszak.model.Currency;
import pl.piotrbartoszak.service.ReadFileService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CurrencyRepository {
    private List<Currency> currencies;

    public CurrencyRepository() {
        this.currencies = new ArrayList<>();
        List<String> currenciesList = ReadFileService.readFile();

        for(String s : currenciesList) {
            Currency c = convertStringToCurrency(s);
            if(c != null) {
                currencies.add(c);
            }
        }
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    private Currency convertStringToCurrency(String s) {
        String[] parts = s.split(",");
        if(parts.length != 4) {
            return null;
        }

        String countrySymbol = parts[0].trim();
        String currencySymbol = parts[3].trim();

        int taxPercent;
        int fixedCosts;

        try {
            taxPercent = Integer.parseInt(parts[1].trim().replace("%",""));
            fixedCosts = Integer.parseInt(parts[2].trim());
        } catch (NumberFormatException e) {
            return null;
        }

        Currency currency = new Currency(countrySymbol, taxPercent, fixedCosts, currencySymbol);

        return currency;
    }
}
