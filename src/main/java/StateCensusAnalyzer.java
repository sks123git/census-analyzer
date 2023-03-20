import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class
StateCensusAnalyzer {

    public int loadAnalyzer() throws Exception{
        int count = 0,lineNumber = 0;
        ArrayList<Census> censusList = new ArrayList<>();
        File file;
        CSVReader reader;
        try {
           try {
               file = new File("StateCensus.csv");
               reader = new CSVReader(new FileReader(file));
           }catch (RuntimeException e){
               throw new CustomExceptionIncorrectFile();
           }

            String[] line;
              try {
                  while ((line = reader.readNext()) != null) {
                      if (lineNumber == 0) {
                          lineNumber++;
                          continue;
                      }
                      ++count;
                      try {
                          censusList.add(new Census(Integer.valueOf(line[0]), line[1], line[2]));
                      } catch (NumberFormatException e) {
                          throw new TypeIncorrect();
                      }
                  }
              }catch (com.opencsv.exceptions.CsvMalformedLineException e){
                  throw new DelimiterIncorrectException();
              }
            if(count!=censusList.size()-1){
                throw new CustomExceptionIncorrectFile();
            }
            censusList.forEach(System.out::println);

        }catch (CustomExceptionIncorrectFile e){
            System.out.println(e);
        }catch (TypeIncorrect exp){
            System.out.println(exp);
        }catch (DelimiterIncorrectException exception){
            System.out.println(exception);
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        StateCensusAnalyzer analyzer = new StateCensusAnalyzer();
            int c = analyzer.loadAnalyzer();
           System.out.println(c);
    }
}
