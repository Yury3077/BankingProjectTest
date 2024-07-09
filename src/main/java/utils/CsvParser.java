package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvParser  {
    public static void createCsvFile (ArrayList<String> headElements, ArrayList<String> dataRows, String pathToFile)
            throws IOException {
        FileWriter writer = new FileWriter("output.csv");
        try {
            writer.write(String.join(",", headElements) + "\n");
            for (String row : dataRows) {
                writer.write(row);
            }
        }
        catch (IOException e){
            throw new IOException("Can't write csv file ", e);
        }
        finally {
            writer.close();
        }
    }
}
