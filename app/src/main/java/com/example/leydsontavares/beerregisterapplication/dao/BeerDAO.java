package com.example.leydsontavares.beerregisterapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.leydsontavares.beerregisterapplication.model.Beer;
import com.example.leydsontavares.beerregisterapplication.model.BeerBuilder;

import java.util.ArrayList;
import java.util.List;

public class BeerDAO {
    private Context mContext;

    public BeerDAO(Context mContext) {
        this.mContext = mContext;
    }

    public void salvarBeers(Beer beer) {
        ContentValues values = new ContentValues();

        values.put(BeerBD.COLUNAS_TBL_BEER[1], beer.getmNome());
        values.put(BeerBD.COLUNAS_TBL_BEER[2], beer.getmDescricao());
        values.put(BeerBD.COLUNAS_TBL_BEER[3], beer.getmImagem());
        values.put(BeerBD.COLUNAS_TBL_BEER[4], beer.getmQualidade());
        values.put(BeerBD.COLUNAS_TBL_BEER[5], beer.getmTeorAlcolico());
        values.put(BeerBD.COLUNAS_TBL_BEER[6], beer.getmNacionalidade());



        BeerBD.getInstance(mContext).getWritableDatabase().insert(BeerBD.NOME_TBL_BEER, null, values);


    }


    public void removerBeers(Beer beer) {

        int gerenteId = beer.getmId();

        BeerBD.getInstance(mContext).getWritableDatabase().delete(BeerBD.NOME_TBL_BEER,
                BeerBD.COLUNAS_TBL_BEER[0] + "=" + gerenteId, null);


    }

    public void atualizarBeer(Beer beer) {

        ContentValues values = new ContentValues();

        values.put(BeerBD.COLUNAS_TBL_BEER[1], beer.getmNome());
        values.put(BeerBD.COLUNAS_TBL_BEER[2], beer.getmDescricao());
        values.put(BeerBD.COLUNAS_TBL_BEER[3], beer.getmImagem());
        values.put(BeerBD.COLUNAS_TBL_BEER[4], beer.getmQualidade());
        values.put(BeerBD.COLUNAS_TBL_BEER[5], beer.getmTeorAlcolico());
        values.put(BeerBD.COLUNAS_TBL_BEER[6], beer.getmNacionalidade());




        BeerBD.getInstance(mContext).getWritableDatabase().update(BeerBD.NOME_TBL_BEER, values,
                BeerBD.COLUNAS_TBL_BEER[0] + "=" + beer.getmId(), null);


    }

    public Beer buscarBeers(int id) {

        Cursor cursor = BeerBD.getInstance(mContext).getReadableDatabase().query(BeerBD.NOME_TBL_BEER, BeerBD.COLUNAS_TBL_BEER,
                BeerBD.COLUNAS_TBL_BEER[0] + "=" + id, null, null, null, null);
        List<Beer> beerArrayList = new ArrayList<>();

        while (cursor.moveToNext()) {
            beerArrayList.add(cursorBeer(cursor));

        }
        return beerArrayList.get(0);


    }

    public Beer cursorBeer(Cursor cursor) {
        BeerBuilder beer = new BeerBuilder();

        beer.buildId(cursor.getInt(0));
        beer.buildNome(cursor.getString(1));
        beer.buildDescricao(cursor.getString(2));
        beer.buildImagem(cursor.getBlob(3));
        beer.buildQualidade(cursor.getFloat(4));
        beer.buildTeorAlcolico(cursor.getDouble(5));
        beer.buildNacionalidade(cursor.getString(6));

        return beer.build();

    }

    public List<Beer> BuscarTodos() {
        Cursor cursor = BeerBD.getInstance(mContext).getReadableDatabase().query(BeerBD.NOME_TBL_BEER,
                BeerBD.COLUNAS_TBL_BEER,
                null, null, null, null, null);
        List<Beer> beers = new ArrayList<>();

        cursor.moveToFirst();
        while (cursor.moveToNext()) {
            beers.add(cursorBeer(cursor));

        }
        return beers;


    }


}












































