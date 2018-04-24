package pl.piotrbartoszak.model;

import java.math.BigDecimal;

public class Earning {
    private String countrySymbol;
    private BigDecimal monthEarning;

    public Earning() {
    }

    public String getCountrySymbol() {
        return countrySymbol;
    }

    public void setCountrySymbol(String countrySymbol) {
        this.countrySymbol = countrySymbol;
    }

    public BigDecimal getMonthEarning() {
        return monthEarning;
    }

    public void setMonthEarning(BigDecimal monthEarning) {
        this.monthEarning = monthEarning;
    }
}
