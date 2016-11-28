package com.example.leydsontavares.beerregisterapplication.business;

import android.content.Context;

import com.example.leydsontavares.beerregisterapplication.R;
import com.example.leydsontavares.beerregisterapplication.dao.BeerDAO;
import com.example.leydsontavares.beerregisterapplication.model.Beer;
import com.example.leydsontavares.beerregisterapplication.model.BeerSugestao;

import java.util.LinkedList;
import java.util.List;


public class GerenciadorBeer {


    public static GerenciadorBeer instance = new GerenciadorBeer();
    private static BeerDAO beerDAO ;


    public GerenciadorBeer(){
    }


    public static GerenciadorBeer getInstance(Context context) {
        beerDAO = new BeerDAO(context);
        return instance;
    }


    public void cadatrarBeer(Beer beer){
        this.beerDAO.salvarBeers(beer);

    }

    public void excluirBeer(Beer beer){
        this.beerDAO.removerBeers(beer);

    }
    public Beer buscarBeer(Beer beer) {
        return this.beerDAO.buscarBeers(beer.getmId());
    }


    public void atualizarBeer(Beer beer){
        this.beerDAO.atualizarBeer(beer);
    }

    public List<Beer> buscarTodasBeer(){
       return this.beerDAO.BuscarTodos();
    }


}
