package ehu.isad.controller.db;

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

    public List<String> lortuZerbitzuak() {

        String query = "select id, izena from services";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        List<String> emaitza = new ArrayList<>();
        try {
            while (rs.next()) {

                int kodea = rs.getInt("id");
                String izena = rs.getString("izena");

                System.out.println(kodea + ":" + izena);
                emaitza.add(izena);

            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return emaitza;
    }
    public void ezabatuZerbitzua(String izena){
        String query = "delete from services where izena like '"+izena+"';";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        dbKudeatzaile.execSQL(query);

    }

    public void sartuZerbitzua(String izena) throws SQLException {
        String query = "insert into services values('" + this.idLortu(izena) + "','" + izena + "')";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        dbKudeatzaile.execSQL(query);
    }

    private int idLortu(String izena) throws SQLException {
        int id = 1;
        String query;
        DBKudeatzaile dbKudeatzaile;
        ResultSet rs;
        boolean kokatuta = false;
        while (!kokatuta) {
            query = "select izena from services where id="+id+";";
            dbKudeatzaile = DBKudeatzaile.getInstantzia();
            rs = dbKudeatzaile.execSQL(query);
            if(!rs.next()){
                kokatuta=true;
            }
            else{id++;}
        }
        return id;
    }
}
