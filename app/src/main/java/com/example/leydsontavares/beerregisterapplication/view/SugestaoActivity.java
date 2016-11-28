package com.example.leydsontavares.beerregisterapplication.view;


import android.content.Intent;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.leydsontavares.beerregisterapplication.R;
import com.example.leydsontavares.beerregisterapplication.fragments.PagerAdapter;
import com.example.leydsontavares.beerregisterapplication.model.BeerSugestao;
import java.util.LinkedList;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;

public class SugestaoActivity extends AppCompatActivity {


    @Bind(R.id.vp_beers)
    ViewPager mVpMovies;

    @Bind(R.id.pager_tab_strip)
    PagerTabStrip mPagerTabStrip;



    private PagerAdapter mPagerAdapter;
    private List<BeerSugestao> mSugestaoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);
        ButterKnife.bind(this);
        mSugestaoList = new LinkedList<>();
        populaSugestao();
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), mSugestaoList, getBaseContext());
        mVpMovies.setAdapter(mPagerAdapter);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                startActivity(new Intent(SugestaoActivity.this, ListarBeerActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(SugestaoActivity.this, ListarBeerActivity.class));
    }

    public void populaSugestao() {

        //Brasil
        BeerSugestao b1 = new BeerSugestao();
        b1.setNome("Proibida");
        b1.setNacionalidade("Brasil");
        b1.setDrawlable(R.drawable.proibida);

        BeerSugestao b2 = new BeerSugestao();
        b2.setNome("Skol secret");
        b2.setNacionalidade("Brasil");
        b2.setDrawlable(R.drawable.skol_secret);

        BeerSugestao b3 = new BeerSugestao();
        b3.setNome("Itaipava");
        b3.setNacionalidade("Brasil");
        b3.setDrawlable(R.drawable.itaipava);

        BeerSugestao b4 = new BeerSugestao();
        b4.setNome("Skol spirit");
        b4.setNacionalidade("Brasil");
        b4.setDrawlable(R.drawable.skol_spirit);

        //Inglaterra

        BeerSugestao b6 = new BeerSugestao();
        b6.setNome("Boddingtons");
        b6.setNacionalidade("Inglaterra");
        b6.setDrawlable(R.drawable.boddingtons_inglaterra);

        BeerSugestao b7 = new BeerSugestao();
        b7.setNome("Newcastle");
        b7.setNacionalidade("Inglaterra");
        b7.setDrawlable(R.drawable.newcastle_inglaterra);

        BeerSugestao b8 = new BeerSugestao();
        b8.setNome("Fullers London");
        b8.setNacionalidade("Inglaterra");
        b8.setDrawlable(R.drawable.fullers_london_inglaterra);

        BeerSugestao b9 = new BeerSugestao();
        b9.setNome("Spitfire");
        b9.setNacionalidade("Inglaterra");
        b9.setDrawlable(R.drawable.spitfire_inglaterra);

        // Argetina

        BeerSugestao b10 = new BeerSugestao();
        b10.setNome("Quilmes");
        b10.setNacionalidade("Argetina");
        b10.setDrawlable(R.drawable.quilmes_ar);

        BeerSugestao b11 = new BeerSugestao();
        b11.setNome("Patagonia");
        b11.setNacionalidade("Argetina");
        b11.setDrawlable(R.drawable.patagonia_ar);

        //Alemã

        BeerSugestao b12 = new BeerSugestao();
        b12.setNome("Eisenbanhn");
        b12.setNacionalidade("Alemanha");
        b12.setDrawlable(R.drawable.eisenbanhn_al);


        BeerSugestao b13 = new BeerSugestao();
        b13.setNome("Erdinger");
        b13.setNacionalidade("Alemanha");
        b13.setDrawlable(R.drawable.erdinger_al);

        BeerSugestao b14 = new BeerSugestao();
        b14.setNome("Franziskaner");
        b14.setNacionalidade("Alemanha");
        b14.setDrawlable(R.drawable.franziskaner_al);

        BeerSugestao b16 = new BeerSugestao();
        b16.setNome("spaten");
        b16.setNacionalidade("Alemanha");
        b16.setDrawlable(R.drawable.spaten_al);

        //Belgica

        BeerSugestao b17 = new BeerSugestao();
        b17.setNome("Deus");
        b17.setNacionalidade("Bélgica");
        b17.setDrawlable(R.drawable.deus_bel);

        BeerSugestao b18 = new BeerSugestao();
        b18.setNome("Leffe Royale");
        b18.setNacionalidade("Bélgica");
        b18.setDrawlable(R.drawable.leffe_royale_bel);

        BeerSugestao b19 = new BeerSugestao();
        b19.setNome("Stella Artois");
        b19.setNacionalidade("Bélgica");
        b19.setDrawlable(R.drawable.stella_bel);

        // Uruguai

        BeerSugestao b20 = new BeerSugestao();
        b20.setNome("Norteña");
        b20.setNacionalidade("Uruguai");
        b20.setDrawlable(R.drawable.nortena_uruguai);

        // México

        BeerSugestao b21 = new BeerSugestao();
        b21.setNome("Corona");
        b21.setNacionalidade("México");
        b21.setDrawlable(R.drawable.corona_mexico);

        BeerSugestao b22 = new BeerSugestao();
        b22.setNome("Negra Modelo");
        b22.setNacionalidade("México");
        b22.setDrawlable(R.drawable.negra_modelo_mexico);

        // Estados Unidos

        BeerSugestao b23 = new BeerSugestao();
        b23.setNome("Budwieser");
        b23.setNacionalidade("Estados Unidos");
        b23.setDrawlable(R.drawable.budwieser_eua);

        BeerSugestao b24 = new BeerSugestao();
        b24.setNome("Kona");
        b24.setNacionalidade("Estados Unidos");
        b24.setDrawlable(R.drawable.kona_eua);

        mSugestaoList.add(b1);
        mSugestaoList.add(b2);
        mSugestaoList.add(b3);
        mSugestaoList.add(b4);
        mSugestaoList.add(b6);
        mSugestaoList.add(b7);
        mSugestaoList.add(b8);
        mSugestaoList.add(b9);
        mSugestaoList.add(b10);
        mSugestaoList.add(b11);
        mSugestaoList.add(b12);
        mSugestaoList.add(b13);
        mSugestaoList.add(b14);
        mSugestaoList.add(b16);
        mSugestaoList.add(b17);
        mSugestaoList.add(b18);
        mSugestaoList.add(b19);
        mSugestaoList.add(b20);
        mSugestaoList.add(b21);
        mSugestaoList.add(b22);
        mSugestaoList.add(b23);
        mSugestaoList.add(b24);
    }



}
