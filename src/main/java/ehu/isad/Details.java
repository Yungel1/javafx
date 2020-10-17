package ehu.isad;

import java.util.Arrays;

public class Details {
    String[] publishers;
    Integer number_of_pages;
    String title;

    public String getArgitaletxe(){return publishers[0];}

    public Integer getOrriKop(){return this.number_of_pages;}

    public String getTitle(){return this.title;}

    @Override
    public String toString() {
        return "Details{" +
                "publishers=" + Arrays.toString(publishers) +
                ", number_of_pages=" + number_of_pages +
                ", title='" + title + '\'' +
                '}';
    }
}
