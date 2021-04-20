package com.brayanmezac.taller_3_mezacastillo_brayan;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void BtnsInicio(View view){
        Intent invitado = new Intent(this,Menu.class);
        startActivity(invitado);
    }
}