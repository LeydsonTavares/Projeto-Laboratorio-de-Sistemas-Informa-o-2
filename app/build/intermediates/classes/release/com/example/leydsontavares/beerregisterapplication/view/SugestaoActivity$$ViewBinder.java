// Generated code from Butter Knife. Do not modify!
package com.example.leydsontavares.beerregisterapplication.view;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class SugestaoActivity$$ViewBinder<T extends com.example.leydsontavares.beerregisterapplication.view.SugestaoActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558554, "field 'mVpMovies'");
    target.mVpMovies = finder.castView(view, 2131558554, "field 'mVpMovies'");
    view = finder.findRequiredView(source, 2131558555, "field 'mPagerTabStrip'");
    target.mPagerTabStrip = finder.castView(view, 2131558555, "field 'mPagerTabStrip'");
  }

  @Override public void unbind(T target) {
    target.mVpMovies = null;
    target.mPagerTabStrip = null;
  }
}
