package com.example.projetotcc10.Controle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.projetotcc10.Modelo.Curso;
import com.example.projetotcc10.R;

import java.util.List;

public class ManterCurso extends AppCompatActivity {


   // ListView listCursos;
   private EditText aliasEditCurso;
    private Button buttoncadastrarCurso;
    private List<Curso> cursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manter_curso);


         aliasEditCurso= findViewById(R.id.editNomeCurso);
         buttoncadastrarCurso = findViewById(R.id.buttonCadastrarCurso);



        buttoncadastrarCurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             // tem como fazer uma listview sem conectar no firebase

            }
        });


    }

    /* private void limparCampos() {
        curso.setText("");
    }

    private void carregalistview(){

        ArrayAdapter<Curso> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cursos);
        listCursos.setAdapter(adaptador);
        adaptador.notifyDataSetChanged();

    }*/

}
