// Generated code from Butter Knife. Do not modify!
package com.example.leydsontavares.beerregisterapplication.view;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ListarBeerActivity$$ViewBinder<T extends com.example.leydsontavares.beerregisterapplication.view.ListarBeerActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558526, "field 'mListViewBeer', method 'itemClicado', and method 'itemLongClicado'");
    target.mListViewBeer = finder.castView(view, 2131558526, "field 'mListViewBeer'");
    ((android.widget.AdapterView<?>) view).setOnItemClickListener(
      new android.widget.AdapterView.OnItemClickListener() {
        @Override public void onItemClick(
          android.widget.AdapterView<?> p0,
          android.view.View p1,
          int p2,
          long p3
        ) {
          target.itemClicado(p2);
        }
      });
    ((android.widget.AdapterView<?>) view).setOnItemLongClickListener(
      new android.widget.AdapterView.OnItemLongClickListener() {
        @Override public boolean onItemLongClick(
          android.widget.AdapterView<?> p0,
          android.view.View p1,
          int p2,
          long p3
        ) {
          return target.itemLongClicado(p2);
        }
      });
    view = finder.findRequiredView(source, 2131558527, "field 'mFab' and method 'addBeer'");
    target.mFab = finder.castView(view, 2131558527, "field 'mFab'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.addBeer();
        }
      });
  }

  @Override public void unbind(T target) {
    target.mListViewBeer = null;
    target.mFab = null;
  }
}
