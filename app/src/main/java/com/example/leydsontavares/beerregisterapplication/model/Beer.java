package com.example.leydsontavares.beerregisterapplication.model;

import android.os.Parcel;
import android.os.Parcelable;


public class Beer implements Parcelable,Comparable<Beer> {

    int mId;
    String mNome;
    String mDescricao;
    byte[] mImagem;
    Float mQualidade;
    Double mTeorAlcolico;
    String mNacionalidade;

    public Beer(){}


    public Beer(Parcel in) {
        mId = in.readInt();
        mNome = in.readString();
        mDescricao = in.readString();
        mImagem = in.createByteArray();
        mQualidade = in.readFloat();
        mTeorAlcolico = in.readDouble();
        mNacionalidade = in.readString();

    }

    public static final Parcelable.Creator<Beer> CREATOR = new Parcelable.Creator<Beer>() {
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
        dest.writeFloat(mQualidade);
        dest.writeDouble(mTeorAlcolico);
        dest.writeString(mNacionalidade);


    }

    @Override
    public int compareTo(Beer another) {
        if ((this.mQualidade) > (another.getmQualidade())) {
            return -1;
        }
        if ((this.mQualidade) < (another.getmQualidade())) {
            return 1;
        }
        return 0;
    }

    public int getmId() {
        return mId;
    }

    public String getmNome() {
        return mNome;
    }

    public String getmDescricao() {
        return mDescricao;
    }

    public byte[] getmImagem() {
        return mImagem;
    }

    public Float getmQualidade() {
        return mQualidade;
    }

    public String getmNacionalidade() {
        return mNacionalidade;
    }

    public Double getmTeorAlcolico() {
        return mTeorAlcolico;
    }



}


