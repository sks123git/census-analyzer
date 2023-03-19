import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;

public class
StateCensusAnalyzer {

    public int loadAnalyzer() throws IOException, CsvValidationException {
        int count = 0;
        try {
            File file = new File("StateCen.csv");
            CSVReader reader = new CSVReader(new FileReader(file));
            ArrayList<String> censusList = new ArrayList<>();
            String[] line;

            while ((line = reader.readNext()) != null) {
                ++count;
            }

        }catch (Exception e){

        }
        return count;
    }
}
