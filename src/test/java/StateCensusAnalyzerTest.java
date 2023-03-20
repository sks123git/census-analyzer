import com.opencsv.exceptions.CsvValidationException;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class StateCensusAnalyzerTest {
    @Test
    public void givenStateCensusCSV_CheckNumberOfRecordsMatches() throws Exception {
        StateCensusAnalyzer analyzer = new StateCensusAnalyzer();
        int count = analyzer.loadAnalyzer();
        Assert.assertEquals(4, count, 0);
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
    @Test
    public void givenStateCensusCSV_IfTypeIncorrectThrowCustomException() throws Exception {
        StateCensusAnalyzer analyzer = new StateCensusAnalyzer();
        int count = analyzer.loadAnalyzer();
        Assert.assertEquals(4, count, 0);
    }
    @Test
    public void givenStateCensusCSV_IfDelimiterIncorrectThrowCustomException() throws Exception {
        StateCensusAnalyzer analyzer = new StateCensusAnalyzer();
        int count = analyzer.loadAnalyzer();
        Assert.assertEquals(4, count, 0);
    }
}
