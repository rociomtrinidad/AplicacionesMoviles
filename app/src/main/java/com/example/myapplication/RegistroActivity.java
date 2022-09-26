package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    EditText etNombre, etApellido, etUsuarioNuevo, etContraNueva, etContraOtraVez, etEmail;
    Button btnCrear;
    Toolbar mi_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mi_toolbar = findViewById(R.id.mi_toolbar);
        setSupportActionBar(mi_toolbar);
        getSupportActionBar().setTitle("GAME OF THRONES");

        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etUsuarioNuevo = findViewById(R.id.etUsuarioNuevo);
        etContraNueva = findViewById(R.id.etContraNueva);
        etContraOtraVez = findViewById(R.id.etContraOtraVez);
        etEmail = findViewById(R.id.etEmail);

        btnCrear = findViewById(R.id.btnCrear);

        btnCrear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.i("TODO","SE APRETO EL BOTON INICIAR SESION");
                String nombre = etNombre.getText().toString();
                String apellido = etApellido.getText().toString();
                String usuarioNuevo = etUsuarioNuevo.getText().toString();
                String contraNueva = etContraNueva.getText().toString();
                String contraOtraVez = etContraOtraVez.getText().toString();
                String email = etEmail.getText().toString();

                if(nombre.isEmpty()||apellido.isEmpty()||usuarioNuevo.isEmpty()||contraNueva.isEmpty()||contraOtraVez.isEmpty()||email.isEmpty()){
                    Toast.makeText(RegistroActivity.this, "COMPLETAR DATOS", Toast.LENGTH_SHORT).show();
                }
                Intent main_activity = new Intent(RegistroActivity.this, MainActivity.class);
                main_activity.putExtra("usuario",usuarioNuevo);

                startActivity(main_activity);
                finish();

            }
        });
    }
}