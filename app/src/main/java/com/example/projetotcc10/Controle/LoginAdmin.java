package com.example.projetotcc10.Controle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projetotcc10.Controle.Admin;
import com.example.projetotcc10.R;

public class LoginAdmin extends AppCompatActivity {

    private EditText emailAdmin, senhaAdmin;
    private Button entrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);


        entrar = findViewById(R.id.Button_Admin_Login);


        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Admin.class);
                startActivity(intent);
            }
        });
    }

}