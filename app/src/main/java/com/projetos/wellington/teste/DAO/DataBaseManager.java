package com.projetos.wellington.teste.DAO;

import android.content.Context;

/**
 * Created by wellington on 02/11/17.
 */

public class DataBaseManager {
    private static DataBaseManager instance;
    private DataBaseHelper helper;

    public static void init(Context ctx) {
        if (null == instance)
            instance = new DataBaseManager(ctx);
    }

    public static DataBaseManager getInstance() {
        return instance;
    }

    private DataBaseManager(Context ctx){
        helper = new DataBaseHelper(ctx);
    }
    private DataBaseHelper getHelper(){
        return helper;
    }
}
