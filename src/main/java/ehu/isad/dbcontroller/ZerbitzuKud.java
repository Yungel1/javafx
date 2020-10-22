package ehu.isad.dbcontroller;

import ehu.isad.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZerbitzuKud {

    private static final ZerbitzuKud instance = new ZerbitzuKud();

    public static ZerbitzuKud getInstance() {
        return instance;
    }

    private ZerbitzuKud() {
    }

    public List<Book> lortuZerbitzuak() {

        String query = "select isbn,izenburua from liburuak";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        List<Book> emaitza = new ArrayList<>();
        try {
            while (rs.next()) {
                String isbn=rs.getString("isbn");
                String izenburua = rs.getString("izenburua");
                Book book=new Book(isbn,izenburua);
                emaitza.add(book);

            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return emaitza;
    }
    public Book liburuaLortu(String isbn) throws SQLException {
        String query = "select izenburua,irudia,argitaletxea,orriKop from liburuak where liburuak.isbn like '"+isbn+"';";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);
        rs.next();
        if(rs.getString("argitaletxea")==null){
            return null;
        }
        else{
            Book book=new Book(isbn,rs.getString("izenburua"));
            book.setDatuak(rs.getString("izenburua"),rs.getString("irudia"),
                    rs.getString("argitaletxea"),rs.getInt("orriKop"));
            return book;
        }
    }
    public void beteLiburua(Book book,String isbn,String irudia){
        String query = "update liburuak set argitaletxea=\""+book.getDetails().getArgitaletxe()+
                "\",orriKop="+book.getDetails().getOrriKop()+",irudia='"+irudia+"'" +
                " where isbn='"+isbn+"';";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        dbKudeatzaile.execSQL(query);
    }
}