package com.example.leydsontavares.beerregisterapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by LeydsonTavares on 20/09/2016.
 */
public class Beer implements Parcelable {


    private int mId;
    private String mNome;
    private String mDescricao;
    private byte[] mImagem;
    private String mQualidade;
    private Double mTeorAlcolico;
    private String mNacionalidade;


    public Beer(int id, String nome, String descrição, byte[] imagem, String qualidade,
                Double teorAlcolico,String nacionalidade) {
        this.mId = id;
        this.mNome = nome;
        this.mDescricao = descrição;
        this.mImagem = imagem;
        this.mQualidade = qualidade;
        this.mTeorAlcolico = teorAlcolico;
        this.mNacionalidade = nacionalidade;

    }

    public Beer() {
    }

    public Beer(Parcel in) {
        mId = in.readInt();
        mNome = in.readString();
        mDescricao = in.readString();
        mImagem = in.createByteArray();
        mQualidade = in.readString();
        mTeorAlcolico = in.readDouble();
        mNacionalidade = in.readString();

    }

    public static final Creator<Beer> CREATOR = new Creator<Beer>() {
        @Override
        public Beer createFromParcel(Parcel in) {
            return new Beer(in);
        }

        @Override
        public Beer[] newArray(int size) {
            return new Beer[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mNome);
        dest.writeString(mDescricao);
        dest.writeByteArray(mImagem);
        dest.writeString(mQualidade);
        dest.writeDouble(mTeorAlcolico);
        dest.writeString(mNacionalidade);


    }




    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmNome() {
        return mNome;
    }

    public void setmNome(String mNome) {
        this.mNome = mNome;
    }

    public String getmDescricao() {
        return mDescricao;
    }

    public void setmDescricao(String mDescricao) {
        this.mDescricao = mDescricao;
    }

    public byte[] getmImagem() {
        return mImagem;
    }

    public void setmImagem(byte[] mImagem) {
        this.mImagem = mImagem;
    }

    public String getmQualidade() {
        return mQualidade;
    }

    public void setmQualidade(String mQualidade) {
        this.mQualidade = mQualidade;
    }

    public Double getmTeorAlcolico() {
        return mTeorAlcolico;
    }

    public void setmTeorAlcolico(Double mTeorAlcolico) {
        this.mTeorAlcolico = mTeorAlcolico;
    }

    public String getmNacionalidade() {
        return mNacionalidade;
    }

    public void setmNacionalidade(String mNacionalidade) {
        this.mNacionalidade = mNacionalidade;
    }


}
