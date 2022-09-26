package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUsuario, etContra;
    Button btnIniciar, btnRegistrarse;
    CheckBox cbRecordar;
    Toolbar mi_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        etUsuario = findViewById(R.id.etUsuario);
        etContra = findViewById(R.id.etContra);

        mi_toolbar = findViewById(R.id.mi_toolbar);
        setSupportActionBar(mi_toolbar);
        getSupportActionBar().setTitle("GAME OF THRONES");

        cbRecordar = findViewById(R.id.cbRecordar);

        SharedPreferences prefs=getApplicationContext().getSharedPreferences(Contantes.SP_CREDENCIALES, MODE_PRIVATE);
        String usuarioGuardado= prefs.getString(Contantes.USUARIO, null);
        String passGuardado= prefs.getString(Contantes.PASSWORD, null);

        if(usuarioGuardado != null && passGuardado != null){
            iniciarMainActivity(usuarioGuardado);
        }

        btnIniciar = findViewById(R.id.btnIniciar);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TODO","SE APRETO EL BOTON INICIAR SESION");
                String usuario = etUsuario.getText().toString();
                String contra = etContra.getText().toString();
                if(usuario.isEmpty()||contra.isEmpty()){
                    Toast.makeText(LoginActivity.this, "COMPLETAR DATOS", Toast.LENGTH_SHORT).show();
                }
                else {
                    login(usuario, contra);

                }
            }
        });



        btnRegistrarse = findViewById(R.id.btnRegistrarse);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TODO","SE APRETO EL BOTON REGISTRARSE");
                Intent registro_activity = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(registro_activity);
                finish();
            }
        });
    }

    private void login(String usuario, String contra) {
        if(cbRecordar.isChecked()){
            SharedPreferences prefs = getApplicationContext().getSharedPreferences(Contantes.SP_CREDENCIALES, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(Contantes.USUARIO, usuario);
            editor.putString(Contantes.PASSWORD,contra);
            editor.apply();
        }
        iniciarMainActivity(usuario);
    }


    private void iniciarMainActivity(String usuarioGuardado) {
        Intent main_activity = new Intent(LoginActivity.this, MainActivity.class);
        main_activity.putExtra("usuario",usuarioGuardado);
        startActivity(main_activity);
        finish();
    }
}