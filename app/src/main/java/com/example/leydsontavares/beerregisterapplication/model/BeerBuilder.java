package com.example.leydsontavares.beerregisterapplication.model;

/**
 * Created by LeydsonTavares on 26/11/2016.
 */

// Interface Builder que define todos os passos necessários para construir uma Beer

public class BeerBuilder {


    protected Beer beer;

    public BeerBuilder(){
        beer = new Beer();
    }

    public void buildId(int id){
        beer.mId = id;
    }

    public void buildNome(String nome){
        beer.mNome = nome;
    }

    public void buildDescricao(String descricao){
        beer.mDescricao = descricao;
    }

    public void buildImagem(byte[] bytes){
        beer.mImagem = bytes;
    }
    public void buildQualidade(Float nota){
        beer.mQualidade = nota;
    }
    public void buildTeorAlcolico(Double teor){
        beer.mTeorAlcolico = teor;
    }
    public void buildNacionalidade(String nacionalidade){
        beer.mNacionalidade = nacionalidade;
    }

    public Beer build(){
        return beer;
    }












}
