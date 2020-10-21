package ehu.isad;

public class Book {
    String isbn;
    String title;

    String info_url;
    String bib_key;
    String preview_url;
    String thumbnail_url;
    Details details;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public String getIsbn(){return this.isbn;}

    public Details getDetails(){return this.details;}

    public String getThumbnail_url(){return this.thumbnail_url;};

    public void setDatuak(String pIzenburua, String pIrudia, String pArgitaletxea, int pOrriKop){
        details.setNumber_of_pages(pOrriKop);
        details.setPublishers(pArgitaletxea);
        details.setTitle(pIzenburua);
        //details.setIrudia(pIrudia);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", info_url='" + info_url + '\'' +
                ", bib_key='" + bib_key + '\'' +
                ", preview_url='" + preview_url + '\'' +
                ", thumbnail_url='" + thumbnail_url + '\'' +
                ", details=" + details +
                '}';
    }
}
