package com.example.leydsontavares.beerregisterapplication;

import android.app.Activity;
import android.content.Context;

import com.example.leydsontavares.beerregisterapplication.business.GerenciadorBeer;
import com.example.leydsontavares.beerregisterapplication.model.Beer;
import com.example.leydsontavares.beerregisterapplication.model.BeerBuilder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegisterBeerUnitTest extends Activity {

    Beer beer;
    BeerBuilder  beerBuilder;

    @Before
    public void iniciarUnitTest(){
        beer = new Beer();
        beerBuilder = new BeerBuilder();
    }
    @Test
    public void testBuilderNome()  {
        beerBuilder.buildNome("Lesydson&Fernanda");
        assertEquals("Lesydson&Fernanda", beerBuilder.build().getmNome());

    }
    @Test
    public void testBuilderNacionalidade()  {
        beerBuilder.buildNacionalidade("Brasil");
        assertEquals("Brasil", beerBuilder.build().getmNacionalidade());
    }
    @Test
    public void testBuilderDescricao(){
        beerBuilder.buildDescricao("Bom");
        assertEquals("Bom", beerBuilder.build().getmDescricao());


    }
    @Test
    public void testBuilderTeor() {
        beerBuilder.buildTeorAlcolico(5.0);
        assertEquals(Double.valueOf(5.0), beerBuilder.build().getmTeorAlcolico());
    }

    @Test
    public void testBuilderQualidade() {
        beerBuilder.buildQualidade(5f);
        assertEquals(Float.valueOf(5), beerBuilder.build().getmQualidade());
    }

}