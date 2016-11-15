// Generated code from Butter Knife. Do not modify!
package com.example.leydsontavares.beerregisterapplication.view;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ListViewBeerAdpater$ViewHolder$$ViewBinder<T extends com.example.leydsontavares.beerregisterapplication.view.ListViewBeerAdpater.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558558, "field 'mTvNomeBeer'");
    target.mTvNomeBeer = finder.castView(view, 2131558558, "field 'mTvNomeBeer'");
    view = finder.findRequiredView(source, 2131558557, "field 'mImagemBeer'");
    target.mImagemBeer = finder.castView(view, 2131558557, "field 'mImagemBeer'");
    view = finder.findRequiredView(source, 2131558559, "field 'mQualidadeBeer'");
    target.mQualidadeBeer = finder.castView(view, 2131558559, "field 'mQualidadeBeer'");
  }

  @Override public void unbind(T target) {
    target.mTvNomeBeer = null;
    target.mImagemBeer = null;
    target.mQualidadeBeer = null;
  }
}
