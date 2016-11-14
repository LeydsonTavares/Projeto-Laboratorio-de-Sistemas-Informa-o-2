package com.example.leydsontavares.beerregisterapplication.view;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import com.example.leydsontavares.beerregisterapplication.R;
import com.example.leydsontavares.beerregisterapplication.model.Beer;


import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SugestaoActivity extends AppCompatActivity {

    @Bind(R.id.gridView_ranking)
    GridView mGridView;

    private GridViewBeerAdapter mAdapter;
    List<Beer> listaSugestao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugestao);
        ButterKnife.bind(this);

        /**
         * 


        listaSugestao = new LinkedList<Beer>();
        Beer b1 = new Beer();
        b1.setmDrawlable(R.drawable.skol_secret);

        Beer b2 = new Beer();
        b1.setmDrawlable(R.drawable.skol_spirit);

        Beer b3 = new Beer();
        b1.setmDrawlable(R.drawable.itaipava);

        Beer b4 = new Beer();
        b1.setmDrawlable(R.drawable.proibida);

        listaSugestao.add(b1);
        listaSugestao.add(b2);
        listaSugestao.add(b3);
        listaSugestao.add(b4);

        mAdapter = new GridViewBeerAdapter(listaSugestao, this);
        mGridView.setAdapter(mAdapter);
         */
    }


}
