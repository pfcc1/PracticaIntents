package com.example.practicaintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityRestar extends AppCompatActivity {

    Button buttonVolver;
    TextView textViewResultadoResta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restar);

        buttonVolver=findViewById(R.id.buttonVolverResta);
        textViewResultadoResta=findViewById(R.id.textViewResultadoResta);

        String intentdeFuerarecuperarResultadoResta=getIntent().getStringExtra(MainActivity.RESTAR);
        textViewResultadoResta.setText(intentdeFuerarecuperarResultadoResta);
        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res=textViewResultadoResta.getText().toString();
                Intent intent=new Intent();
                intent.putExtra(MainActivity.RESTAR,res);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}