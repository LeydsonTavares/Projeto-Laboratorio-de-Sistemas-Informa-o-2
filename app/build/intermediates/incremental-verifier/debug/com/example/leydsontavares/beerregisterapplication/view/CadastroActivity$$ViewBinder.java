// Generated code from Butter Knife. Do not modify!
package com.example.leydsontavares.beerregisterapplication.view;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class CadastroActivity$$ViewBinder<T extends com.example.leydsontavares.beerregisterapplication.view.CadastroActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558519, "field 'mNomeBeer'");
    target.mNomeBeer = finder.castView(view, 2131558519, "field 'mNomeBeer'");
    view = finder.findRequiredView(source, 2131558520, "field 'mDescricaoBeer'");
    target.mDescricaoBeer = finder.castView(view, 2131558520, "field 'mDescricaoBeer'");
    view = finder.findRequiredView(source, 2131558521, "field 'mteorBeer'");
    target.mteorBeer = finder.castView(view, 2131558521, "field 'mteorBeer'");
    view = finder.findRequiredView(source, 2131558522, "field 'mNacionalidadeBeer'");
    target.mNacionalidadeBeer = finder.castView(view, 2131558522, "field 'mNacionalidadeBeer'");
    view = finder.findRequiredView(source, 2131558518, "field 'mCamera' and method 'selectImage'");
    target.mCamera = finder.castView(view, 2131558518, "field 'mCamera'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.selectImage(p0);
        }
      });
    view = finder.findRequiredView(source, 2131558517, "field 'mImagemBeer'");
    target.mImagemBeer = finder.castView(view, 2131558517, "field 'mImagemBeer'");
    view = finder.findRequiredView(source, 2131558523, "field 'mRtgbarQualidade'");
    target.mRtgbarQualidade = finder.castView(view, 2131558523, "field 'mRtgbarQualidade'");
    view = finder.findRequiredView(source, 2131558524, "field 'mBtnFacebook' and method 'chamaTelaFacebook'");
    target.mBtnFacebook = finder.castView(view, 2131558524, "field 'mBtnFacebook'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.chamaTelaFacebook();
        }
      });
    view = finder.findRequiredView(source, 2131558525, "field 'mFab' and method 'editarBeer'");
    target.mFab = finder.castView(view, 2131558525, "field 'mFab'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.editarBeer();
        }
      });
  }

  @Override public void unbind(T target) {
    target.mNomeBeer = null;
    target.mDescricaoBeer = null;
    target.mteorBeer = null;
    target.mNacionalidadeBeer = null;
    target.mCamera = null;
    target.mImagemBeer = null;
    target.mRtgbarQualidade = null;
    target.mBtnFacebook = null;
    target.mFab = null;
  }
}
