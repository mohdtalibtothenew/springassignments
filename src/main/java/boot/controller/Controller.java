package boot.controller;

import boot.entity.CSVFile;
import boot.service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping
@RestController
public class Controller {

    @Autowired
    CSVService csvService;
//    @Autowired
//    CSVFile csvFile1;
    @GetMapping("/csv")
   public void setData(@RequestParam("addr") String addr ,@RequestParam("cv1") Integer cv1 , @RequestParam("date") String date,
                       @RequestParam("pageURL") String pageURL, @RequestParam("zip") String zip) {



            List<CSVFile> csvFile=new ArrayList();
            for (int i = 0; i <  cv1; i++) {
                CSVFile csvFile1 = new CSVFile();
               // csvFile1.setCv2(csvService.randomAlphaNumeric(13));
                csvFile.add(csvService.setData(addr,date,pageURL,zip,csvFile1));
                System.out.println("Addr"+csvFile);
               //csvFile.add(csvFile); //new CSVFile(addr,cv2,date,pageURL,zip)
            }
            csvService.writer(csvFile);



    }
}
