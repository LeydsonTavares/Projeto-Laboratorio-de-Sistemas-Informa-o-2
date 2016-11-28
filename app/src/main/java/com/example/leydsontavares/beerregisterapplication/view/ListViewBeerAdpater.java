package com.example.leydsontavares.beerregisterapplication.view;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leydsontavares.beerregisterapplication.R;
import com.example.leydsontavares.beerregisterapplication.model.Beer;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListViewBeerAdpater extends BaseAdapter {

    Context mContext;
    List<Beer> mListaBeer;
    LayoutInflater mInflater;

    /**
     * Construtor responsável por receber as informações que serão utilizadas pelo adapter.
     *
     * @param context
     * @param listaBeer
     */

    public ListViewBeerAdpater(List<Beer> listaBeer, Context context) {
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
        Bitmap raw;
        byte[] fotoArray;


        if (convertView == null) {
            view = mInflater.inflate(R.layout.item_list_beers, parent, false);
            holder = new ViewHolder(view);
            Beer beer = mListaBeer.get(position);



            holder.mTvNomeBeer.setText(beer.getmNome());
            holder.mQualidadeBeer.setText("" + beer.getmQualidade());
            fotoArray = beer.getmImagem();


            if (fotoArray != null) {
                raw = BitmapFactory.decodeByteArray(fotoArray, 0, fotoArray.length);
                holder.mImagemBeer.setImageBitmap(tratandoImagem(raw));

            }


        } else {
            view = convertView;
        }

        return view;
    }

    class ViewHolder {

        @Bind(R.id.tv_nomeBeer)
        TextView mTvNomeBeer;

        @Bind(R.id.tv_imagemBeer)
        ImageView mImagemBeer;

        @Bind(R.id.tv_qualidadeBeer)
        TextView mQualidadeBeer;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }


    }
    private Bitmap tratandoImagem(Bitmap img){
        Bitmap newBitmap = Bitmap.createScaledBitmap(img,100,120,false);
        return newBitmap;

    }
}





