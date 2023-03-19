import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class
StateCensusAnalyzer {

    public int loadAnalyzer() throws IOException, CsvValidationException {
        File file = new File("StateCensus.csv");
        CSVReader reader = new CSVReader(new FileReader(file));
        ArrayList<String> censusList = new ArrayList<>();
        String[] line;
        int count=0;
        while ((line = reader.readNext()) != null){
            ++count;
        }
        return count;
    }
}
