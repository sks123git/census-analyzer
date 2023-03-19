import com.opencsv.exceptions.CsvValidationException;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class StateCensusAnalyzerTest {
@Test
    public void givenStateCensusCSV_CheckNumberOfRecordsMatches() throws CsvValidationException, IOException {
    StateCensusAnalyzer analyzer = new StateCensusAnalyzer();
    int count = analyzer.loadAnalyzer();
    Assert.assertEquals(5,count,0);
}
}
