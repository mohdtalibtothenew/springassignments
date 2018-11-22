package boot.entity;

import java.util.Date;
public class CSVFile {
    private String addr;
   // private String cv1;
    private String cv2;
    private String date;
    private String pageURL;
    private String zip;

    public CSVFile() {
    }

    public CSVFile(String addr, /*String cv1,*/ String cv2, String date, String pageURL, String zip) {
        this.addr = addr;
       // this.cv1 = cv1;
        this.cv2 = cv2;
        this.date = date;
        this.pageURL = pageURL;
        this.zip = zip;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    /*public String getCv1() {
        return cv1;
    }*/

/*
    public void setCv1(String cv1) {
        this.cv1 = cv1;
    }
*/

    public String getCv2() {
        return cv2;
    }

    public void setCv2(String cv2) {
        this.cv2 = cv2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "CSVFile{" +
                "addr='" + addr + '\'' +
                ", cv2='" + cv2 + '\'' +
                ", date='" + date + '\'' +
                ", pageURL='" + pageURL + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
