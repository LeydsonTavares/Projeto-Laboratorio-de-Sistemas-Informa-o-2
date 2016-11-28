package com.example.leydsontavares.beerregisterapplication.fragments;

        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.GridView;
        import com.example.leydsontavares.beerregisterapplication.R;
        import com.example.leydsontavares.beerregisterapplication.model.BeerSugestao;
        import com.example.leydsontavares.beerregisterapplication.view.GridViewBeerAdapter;
        import java.util.ArrayList;
        import java.util.List;
        import butterknife.Bind;
        import butterknife.ButterKnife;

public class GridFragment extends Fragment {

    @Bind(R.id.gridView_sugestao)
    GridView mGvMovie;

    List<BeerSugestao> mBeers;
    GridViewBeerAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sugestao, null);
        ButterKnife.bind(this, view);

        mAdapter = new GridViewBeerAdapter(getmBeer(), getActivity().getBaseContext());
        mGvMovie.setAdapter(mAdapter);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public List<BeerSugestao> getmBeer() {
        if (mBeers == null) {
            mBeers = new ArrayList<>();
        }

        return mBeers;
    }

    public void setmMovies(List<BeerSugestao> mBeers) {
        this.mBeers = mBeers;
    }


}




