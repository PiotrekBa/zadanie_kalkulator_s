package pl.piotrbartoszak.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piotrbartoszak.model.Country;
import pl.piotrbartoszak.model.Earning;
import pl.piotrbartoszak.repository.CountryRepository;

import java.math.BigDecimal;

@Service
public class CalculateEarningService {
    @Autowired
    CountryRepository countryRepository;

    private int daysInMonth = 22;


    public Earning calculateEarning(String s, Country c) {
        BigDecimal dailyRate = converterFromString(s);

        BigDecimal monthEarning = BigDecimal.valueOf(daysInMonth).multiply(dailyRate);
        CountryRepository cr = new CountryRepository();
        cr.getCountriesFromFile();

        monthEarning = monthEarning.add(BigDecimal.valueOf(-c.getFixedCosts()));
        monthEarning = monthEarning.multiply(BigDecimal.valueOf(1-c.getTaxPercent()/100));
        monthEarning = monthEarning.multiply(c.getExchangeRate()).setScale(2);

        Earning earning = new Earning();
        earning.setCountrySymbol(c.getCountrySymbol());
        earning.setMonthEarning(monthEarning);

        return earning;
    }



    private BigDecimal converterFromString(String dailyRate) {

        JSONObject jsonObject = new JSONObject(dailyRate);
        String value = (String) jsonObject.get("value");
        return new BigDecimal(value);
    }

}
