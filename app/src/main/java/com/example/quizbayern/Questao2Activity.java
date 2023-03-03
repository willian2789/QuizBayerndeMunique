package com.example.quizbayern;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Questao2Activity extends AppCompatActivity {
    Button  buttonResponderQ2;
    RadioButton radioButton27;
    String nome = "";
    TextView textViewNomeQ2;
    int qtsErros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao2);

        buttonResponderQ2 = findViewById(R.id.buttonResponderQ2);
        radioButton27 = findViewById(R.id.radioButton27);
        textViewNomeQ2 = findViewById(R.id.textViewNomeQ2);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtsErros = bundle.getInt("qtsErros");

        if (!nome.equals("")){
            textViewNomeQ2.setText(nome);
        }

        buttonResponderQ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton27.isChecked()){
                    Toast.makeText(Questao2Activity.this, "Correto", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Questao2Activity.this, Questao3Activity.class);
                    intent.putExtra("nome", nome);
                    intent.putExtra("qtsErros",qtsErros);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Questao2Activity.this, "Errado", Toast.LENGTH_SHORT).show();
                    qtsErros++;
               }
            }
        });
    }
}