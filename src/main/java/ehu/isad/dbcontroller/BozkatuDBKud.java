package ehu.isad.dbcontroller;

public class BozkatuDBKud {

    private static final BozkatuDBKud instance = new BozkatuDBKud();

    public static BozkatuDBKud getInstance() {
        return instance;
    }

    private BozkatuDBKud() {
    }

}
