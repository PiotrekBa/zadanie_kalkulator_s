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
    private int daysInMonth = 22;


    public Earning calculateEarning(String s, Country c) {
        BigDecimal dailyRate = converterFromString(s);

        BigDecimal monthEarning = BigDecimal.valueOf(daysInMonth).multiply(dailyRate);

        BigDecimal tax = BigDecimal.valueOf((100 - c.getTaxPercent())).divide(BigDecimal.valueOf(100));

        monthEarning = monthEarning.add(BigDecimal.valueOf(-c.getFixedCosts()));

        if (monthEarning.doubleValue() > 0) {
            monthEarning = monthEarning.multiply(tax);
        }

        monthEarning = monthEarning.multiply(c.getExchangeRate());

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
