package ehu.isad.dbcontroller;

import ehu.isad.Herrialdea;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BozkatuDBKud {

    private static final BozkatuDBKud instance = new BozkatuDBKud();

    public static BozkatuDBKud getInstance() {
        return instance;
    }

    private BozkatuDBKud() {
    }

    public boolean bozkatuDu(Herrialdea herr) throws SQLException {
        String query = "select bozkatuDu from Bozkaketa where bozkatuDu='"+herr.getIzena()+
                "' and urtea=strftime('%Y','now')";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        return rs.next();
    }

}
