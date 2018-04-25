import org.junit.Test;
import pl.piotrbartoszak.model.Country;
import pl.piotrbartoszak.model.Earning;
import pl.piotrbartoszak.service.CalculateEarningService;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CalculateEarningServiceTest {

    @Test
    public void shouldCalculateEarning() {
        Earning expectedEarning = new Earning();

        expectedEarning.setCountrySymbol("UK");
        expectedEarning.setMonthEarning(BigDecimal.valueOf(5760.24));

        Country actualCountry = new Country("UK", 25, 600, "GBP");
        actualCountry.setExchangeRate(BigDecimal.valueOf(4.8002));

        CalculateEarningService cea = new CalculateEarningService();
        Earning earningToCheck = cea.calculateEarning("{\"value\": \"100\"}", actualCountry);


        assertEquals(earningToCheck.getCountrySymbol(),expectedEarning.getCountrySymbol());
        assertEquals(earningToCheck.getMonthEarning(),expectedEarning.getMonthEarning());

    }
}
