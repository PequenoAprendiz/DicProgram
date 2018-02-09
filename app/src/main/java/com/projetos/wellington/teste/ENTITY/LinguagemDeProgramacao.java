package com.projetos.wellington.teste.ENTITY;

import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by wellington on 02/11/17.
 */

@DatabaseTable(tableName = "LinguagemDeProgramacao")
public class LinguagemDeProgramacao  implements Parcelable, Serializable {

    public LinguagemDeProgramacao(){}

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String nome;

    @DatabaseField
    private String descricao;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    public LinguagemDeProgramacao(Parcel in) {
        id = in.readInt();
        nome = in.readString();
        if (in.readByte() == 0) {
            descricao = null;
        } else {
            descricao = in.readString();
        }
    }

    public static final Creator<LinguagemDeProgramacao> CREATOR = new Creator<LinguagemDeProgramacao>() {
        @Override
        public LinguagemDeProgramacao createFromParcel(Parcel in) {
            return new LinguagemDeProgramacao(in);
        }

        @Override
        public LinguagemDeProgramacao[] newArray(int size) {
            return new LinguagemDeProgramacao[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(nome);
        parcel.writeString(descricao);
    }
}
