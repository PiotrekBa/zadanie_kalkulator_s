package pl.piotrbartoszak.model;

public class Country {
    private String countrySymbol;
    private int taxPercent;
    private int fixedCosts;
    private String currencySymbol;

    public Country(String countrySymbol, int taxPercent, int fixedCosts, String currencySymbol) {
        this.countrySymbol = countrySymbol;
        this.taxPercent = taxPercent;
        this.fixedCosts = fixedCosts;
        this.currencySymbol = currencySymbol;
    }

    public String getCountrySymbol() {
        return countrySymbol;
    }

    public int getTaxPercent() {
        return taxPercent;
    }

    public int getFixedCosts() {
        return fixedCosts;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCountrySymbol(String countrySymbol) {
        this.countrySymbol = countrySymbol;
    }

    public void setTaxPercent(int taxPercent) {
        this.taxPercent = taxPercent;
    }

    public void setFixedCosts(int fixedCosts) {
        this.fixedCosts = fixedCosts;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }
}
