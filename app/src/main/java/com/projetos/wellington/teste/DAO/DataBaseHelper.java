package com.projetos.wellington.teste.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.projetos.wellington.teste.ENTITY.LinguagemDeProgramacao;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * Created by wellington on 02/11/17.
 */

public class DataBaseHelper  extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "bd_projeto";

    private static final int DATABASE_VERSION = 1;

    public DataBaseHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion) {
        super(context, databaseName, factory, databaseVersion);
    }

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, LinguagemDeProgramacao.class);
           // TableUtils.createTable(connectionSource, Exemplo.class);

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int oldversion, int i1) {
    }

    @Override
    public void close() {
        super.close();
    }
}