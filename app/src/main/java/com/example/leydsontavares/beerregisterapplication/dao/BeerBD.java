package com.example.leydsontavares.beerregisterapplication.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BeerBD extends SQLiteOpenHelper {

    public static BeerBD instance = null;

    public final static String NOME_BD = "rgisterBeer_.db";
    public final static int VERSION = 1;
    public final static String NOME_TBL_BEER = "beerTabela";
    public final static String[] COLUNAS_TBL_BEER = {"id", "nome", "descricao", "imagem", "qualidade",
            "teorAlcolico", "nacionalidade"};


    public final static String CRIAR_TBL_BEER = "CREATE TABLE " + NOME_TBL_BEER + "(" +
            COLUNAS_TBL_BEER[0] + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUNAS_TBL_BEER[1] + " TEXT, " +
            COLUNAS_TBL_BEER[2] + " TEXT, " +
            COLUNAS_TBL_BEER[3] + " BLOB, " +
            COLUNAS_TBL_BEER[4] + " REAL, " +
            COLUNAS_TBL_BEER[5] + " TEXT, " +
            COLUNAS_TBL_BEER[6] + " TEXT);";




    private BeerBD(Context context) {
        super(context, NOME_BD, null, VERSION);
    }

    public static BeerBD getInstance(Context context) {
        if (instance == null) {
            instance = new BeerBD(context);
        }
        return instance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CRIAR_TBL_BEER);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
