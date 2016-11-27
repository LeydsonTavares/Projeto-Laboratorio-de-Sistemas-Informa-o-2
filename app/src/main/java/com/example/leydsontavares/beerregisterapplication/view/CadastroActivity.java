package com.example.leydsontavares.beerregisterapplication.view;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.provider.MediaStore;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.leydsontavares.beerregisterapplication.R;
import com.example.leydsontavares.beerregisterapplication.business.GerenciadorBeer;
import com.example.leydsontavares.beerregisterapplication.model.Beer;
import com.example.leydsontavares.beerregisterapplication.model.BeerBuilder;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CadastroActivity extends AppCompatActivity {

    Beer beerUP;
    byte[] mBytes;
    GerenciadorBeer gerenciador;
    Float qualidade;
    Bitmap image;
    Bundle extras;


    @Bind(R.id.edt_nomeBeer)
    EditText mNomeBeer;
    @Bind(R.id.edt_descricaoBeer)
    EditText mDescricaoBeer;
    @Bind(R.id.edt_teor)
    EditText mteorBeer;
    @Bind(R.id.sp_nacionalidade)
    Spinner mNacionalidadeBeer;
    @Bind(R.id.img_btn_camera)
    ImageView mCamera;
    @Bind(R.id.img_camera)
    ImageView mImagemBeer;
    @Bind(R.id.ratingBar)
    RatingBar mRtgbarQualidade;
    @Bind(R.id.txt_avaliacao)
    TextView mTxtAvaliacao;
    @Bind(R.id.btn_facebook)
    Button mBtnFacebook;
    @Bind(R.id.fab_editar_beer)
    FloatingActionButton mFab;
    AlertDialog.Builder builder;


    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        setTitle("Cadastre sua Breja");
        ButterKnife.bind(this);
        mFab.setVisibility(View.GONE);
        builder = new AlertDialog.Builder(this);
        gerenciador = GerenciadorBeer.getInstance(this);
        mRtgbarQualidade.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            // Called when the user swipes the RatingBar
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {


                    qualidade =  rating;
                    mTxtAvaliacao.setText("" + rating);



            }


        });

        extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("beer")) {
            beerUP = (Beer) extras.getParcelable("beer");
            builder.setCancelable(true);
            if (verificaImagemNull(beerUP)) {
                preencherDescricaoSemImagem(beerUP);
            } else {
                preencherDescricaoComImagem(beerUP);
            }
            enabledFalse();
            mFab.setVisibility(View.VISIBLE);
            mFab.setImageResource(R.drawable.ic_editar);


        }


    }

    private boolean verificaImagemNull(Beer b){
        if(b.getmImagem()== null){
            return true;
        }else{
            return false;
        }

    }

    private void enabledFalse(){
        mDescricaoBeer.setEnabled(false);
        mNomeBeer.setEnabled(false);
        mteorBeer.setEnabled(false);
        mRtgbarQualidade.setEnabled(false);
        mNacionalidadeBeer.setEnabled(false);

    }

    private void enabledTrue(){
        mDescricaoBeer.setEnabled(true);
        mNomeBeer.setEnabled(true);
        mteorBeer.setEnabled(true);
        mRtgbarQualidade.setEnabled(true);
        mNacionalidadeBeer.setEnabled(true);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_cadastro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){

            case (R.id.action_salvar):

                String nome = mNomeBeer.getText().toString();
                String teor = mteorBeer.getText().toString();

                if (nome.equals("") || nome.equals(" ")) {
                    Toast.makeText(CadastroActivity.this, "Preencha o Campo Nome", Toast.LENGTH_SHORT).show();
                } else if (teor.equals("") || teor.equals(" ")) {
                    Toast.makeText(CadastroActivity.this, "Preencha o Teor Alocolico", Toast.LENGTH_SHORT).show();
                } else {

                    BeerBuilder beer = new BeerBuilder();

                    beer.buildNome(mNomeBeer.getText().toString());
                    beer.buildDescricao(mDescricaoBeer.getText() == null ? "" : mDescricaoBeer.getText().toString());
                    beer.buildImagem(mBytes);
                    beer.buildQualidade(qualidade);
                    beer.buildTeorAlcolico(Double.parseDouble(mteorBeer.getText().toString()));
                    beer.buildNacionalidade(mNacionalidadeBeer.getSelectedItem().toString());

                    decidirAcaoBotaoSalvar(beer);
                }


            case (R.id.action_limpar):

                mNomeBeer.setText("");
                mDescricaoBeer.setText("");
                mteorBeer.setText("");
                mRtgbarQualidade.setRating(0);
                break;
            case android.R.id.home:
                finish();
                startActivity(new Intent(CadastroActivity.this, ListarBeerActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /** Metodo para saber qual ação será efetuada cadastrar ou editar
     *  Atraves da Ação carrega uma nova imagem ou permanece a tirada anteriormente
     */

    private void decidirAcaoBotaoSalvar(BeerBuilder beer){
        if(extras != null){
            if(mBytes == null){
                mBytes = beerUP.getmImagem();
                beer.buildImagem(mBytes);
            }
            beer.buildId(beerUP.getmId());
            gerenciador.atualizarBeer(beer.build());
            Toast.makeText(CadastroActivity.this, "Alterado com sucesso ", Toast.LENGTH_SHORT).show();
            finish();
            startActivity(new Intent(CadastroActivity.this, ListarBeerActivity.class));
        }
        else{
            gerenciador.cadatrarBeer(beer.build());
            Toast.makeText(CadastroActivity.this, "Salvo com sucesso", Toast.LENGTH_SHORT).show();

            builder.setMessage("Aceita Sugestão ?");
            builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    finish();
                    startActivity(new Intent(CadastroActivity.this, SugestaoActivity.class));
                }
            });
            builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    finish();
                    startActivity(new Intent(CadastroActivity.this, ListarBeerActivity.class));


                }
            });
            builder.create();
            builder.show();

        }
    }

    @OnClick(R.id.fab_editar_beer)
    public void editarBeer() {
        enabledTrue();
        mFab.setVisibility(View.GONE);
    }

    @OnClick(R.id.btn_facebook)
    public void chamaTelaFacebook() {
        Toast.makeText(CadastroActivity.this, "Funcionalidade em Desenvolvimento", Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.img_btn_camera)
    public void selectImage(View view) {
        tirarFoto(view);
    }

    /**
     * Metodo abre a camera e tira a foto
     */

    private boolean verifica(Beer beerUP) {

        for (Beer d : gerenciador.buscarTodasBeer()) {
            if (d.getmId() == beerUP.getmId()) {
                return true;
            }

        }
        return false;


    }

    public void tirarFoto(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }

    /**
     * Matodo que recebe o resultado da camera
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
                mImagemBeer.setVisibility(View.VISIBLE);
                image = (Bitmap) data.getExtras().get("data");
                mImagemBeer.setScaleType(ImageView.ScaleType.FIT_XY);
                mImagemBeer.setImageBitmap(image);


                //qualidade da camera
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                image.compress(Bitmap.CompressFormat.JPEG, 100, stream);

                String timeStand = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                mBytes = stream.toByteArray();

                String nomeArquivo = Environment.getExternalStorageDirectory().getAbsolutePath() +
                        "/image" + timeStand + "jpeg";

                /** Salva a imagem no local especificado por nomeArquivo*/
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(nomeArquivo);
                    fileOutputStream.write(mBytes);
                    fileOutputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        else{
            Toast.makeText(this, "Insira uma foto", Toast.LENGTH_LONG).show();
        }


    }

    private void preencherDescricaoComImagem(Beer beer) {

        mNomeBeer.setText(beer.getmNome());
        mDescricaoBeer.setText(beer.getmDescricao());
        mteorBeer.setText("" + beer.getmTeorAlcolico());
        mNacionalidadeBeer.setSelection(getIndex(beer.getmNacionalidade()));
        mRtgbarQualidade.setRating(beerUP.getmQualidade());
        mImagemBeer.setImageBitmap(tratandoImagem(BitmapFactory.decodeByteArray(beerUP.getmImagem(), 0, beerUP.getmImagem().length)));
        mImagemBeer.setVisibility(View.VISIBLE);
        mCamera.setVisibility(View.GONE);
    }

    private void preencherDescricaoSemImagem(Beer beer) {

        mNomeBeer.setText(beer.getmNome());
        mDescricaoBeer.setText(beer.getmDescricao());
        mteorBeer.setText("" + beer.getmTeorAlcolico());
        mNacionalidadeBeer.setSelection(getIndex(beer.getmNacionalidade()));
        mRtgbarQualidade.setRating(beerUP.getmQualidade());
        mImagemBeer.setVisibility(View.GONE);
        mCamera.setVisibility(View.VISIBLE);

    }

    private Bitmap tratandoImagem(Bitmap img){
        Bitmap newBitmap = Bitmap.createScaledBitmap(img,800,600,false);
        return newBitmap;

    }

    private int getIndex(String str) {
        String[] nacionalidades = getResources().getStringArray(R.array.nacionalidades);
        int index = 0;
        for (int i = 0; i < nacionalidades.length ; i++) {
            if (nacionalidades[i].equals(str)) {
                index = i;
                break;
            }

        }
        return index;

    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(CadastroActivity.this, ListarBeerActivity.class));
    }

}








