



package com.example.projetotcc10.Controle;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.projetotcc10.Modelo.Professor;
import com.example.projetotcc10.R;

import java.util.List;

public class Listar_Curso extends AppCompatActivity {


    private ListView listaCurso;
    private List<Professor> cursos;
    private Button aliasCadastrarCurso;
    private  AlertDialog alerta;


    private String[] ArrayCursos = new String[]{
            "Informática\n",
            "Agropecuária\n",
            "TADS\n",
            "Informática\n",
            "Agropecuária\n",
            "TADS\n"
            ,"Engenharia\n",
            "Direito\n",
            "Elétrica\n",
            "Engenharia\n"
            ,"Direito\n",
            "Elétrica\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Lista cursos");


        setContentView(R.layout.activity_listar_curso);
        listaCurso = findViewById(R.id.listCurso);

        carregalistview();

        FloatingActionButton cadastrar = findViewById(R.id.buttonActionCadastrarCurso);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),ManterCurso.class);
                startActivity(intent);
            }
        });


       listaCurso.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                // TODO Auto-generated method stub


                exemplo_simples();
                listaCurso.getItemAtPosition(position);

                return true;
            }

        });
    }
    private void exemplo_simples() {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Alerta!");
        //define a mensagem
        builder.setMessage("Deseja mesmo excluir esse curso?");
        //define um botão como positivo
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(getApplicationContext(), "Curso excluido" , Toast.LENGTH_SHORT).show();
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(getApplicationContext(), "Ação cancelada" , Toast.LENGTH_SHORT).show();
            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(this, Admin.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

    private void carregalistview(){

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ArrayCursos);
        listaCurso.setAdapter(adaptador);
        adaptador.notifyDataSetChanged();

    }
}