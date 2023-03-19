import com.opencsv.exceptions.CsvValidationException;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static junit.framework.Assert.fail;

public class StateCensusAnalyzerTest {
    @Test
    public void givenStateCensusCSV_CheckNumberOfRecordsMatches() throws CsvValidationException, IOException {
        StateCensusAnalyzer analyzer = new StateCensusAnalyzer();
        int count = analyzer.loadAnalyzer();
        Assert.assertEquals(5, count, 0);
    }

    @Test
    public void givenStateCensusCSV_ThrowCustomException() throws Exception {
        try {
            StateCensusAnalyzer analyzer = new StateCensusAnalyzer();
            if(analyzer.loadAnalyzer()==0)
            throw new CustomExceptionIncorrectFile();
        } catch (CustomExceptionIncorrectFile e) {
            System.out.println(e.toString());
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
