package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvParser  {
    public static void createCsvFile (ArrayList<String> headElements, ArrayList<String> dataRows, String pathToFile) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(pathToFile);
            writer.write(String.join(",", headElements) + "\n");
            for (String row : dataRows) {
                writer.write(row);
            }
        }
        catch (IOException e){
            throw new RuntimeException("Can't write csv file ", e);
        }
        finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException("Can't close csv file ");
            }
        }
    }
}
