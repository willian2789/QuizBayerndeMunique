package com.example.quizbayern;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Questao1Activity extends AppCompatActivity {
    Button buttonResponderQ1;
    RadioButton radioButtonGerd;
    TextView textViewNomeQ1;
    String nome="";
    int qtsErros = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao1);

        buttonResponderQ1 = findViewById(R.id.buttonResponderQ1);
        radioButtonGerd = findViewById(R.id.radioButtonGerd);
        textViewNomeQ1 = findViewById(R.id.textViewNomeQ1);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");

        if (!nome.equals("")){
            textViewNomeQ1.setText(nome);
        }
        buttonResponderQ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButtonGerd.isChecked()){
                    Toast.makeText(Questao1Activity.this, "Correto", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Questao1Activity.this, Questao2Activity.class);
                    intent.putExtra("nome",nome);
                    intent.putExtra("qtsErros", qtsErros);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Questao1Activity.this, "Errado", Toast.LENGTH_SHORT).show();
                    qtsErros++;
                }
            }
        });
    }

}