// Generated code from Butter Knife. Do not modify!
package com.example.leydsontavares.beerregisterapplication.view;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class RankingActivity$$ViewBinder<T extends com.example.leydsontavares.beerregisterapplication.view.RankingActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558532, "field 'mListViewBeer'");
    target.mListViewBeer = finder.castView(view, 2131558532, "field 'mListViewBeer'");
  }

  @Override public void unbind(T target) {
    target.mListViewBeer = null;
  }
}
