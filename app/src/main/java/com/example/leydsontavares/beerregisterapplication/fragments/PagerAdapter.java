package com.example.leydsontavares.beerregisterapplication.fragments;


        import android.content.Context;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentStatePagerAdapter;
        import com.example.leydsontavares.beerregisterapplication.R;
        import com.example.leydsontavares.beerregisterapplication.model.BeerSugestao;
        import java.util.ArrayList;
        import java.util.List;


public class PagerAdapter extends FragmentStatePagerAdapter {



    String mAlemanha;
    String mArgetina;
    String mBelgica;
    String mBrasil;
    String mEUA;
    String mInglaterra;
    String mMexico;
    String mUruguai;



    List<BeerSugestao> mBeers;

    public PagerAdapter(FragmentManager fm, List<BeerSugestao> beerSugestaoList, Context context) {
        super(fm);
        this.mBeers = beerSugestaoList;

        //Nomeando as viewpager com as Strings criadas no res


        mAlemanha = context.getResources().getString(R.string.nacinalidade1);
        mArgetina = context.getResources().getString(R.string.nacinalidade2);
        mBelgica = context.getResources().getString(R.string.nacinalidade3);
        mBrasil = context.getResources().getString(R.string.nacinalidade4);
        mEUA = context.getResources().getString(R.string.nacinalidade5);
        mInglaterra = context.getResources().getString(R.string.nacinalidade6);
        mMexico = context.getResources().getString(R.string.nacinalidade7);
        mUruguai = context.getResources().getString(R.string.nacinalidade8);
    }

    protected PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        GridFragment statusDemandaFragment = new GridFragment();

        switch (position) {

            case 0:
                statusDemandaFragment.setmMovies(filtrarPorStatus(mBeers, mAlemanha));
                break;

            case 1:
                statusDemandaFragment.setmMovies(filtrarPorStatus(mBeers, mArgetina));
                break;
            case 2:
                statusDemandaFragment.setmMovies(filtrarPorStatus(mBeers, mBelgica));
                break;
            case 3:
                statusDemandaFragment.setmMovies(filtrarPorStatus(mBeers, mBrasil));
                break;
            case 4:
                statusDemandaFragment.setmMovies(filtrarPorStatus(mBeers, mEUA));
                break;
            case 5:
                statusDemandaFragment.setmMovies(filtrarPorStatus(mBeers, mInglaterra));
                break;
            case 6:
                statusDemandaFragment.setmMovies(filtrarPorStatus(mBeers, mMexico));
                break;
            case 7:
                statusDemandaFragment.setmMovies(filtrarPorStatus(mBeers, mUruguai));
                break;

            default:
                break;
        }

        return statusDemandaFragment;

    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return mAlemanha;
            case 1:
                return mArgetina;
            case 2:
                return mBelgica;
            case 3:
                return mBrasil;
            case 4:
                return mEUA;
            case 5:
                return mInglaterra;
            case 6:
                return mMexico;
            case 7:
                return mUruguai;
            default:
                return "";
        }


    }

    @Override
    public int getCount() {
        return 8;
    }

    private List<BeerSugestao> filtrarPorStatus(List<BeerSugestao> beerList, String statusBeer) {

        List<BeerSugestao> beerFiltradas = new ArrayList<>();

        for (BeerSugestao beer : beerList) {

            if (statusBeer.equals(beer.getNacionalidade())) {
                beerFiltradas.add(beer);
            }

        }

        return beerFiltradas;

    }

}



