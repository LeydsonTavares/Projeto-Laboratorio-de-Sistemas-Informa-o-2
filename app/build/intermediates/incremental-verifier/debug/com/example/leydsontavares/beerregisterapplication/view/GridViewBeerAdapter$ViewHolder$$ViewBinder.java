// Generated code from Butter Knife. Do not modify!
package com.example.leydsontavares.beerregisterapplication.view;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class GridViewBeerAdapter$ViewHolder$$ViewBinder<T extends com.example.leydsontavares.beerregisterapplication.view.GridViewBeerAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558556, "field 'mPoster'");
    target.mPoster = finder.castView(view, 2131558556, "field 'mPoster'");
  }

  @Override public void unbind(T target) {
    target.mPoster = null;
  }
}
