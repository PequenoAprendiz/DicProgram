package com.projetos.wellington.teste.BO;

import android.content.Context;

import com.j256.ormlite.stmt.QueryBuilder;
import com.projetos.wellington.teste.DAO.DataBaseHelper;
import com.projetos.wellington.teste.DAO.LinguagemDeProgramacaoDAO;
import com.projetos.wellington.teste.ENTITY.LinguagemDeProgramacao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wellington on 01/02/18.
 */

public class LinguageDeProgramacaoBO {

    private DataBaseHelper dh;
    private LinguagemDeProgramacaoDAO linguagemDao;
    private LinguagemDeProgramacao linguagemDeProgramacao;
    private List<LinguagemDeProgramacao> listaLinguagens;


    public LinguageDeProgramacaoBO() {
    }

    //criar os dados sobre as linguagens de programação
    // cadastrar
    public void cadastrarLinguagem(Context context) throws SQLException {

        try {
            this.dh = new DataBaseHelper(context);
            this.linguagemDao = new LinguagemDeProgramacaoDAO(this.dh.getConnectionSource());
            this.listaLinguagens = new ArrayList<LinguagemDeProgramacao>();


            linguagemDeProgramacao = new LinguagemDeProgramacao();
            linguagemDeProgramacao.setNome("Java");
            linguagemDeProgramacao.setDescricao("Descrição da linguagem java aqui!");
            listaLinguagens.add(linguagemDeProgramacao);

            linguagemDeProgramacao = new LinguagemDeProgramacao();
            linguagemDeProgramacao.setNome("Php");
            linguagemDeProgramacao.setDescricao("Descrição da linguagem php aqui!");
            listaLinguagens.add(linguagemDeProgramacao);

            linguagemDeProgramacao = new LinguagemDeProgramacao();
            linguagemDeProgramacao.setNome("Phyton");
            linguagemDeProgramacao.setDescricao("Descrição da linguagem phyton aqui!");
            listaLinguagens.add(linguagemDeProgramacao);

            for (LinguagemDeProgramacao lp : listaLinguagens) {
                linguagemDao.create(lp);
            }

            listaLinguagens = null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // recuperar os dados sobre as linguagens para listá-las
    public List<LinguagemDeProgramacao> buscarLinguagens(Context context) throws SQLException {
        List<LinguagemDeProgramacao> lista = null;
        this.dh = new DataBaseHelper(context);
        this.linguagemDao = new LinguagemDeProgramacaoDAO(this.dh.getConnectionSource());
        try {
            lista = this.linguagemDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}