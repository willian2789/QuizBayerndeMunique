package com.example.quizbayern;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Questao4Activity extends AppCompatActivity {
    Button buttonResponderQ4;
    CheckBox checkBoxBayern, checkSchalke04,checkBoxRapidWien,checkBoxVFBLeipzig;
    TextView textViewNomeQ4;
    String nome = "";
    int qtsErros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao4);

        buttonResponderQ4 = findViewById(R.id.buttonResponderQ4);
        checkBoxBayern = findViewById(R.id.checkBoxBayern);
        checkSchalke04 = findViewById(R.id.checkSchalke04);
        checkBoxRapidWien = findViewById(R.id.checkBoxRapidWien);
        checkBoxVFBLeipzig = findViewById(R.id.checkBoxVFBLeipzig);
        textViewNomeQ4 = findViewById(R.id.textViewNomeQ4);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtsErros = bundle.getInt("qtsErros");

        if(!nome.equals("")){
            textViewNomeQ4.setText(nome);
        }


        buttonResponderQ4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBoxBayern.isChecked() && checkSchalke04.isChecked() &&
                        !checkBoxRapidWien.isChecked() && !checkBoxVFBLeipzig.isChecked())
                {
                    Toast.makeText(Questao4Activity.this, "certo", Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao4Activity.this);
                    msg.setMessage(nome + " Parabens.  "  + "Voce errou: "+ qtsErros);
                    msg.show();
                }
                else{
                    Toast.makeText(Questao4Activity.this, "Errado", Toast.LENGTH_SHORT).show();
                    qtsErros++;
                    AlertDialog.Builder msg = new AlertDialog.Builder(Questao4Activity.this);
                }
            }
        });
    }
}