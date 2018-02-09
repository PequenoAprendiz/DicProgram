package com.projetos.wellington.teste.VIEW;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.projetos.wellington.teste.BO.LinguageDeProgramacaoBO;
import com.projetos.wellington.teste.DAO.DataBaseHelper;
import com.projetos.wellington.teste.ENTITY.LinguagemDeProgramacao;
import com.projetos.wellington.teste.R;

import java.sql.SQLException;
import java.util.List;

public class ActivityListaLinguagens extends AppCompatActivity {


    private List<LinguagemDeProgramacao> listaLinguagensProgramacao;
    private ListView mListView;
    private DataBaseHelper dh;
    private LinguageDeProgramacaoBO linguageDeProgramacaoBO;

    //private String[] linguagens = new String[]{"Java", "Python", "C", "Php", "Portugol"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_linguagens);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //recupera o listview criado no layout
        this.mListView = (ListView) findViewById(R.id.listviewLinguagens);

        //Define um adapter
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, linguagens);
       // mListView.setAdapter(adapter);

        //Define um Listener
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;

                LinguagemDeProgramacao linguagemSelecionada = (LinguagemDeProgramacao) mListView.getItemAtPosition(position);

                Intent intent = new Intent(getBaseContext(), DetalhesActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("identificador", linguagemSelecionada.getNome());
                bundle.putString("descricao", linguagemSelecionada.getDescricao());
                intent.putExtras(bundle);
                startActivity(intent);
            }

        });
    }


    @Override
    public void onResume() {
        super.onResume();
        try {
            carregarLista();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void carregarLista() throws SQLException {
        this.linguageDeProgramacaoBO = new LinguageDeProgramacaoBO();
        try {
            this.listaLinguagensProgramacao = this.linguageDeProgramacaoBO.buscarLinguagens(this);
            //recupera o listview criado no layout
            this.mListView = (ListView) findViewById(R.id.listviewLinguagens);

            mListView.setAdapter(new LinguagensAdapter(this, listaLinguagensProgramacao));
            registerForContextMenu(mListView);                                                   /// registrar a listview no menu de conteexto senão o menus de opções não carrega
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
