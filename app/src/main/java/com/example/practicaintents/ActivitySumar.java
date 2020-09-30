package com.example.practicaintents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivitySumar extends AppCompatActivity {

    Button buttonVolver;
    TextView textViewResultadoSuma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumar);

        buttonVolver=findViewById(R.id.buttonVolverSuma);
        textViewResultadoSuma=findViewById(R.id.textViewResultadoSuma);


        String intentdeFuerarecuperarResultadoSuma=getIntent().getStringExtra(MainActivity.SUMAR);

        textViewResultadoSuma.setText("Suma: "+intentdeFuerarecuperarResultadoSuma);
        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res=textViewResultadoSuma.getText().toString();
                Intent intent=new Intent();
                intent.putExtra(MainActivity.SUMAR,res);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }


}