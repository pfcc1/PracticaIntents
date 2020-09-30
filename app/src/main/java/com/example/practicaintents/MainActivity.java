package com.example.practicaintents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonSumar,buttonRestar;
    EditText editTextN1, editTextN2;
    TextView textViewResultado;
    public static final String SUMAR="Sumar";
    public static final String RESTAR="Restar";
    public static final int CODIGO_VUELTA_SUMA=1;
    public static final int CODIGO_VUELTA_RESTA=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSumar=findViewById(R.id.buttonSumar);
        buttonRestar=findViewById(R.id.buttonRestar);
        editTextN1=findViewById(R.id.editTextNumber1);
        editTextN2=findViewById(R.id.editTextNumber2);
        textViewResultado=findViewById(R.id.textViewResultado);

        buttonSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int op1=Integer.parseInt(editTextN1.getText().toString());
                int op2=Integer.parseInt(editTextN2.getText().toString());
                int resultado=op1+op2;

                Intent intentSumar=new Intent(MainActivity.this,ActivitySumar.class);
                intentSumar.putExtra(SUMAR,String.valueOf(resultado));
                startActivityForResult(intentSumar,CODIGO_VUELTA_SUMA);//Lanzar la actividad

            }
        });

        buttonRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int op1=Integer.parseInt(editTextN1.getText().toString());
                int op2=Integer.parseInt(editTextN2.getText().toString());
                int resultado=op1-op2;

                Intent intentRestar=new Intent(MainActivity.this,ActivityRestar.class);
                intentRestar.putExtra(RESTAR,String.valueOf(resultado));

                startActivityForResult(intentRestar,CODIGO_VUELTA_RESTA);//Lanzar la actividad
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==CODIGO_VUELTA_SUMA && resultCode==RESULT_OK){
            String resultadosuma=data.getStringExtra(SUMAR);
            textViewResultado.setText(resultadosuma);

        }
        else if(requestCode==CODIGO_VUELTA_RESTA && resultCode==RESULT_OK){
            String resultadoresta=data.getStringExtra(RESTAR);
            textViewResultado.setText(resultadoresta);
        }
    }
}