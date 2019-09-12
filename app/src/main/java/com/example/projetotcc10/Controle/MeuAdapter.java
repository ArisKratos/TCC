package com.example.projetotcc10.Controle;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projetotcc10.Modelo.Mensagem;
import com.example.projetotcc10.R;

import java.util.List;

public class MeuAdapter extends RecyclerView.Adapter  {


    private List<Mensagem> mensagens;
    private Context context;

    public MeuAdapter(List<Mensagem> mensagens, Context context){


 

//

        this.mensagens = mensagens;
        this.context = context;

    }

    //  public MeuAdapter(List<Mensagem> mensagens, Context context){


    //  Mensagem mensagem = new Mensagem("ola", "Marcelo", dataMensagem);
     //   Mensagem mensagem1 = new Mensagem("tudo bem", "Emilio", dataMensagem,);
//      this.mensagens.add(mensagem);
//      this.mensagens.add(mensagem1);

   //     this.mensagens = mensagens;
   //   this.context = context;

//    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.activity_listar_mensagens, parent, false);

        MeuViewHolder holder = new MeuViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        MeuViewHolder holder = (MeuViewHolder) viewHolder;
        Mensagem mensagem = mensagens.get(position);

        holder.mensagem.setText(mensagem.getProfessor());
        holder.mensagem.setText(mensagem.getMensagem());


    }

    @Override
    public int getItemCount() {
        return mensagens == null ? 0 : mensagens.size();
    }



}


