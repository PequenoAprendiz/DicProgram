package com.projetos.wellington.teste.VIEW;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.projetos.wellington.teste.ENTITY.LinguagemDeProgramacao;
import com.projetos.wellington.teste.R;

import java.util.List;

/**
 * Created by wellington on 05/02/18.
 */

public class LinguagensAdapter extends BaseAdapter {
    private Context context;
    private List<LinguagemDeProgramacao> listaLinguagens;

    public LinguagensAdapter(Context context, List<LinguagemDeProgramacao> GruposAlimentaresAdapter){
        this.context = context;
        this.listaLinguagens = GruposAlimentaresAdapter;
    }

    @Override
    public int getCount() {
        return this.listaLinguagens.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listaLinguagens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinguagemDeProgramacao linguagemDeProgramacao = this.listaLinguagens.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.item_lista_linguagem, null);

        TextView nomeGa = (TextView)layout.findViewById(R.id.textViewNome);
        nomeGa.setText(linguagemDeProgramacao.getNome());

        TextView descricao = (TextView)layout.findViewById(R.id.textViewDescricao);
        descricao.setText(linguagemDeProgramacao.getDescricao());

        return layout;
    }
}
