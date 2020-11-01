package ehu.isad.dbcontroller;

public class OrdezkatuDBKud {

    private static final OrdezkatuDBKud instance = new OrdezkatuDBKud();

    public static OrdezkatuDBKud getInstance() {
        return instance;
    }

    private OrdezkatuDBKud() {
    }

}
