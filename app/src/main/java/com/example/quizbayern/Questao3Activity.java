package com.example.quizbayern;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Questao3Activity extends AppCompatActivity {
    Button buttonResponderQ3;
    RadioButton radioButton6;
    TextView textViewNomeQ3;
    String nome = "";
    int qtsErros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao3);

        buttonResponderQ3 = findViewById(R.id.buttonResponderQ3);
        radioButton6 = findViewById(R.id.radioButton6);
        textViewNomeQ3 = findViewById(R.id.textViewNomeQ3);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtsErros = bundle.getInt("qtsErros");

        if (!nome.equals("")){
            textViewNomeQ3.setText(nome);
        }
        buttonResponderQ3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton6.isChecked()){
                    Toast.makeText(Questao3Activity.this, "Correto", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Questao3Activity.this, Questao4Activity.class);
                    intent.putExtra("nome", nome);
                    intent.putExtra("qtsErros",qtsErros);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Questao3Activity.this, "Errado", Toast.LENGTH_SHORT).show();
                    qtsErros++;

                }
            }
        });
    }
}
