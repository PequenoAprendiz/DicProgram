package com.projetos.wellington.teste.VIEW;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.projetos.wellington.teste.R;

public class DetalhesActivity extends AppCompatActivity {

    String nomeLinguagem;
    String descricaoLinguagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        this.nomeLinguagem = bundle.getString("identificador");
        this.descricaoLinguagem = bundle.getString("descricao");
        getSupportActionBar().setTitle(this.nomeLinguagem);

        exibirDescricaoLinguagem();

    }

    private void exibirDescricaoLinguagem() {
        TextView textViewDescricao = (TextView) findViewById(R.id.textViewDescricao);
        textViewDescricao.setText(descricaoLinguagem);
    }
}
