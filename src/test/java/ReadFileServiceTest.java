import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.piotrbartoszak.service.ReadFileService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ReadFileServiceTest {


    @Test
    public void shouldReadFileAndReturnListOfStrings() {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("UK, 25%, 600, GBP");
        expectedList.add("DE, 20%, 800, EUR");
        expectedList.add("PL, 19%, 1200, PLN");

        ReadFileService rds = new ReadFileService();

        List<String> listToCheck = rds.readFile();

        assertEquals(expectedList,listToCheck);
    }
}
