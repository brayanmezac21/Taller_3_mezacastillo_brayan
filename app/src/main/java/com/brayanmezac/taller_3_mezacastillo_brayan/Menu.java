package com.brayanmezac.taller_3_mezacastillo_brayan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void ejecutar(View view){
        if(view.getId()==R.id.salir){
            finish();
        } else if (view.getId()==R.id.Agregar){
            Intent intent = new Intent(Menu.this, MenuBDActivity.class);
                //100 --->
            startActivityForResult(intent, 100);
        }
    }
}