package com.projetos.wellington.teste.DAO;

import com.projetos.wellington.teste.ENTITY.LinguagemDeProgramacao;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by wellington on 02/11/17.
 */

    public class LinguagemDeProgramacaoDAO extends BaseDaoImpl<LinguagemDeProgramacao, Integer> {
        public LinguagemDeProgramacaoDAO(ConnectionSource connectionSource) throws SQLException {
            super(LinguagemDeProgramacao.class);
            setConnectionSource(connectionSource);
            initialize();
        }
}
