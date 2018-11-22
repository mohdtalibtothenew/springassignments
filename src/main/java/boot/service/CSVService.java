package boot.service;

import boot.entity.CSVFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


@Service
public class CSVService {

    @Autowired
    CSVService csvService;
    public  String randomAlphaNumeric(int count) {
        final String ALPHA_NUMERIC_STRING = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-";

        StringBuilder builder = new StringBuilder();

        while (count-- != 0) {

            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());

            builder.append(ALPHA_NUMERIC_STRING.charAt(character)).toString();

        }

        return "u-"+builder.toString();

    }




   public CSVFile setData(String addr, String date,
                       String pageURL, String zip,CSVFile csvFile){
//CSVFile csvFile =new CSVFile();
       csvFile.setCv2(randomAlphaNumeric(13));
       csvFile.setAddr(addr);
       csvFile.setDate(date);
       csvFile.setPageURL(pageURL);
       csvFile.setZip(zip);
       System.out.println(csvFile.getPageURL());
       return csvFile;
   }
    private static final String NEW_LINE_SEPARATOR = "\n";

    private static final String COMMA_DELIMITER = ",";

    public  FileWriter writer(List<CSVFile> csvFileList) {
        File file = new File("file.csv");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            /*fileWriter.append(header);
            fileWriter.append(NEW_LINE_SEPARATOR);*/
            for (CSVFile csvFile : csvFileList) {
                fileWriter.append((csvFile.getAddr()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append((csvFile.getCv2()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append( csvFile.getDate());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(csvFile.getPageURL());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append((csvFile.getZip()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (IOException e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
        System.out.println("Data have been written in csv file");
        return fileWriter;
    }
}
