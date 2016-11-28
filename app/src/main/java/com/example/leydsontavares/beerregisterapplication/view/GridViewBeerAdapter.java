package com.example.leydsontavares.beerregisterapplication.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.leydsontavares.beerregisterapplication.R;
import com.example.leydsontavares.beerregisterapplication.model.Beer;
import com.example.leydsontavares.beerregisterapplication.model.BeerSugestao;

import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;


public class GridViewBeerAdapter extends BaseAdapter {

    List<BeerSugestao> beerList;

    Context mContext;
    LayoutInflater mInflater;

    public GridViewBeerAdapter(List<BeerSugestao> mbeer, Context mContext) {
        this.beerList = mbeer;
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return beerList.size();
    }

    @Override
    public Object getItem(int position) {
        return beerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        ViewHolder holder;
        if (convertView == null) {
            view = mInflater.inflate(R.layout.item_grid, parent, false);
            holder = new ViewHolder(view);
            BeerSugestao beer = beerList.get(position);


            holder.mPoster.setImageResource((beer.getDrawlable()));

        } else {
            view = convertView;
        }


        return view;
    }


    class ViewHolder {

        @Bind(R.id.img_cerveja)
        ImageView mPoster;


        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }


    }
}



