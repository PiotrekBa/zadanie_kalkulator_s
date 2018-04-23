import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.piotrbartoszak.model.Currency;
import pl.piotrbartoszak.repository.CurrencyRepository;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CurrencyRepositoryTest {

    @Test
    public void shouldConvertListOfStringsToCurrencyObjects() {
        Currency expectedCarrency =
                new Currency("UK", 25, 600, "GBP");

        CurrencyRepository currencyRepository = new CurrencyRepository();

        List<Currency> currencies = currencyRepository.getCurrencies();

        Currency currencyToCheck = currencies.get(0);

        assertEquals(expectedCarrency.getCountrySymbol(),currencyToCheck.getCountrySymbol());
        assertEquals(expectedCarrency.getTaxPercent(),currencyToCheck.getTaxPercent());
        assertEquals(expectedCarrency.getFixedCosts(),currencyToCheck.getFixedCosts());
        assertEquals(expectedCarrency.getCurrencySymbol(),currencyToCheck.getCurrencySymbol());

    }
}
