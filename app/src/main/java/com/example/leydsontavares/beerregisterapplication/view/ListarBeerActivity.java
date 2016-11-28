package com.example.leydsontavares.beerregisterapplication.view;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;


import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leydsontavares.beerregisterapplication.R;
import com.example.leydsontavares.beerregisterapplication.business.GerenciadorBeer;
import com.example.leydsontavares.beerregisterapplication.dao.BeerDAO;
import com.example.leydsontavares.beerregisterapplication.model.Beer;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnItemLongClick;

public class ListarBeerActivity extends AppCompatActivity {


    @Bind(R.id.list_view_beer)
    ListView mListViewBeer;
    @Bind(R.id.fab_add_beer)
    FloatingActionButton mFab;

    GerenciadorBeer gerenciador;
    Beer beerUP;
    AlertDialog.Builder builder;
    private ListViewBeerAdpater mAdapter;
    List<Beer> filtro ;
    static String nomeBeer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_beer);
        setTitle("Register Beer");
        ButterKnife.bind(this);
        filtro = new LinkedList<>();
        gerenciador = GerenciadorBeer.getInstance(this);
        builder = new AlertDialog.Builder(this);
        mAdapter = new ListViewBeerAdpater(gerenciador.buscarTodasBeer(), this);
        mListViewBeer.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_listar, menu);
        SearchView sv = (SearchView) menu.findItem(R.id.search).getActionView();
        sv.setOnQueryTextListener(new SearchFiltro());
        return true;
    }

    private class SearchFiltro implements OnQueryTextListener {

        @Override
        public boolean onQueryTextSubmit(String query) {
            for (Beer beer : gerenciador.buscarTodasBeer()) {
                if (query.equalsIgnoreCase(beer.getmNome())) {
                    beerUP = beer;
                }
            }

            if (beerUP != null) {
                finish();
                Intent intent = new Intent(ListarBeerActivity.this, CadastroActivity.class);
                intent.putExtra("beer", beerUP);
                startActivity(intent);
                beerUP = null;
            } else {
                Toast.makeText(ListarBeerActivity.this, "Não encontrado", Toast.LENGTH_SHORT).show();
            }
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText){
            filtro.clear();
            if (newText.length() > 0) {
                nomeBeer = newText;
                for (Beer beer : gerenciador.buscarTodasBeer()) {
                    if (beer.getmNome().toLowerCase().startsWith(newText.toLowerCase())) {
                            filtro.add(beer);
                            mAdapter = new ListViewBeerAdpater(filtro ,ListarBeerActivity.this);
                            mListViewBeer.setAdapter(mAdapter);
                            mListViewBeer.deferNotifyDataSetChanged();

                    }
                }
            }else{
                filtro.clear();
                mAdapter = new ListViewBeerAdpater(gerenciador.buscarTodasBeer() ,ListarBeerActivity.this);
                mListViewBeer.setAdapter(mAdapter);
                mListViewBeer.deferNotifyDataSetChanged();
            }
                return false;

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){

            case (R.id.ranking):
                startActivity (new Intent(ListarBeerActivity.this, RankingActivity.class));

                break;
            case (R.id.sugestao):
                finish();
                startActivity(new Intent(ListarBeerActivity.this, SugestaoActivity.class));
                break;
        }
        return true;
    }

    @OnClick(R.id.fab_add_beer)
    public void addBeer() {
        finish();
        startActivity(new Intent(ListarBeerActivity.this, CadastroActivity.class));
    }

    @OnItemClick(R.id.list_view_beer)
    protected void itemClicado(final int position) {
        finish();
        Beer beer = (Beer)  mListViewBeer.getItemAtPosition(position);
        Intent intent = new Intent(ListarBeerActivity.this, CadastroActivity.class);
        intent.putExtra("beer", beer);
        startActivity(intent);
    }

    @OnItemLongClick(R.id.list_view_beer)
    protected boolean itemLongClicado(final int position) {

        builder.setMessage("Deseja Excluir");
        builder.setPositiveButton("sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {


                Beer beer = (Beer) mListViewBeer.getItemAtPosition(position);
                gerenciador.excluirBeer(beer);


                mAdapter = new ListViewBeerAdpater(gerenciador.buscarTodasBeer(),getBaseContext());
                mListViewBeer.setAdapter(mAdapter);


            }
        });
        builder.setNegativeButton("não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {


            }
        });

        builder.create();
        builder.show();
        return true;
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

