package pl.piotrbartoszak.repository;

import org.springframework.stereotype.Repository;
import pl.piotrbartoszak.model.Currency;

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
        
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }
}
