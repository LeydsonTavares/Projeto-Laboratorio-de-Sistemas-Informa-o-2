// Generated code from Butter Knife. Do not modify!
package com.example.leydsontavares.beerregisterapplication.adpater;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class BeerAdpater$ViewHolder$$ViewBinder<T extends com.example.leydsontavares.beerregisterapplication.adpater.BeerAdpater.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558556, "field 'mTvNomeBeer'");
    target.mTvNomeBeer = finder.castView(view, 2131558556, "field 'mTvNomeBeer'");
    view = finder.findRequiredView(source, 2131558555, "field 'mImagemBeer'");
    target.mImagemBeer = finder.castView(view, 2131558555, "field 'mImagemBeer'");
    view = finder.findRequiredView(source, 2131558557, "field 'mQualidadeBeer'");
    target.mQualidadeBeer = finder.castView(view, 2131558557, "field 'mQualidadeBeer'");
  }

  @Override public void unbind(T target) {
    target.mTvNomeBeer = null;
    target.mImagemBeer = null;
    target.mQualidadeBeer = null;
  }
}
