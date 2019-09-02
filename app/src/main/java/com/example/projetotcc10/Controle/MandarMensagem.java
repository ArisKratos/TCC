package com.example.projetotcc10.Controle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.projetotcc10.R;

public class MandarMensagem extends AppCompatActivity {

    private EditText anoTurma, mensagem;
    private Spinner cursos;
    private Spinner semestres;
    private CheckBox checkSendForAll;
    private Button enviarMensagem;
    private Integer numeroSemestre;
    private String nomeCurso;
    private Integer anoTurmaNumero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandar_mensagem);

        String[] ArraySemestres = new String[] {"1", "2"};
        String[] ArrayCursos = new String[]{"Informática", "Agropecuária"};

        anoTurma = findViewById(R.id.editAnoTurmaMsg);
        cursos = findViewById(R.id.spinnerCursoMsg);
        semestres = findViewById(R.id.spinnerSemestreMsg);
        checkSendForAll = findViewById(R.id.checkSendAll);
        enviarMensagem = findViewById(R.id.buttonEnviarMensagem);






        final ArrayAdapter<String> spinnerSemestres = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ArraySemestres);

        spinnerSemestres.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semestres.setAdapter(spinnerSemestres);

        final ArrayAdapter<String> spinnerCursos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ArrayCursos);

        spinnerCursos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cursos.setAdapter(spinnerCursos);


         enviarMensagem.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 switch (semestres.getSelectedItemPosition()) {

                     case 0:

                         numeroSemestre = 1;
                         break;
                     case 1:
                         numeroSemestre = 2;
                         break;

                     default:
                 }
                 switch (cursos.getSelectedItemPosition()) {

                     case 0:

                         nomeCurso = spinnerCursos.getItem(0);
                         break;
                     case 1:
                         nomeCurso = spinnerCursos.getItem(1);

                         break;

                     default:
                 }
                 try {


                     if (anoTurma.getText().length() == 0) {
                         anoTurma.setError("Precisa inserir \n o ano de ingresso\n da turma");


                     } else {

                         anoTurmaNumero = Integer.parseInt(anoTurma.getText().toString());
                         if (anoTurmaNumero < 2000 || anoTurmaNumero > 2100) {
                             anoTurma.setError("Ano inválido");
                         } else {

                             if (checkSendForAll.isChecked()) {
                                 Toast.makeText(getApplicationContext(), "Semestre: " + numeroSemestre + "\nCurso: " + nomeCurso + "\nAno: " + anoTurmaNumero
                                         + "\n Enviado para todos!", Toast.LENGTH_SHORT).show();
                             } else {

                                 Toast.makeText(getApplicationContext(), "Semestre: " + numeroSemestre + "\nCurso: " + nomeCurso + "\nAno: " + anoTurmaNumero, Toast.LENGTH_SHORT).show();
                             }
                         }

                     }


                 }catch (Exception e){
                     e.printStackTrace();
                 }
             }

         });

    }
}
