package com.example.leydsontavares.beerregisterapplication.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.leydsontavares.beerregisterapplication.R;
import com.example.leydsontavares.beerregisterapplication.model.Beer;

import java.util.Collections;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;


public class ListViewRankingAdapter extends BaseAdapter {


    Context mContext;
    List<Beer> mListaBeer;
    LayoutInflater mInflater;

    /**
     * Construtor responsável por receber as informações que serão utilizadas pelo adapter.
     *
     * @param context
     * @param listaBeer
     */

    public ListViewRankingAdapter(List<Beer> listaBeer, Context context) {
        this.mContext = context;
        this.mListaBeer = listaBeer;
        mInflater = LayoutInflater.from(mContext);

    }

    @Override
    public int getCount() {
        return mListaBeer.size();
    }

    @Override
    public Object getItem(int position) {
        return mListaBeer.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * O método getView é o responsável por todas as informações que serão apresentadas no ListView
     *
     * @param position
     * @param convertView
     * @param parent
     * @return view
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        ViewHolder holder;

        if (convertView == null) {
            view = mInflater.inflate(R.layout.item_list_ranking, parent, false);
            holder = new ViewHolder(view);
            Collections.sort(mListaBeer);
            Beer beer = mListaBeer.get(position);

            holder.mNome.setText(beer.getmNome());
            holder.mQualidade.setText(""+beer.getmQualidade());

        } else {
            view = convertView;
        }

        return view;
    }

    class ViewHolder {

        @Bind(R.id.nome_Beer_ranking)
        TextView mNome;

        @Bind(R.id.qualidade_Beer_ranking)
        TextView mQualidade;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }


    }

}






