package com.example.chatburro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity {

    private EditText edEntradaTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        /*BUSCANDO OS ICONES DO XML*/
        Button resposta = findViewById(R.id.btReply);
        edEntradaTexto = findViewById(R.id.entradaTexto);
        TextView tvMensagem= findViewById(R.id.mensagem);

        /* RECEBENDO E EXIBINDO A RESPOSTA NESSA MESMA ACTIVITY*/
        String mensagem = getIntent().getStringExtra("KEY_MESSAGE");
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
        tvMensagem.setText(mensagem);

        /* ENVIANDO UMA MENSAGEM PARA OUTRA ACTIVITY*/
        View.OnClickListener envioDeResposta = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensagem = edEntradaTexto.getText().toString();
                Intent intent = new Intent(MainActivity2.this,MainActivity1.class);
                intent.putExtra("KEY_MESSAGE_2", mensagem);
                startActivity(intent);
            }
        };

        resposta.setOnClickListener(envioDeResposta);

    }
}