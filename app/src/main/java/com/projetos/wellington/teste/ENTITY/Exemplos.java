package com.projetos.wellington.teste.ENTITY;

import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by wellington on 14/11/17.
 */

@DatabaseTable(tableName = "Exemplos")
public class Exemplos implements Parcelable,Serializable {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private int idLinguagem; //recuperar o nome da linguagem
    
    @DatabaseField
    private String exemplo; // tipo de exemplo: estrutura de repetição, declaração de variáveis

    @DatabaseField
    private String descricao;

    protected Exemplos(Parcel in) {
        id = in.readInt();
        idLinguagem = in.readInt();
        exemplo = in.readString();
        descricao = in.readString();
    }

    public static final Creator<Exemplos> CREATOR = new Creator<Exemplos>() {
        @Override
        public Exemplos createFromParcel(Parcel in) {
            return new Exemplos(in);
        }

        @Override
        public Exemplos[] newArray(int size) {
            return new Exemplos[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(idLinguagem);
        parcel.writeString(exemplo);
        parcel.writeString(descricao);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLinguagem() {
        return idLinguagem;
    }

    public void setIdLinguagem(int idLinguagem) {
        this.idLinguagem = idLinguagem;
    }

    public String getExemplos() {
        return exemplo;
    }

    public void setExemplos(String exemplo) {
        this.exemplo = exemplo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
