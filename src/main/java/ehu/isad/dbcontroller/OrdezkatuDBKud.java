package ehu.isad.dbcontroller;

import ehu.isad.Herrialdea;
import ehu.isad.Partaidea;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdezkatuDBKud {

    private static final OrdezkatuDBKud instance = new OrdezkatuDBKud();

    public static OrdezkatuDBKud getInstance() {
        return instance;
    }

    private OrdezkatuDBKud() {
    }

    public List<Partaidea> partaideInfoLortu(){
        String query = "select h.bandera,o.artista,o.abestia,o.herrialdea " +
                "from Herrialde h, Ordezkaritza o,ParteHartzea ph where ph.izena=h.izena and " +
                "h.izena=o.herrialdea and o.urtea=strftime('%Y','now') ORDER BY o.herrialdea ASC";

        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        List<Partaidea> emaitza = new ArrayList<>();
        try {
            while (rs.next()) {
                Partaidea partaidea=new Partaidea(rs.getString("herrialdea"),
                        rs.getString("artista"),rs.getString("abestia"),
                        rs.getString("bandera"));
                emaitza.add(partaidea);
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return emaitza;
    }

    public List<Partaidea> top3Lortu(){
        String query = "select h.bandera,o.puntuak,o.herrialdea " +
                "from Herrialde h, Ordezkaritza o,ParteHartzea ph where ph.izena=h.izena and " +
                "h.izena=o.herrialdea and o.urtea=strftime('%Y','now') ORDER BY o.puntuak DESC LIMIT 3";

        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        List<Partaidea> emaitza = new ArrayList<>();
        try {
            while (rs.next()) {
                Partaidea partaidea=new Partaidea(rs.getString("herrialdea"),
                        rs.getString("bandera"),rs.getInt("puntuak"));
                emaitza.add(partaidea);
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return emaitza;
    }

    public void puntuakEguneratu(int puntuak,String herrialdea){
        String query = "update ordezkaritza set puntuak=puntuak+"+puntuak+" where " +
                "herrialdea='"+herrialdea+"'";

        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        dbKudeatzaile.execSQL(query);
    }

}
