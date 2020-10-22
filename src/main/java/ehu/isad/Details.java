package ehu.isad;

import ehu.isad.utils.Utils;

import java.util.Arrays;
import java.util.Properties;

public class Details {
    String[] publishers;
    Integer number_of_pages;
    String title;
    String irudia;

    public String getArgitaletxe(){return publishers[0];}

    public Integer getOrriKop(){return this.number_of_pages;}

    public String getTitle(){return this.title;}

    //public String getIrudia(){return this.irudia;}

    public void setPublishers(String pArgitaletxea){
        this.publishers=new String[10];
        this.publishers[0]=pArgitaletxea;
    }

    public void setNumber_of_pages(int pOK){
        this.number_of_pages=pOK;
    }

    public void setTitle(String pIzenb){
        this.title=pIzenb;
    }

    public void setIrudia(String pIrudia){
        Properties properties= Utils.lortuEzarpenak();
        this.irudia=properties.getProperty("imagePath")+pIrudia;
    }

    @Override
    public String toString() {
        return "Details{" +
                "publishers=" + Arrays.toString(publishers) +
                ", number_of_pages=" + number_of_pages +
                ", title='" + title + '\'' +
                '}';
    }
}
