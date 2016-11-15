package com.example.leydsontavares.beerregisterapplication.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.leydsontavares.beerregisterapplication.R;
import com.example.leydsontavares.beerregisterapplication.business.GerenciadorBeer;
import com.example.leydsontavares.beerregisterapplication.dao.BeerDAO;
import com.example.leydsontavares.beerregisterapplication.model.Beer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RankingActivity extends AppCompatActivity {

    @Bind(R.id.list_view_ranking)
    ListView mListViewBeer;

    GerenciadorBeer gerenciador;
    private ListViewRankingAdapter mAdapterRanking;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        setTitle("Ranking");
        ButterKnife.bind(this);
        gerenciador = GerenciadorBeer.getInstance(this);
        mAdapterRanking = new ListViewRankingAdapter(gerenciador.buscarTodasBeer(), this);
        mListViewBeer.setAdapter(mAdapterRanking);

    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sair?");
        builder.setMessage("Deseja realmente sair?");
        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }
        });
        builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        AlertDialog alerta = builder.create();
        alerta.show();
    }

}
