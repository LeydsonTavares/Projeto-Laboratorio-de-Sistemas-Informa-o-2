// Generated code from Butter Knife. Do not modify!
package com.example.leydsontavares.beerregisterapplication.view;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ListViewRankingAdapter$ViewHolder$$ViewBinder<T extends com.example.leydsontavares.beerregisterapplication.view.ListViewRankingAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558560, "field 'mNome'");
    target.mNome = finder.castView(view, 2131558560, "field 'mNome'");
    view = finder.findRequiredView(source, 2131558561, "field 'mQualidade'");
    target.mQualidade = finder.castView(view, 2131558561, "field 'mQualidade'");
  }

  @Override public void unbind(T target) {
    target.mNome = null;
    target.mQualidade = null;
  }
}
