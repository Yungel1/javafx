package ehu.isad.dbcontroller;

import ehu.isad.Book;
import ehu.isad.Herrialdea;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HerrialdeDBKud {

    private static final HerrialdeDBKud instance = new HerrialdeDBKud();

    public static HerrialdeDBKud getInstance() {
        return instance;
    }

    private HerrialdeDBKud() {
    }

    public List<Herrialdea> herrialdeakLortu() {

        String query = "select izena,bandera,tv from Herrialde";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        List<Herrialdea> emaitza = new ArrayList<>();
        try {
            while (rs.next()) {
                String izena=rs.getString("izena");
                String bandera = rs.getString("bandera");
                String tv = rs.getString("tv");
                Herrialdea herrialdea=new Herrialdea();
                herrialdea.setIzena(izena);
                herrialdea.setBandera(bandera);
                herrialdea.setTv(tv);
                emaitza.add(herrialdea);
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return emaitza;
    }

}
