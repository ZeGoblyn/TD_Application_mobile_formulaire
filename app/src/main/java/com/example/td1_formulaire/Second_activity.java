package com.example.td1_formulaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Second_activity extends AppCompatActivity {

    TextView receiver_N;
    TextView receiver_P;
    TextView receiver_A;
    TextView receiver_M;
    TextView receiver_T;
    TextView receiver_G;
    TextView receiver_V;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);

        receiver_N = (TextView)findViewById(R.id.receiveNom);
        receiver_P = (TextView)findViewById(R.id.receivePrenom);
        receiver_A = (TextView)findViewById(R.id.receiveAge);
        receiver_M = (TextView)findViewById(R.id.receiveMail);
        receiver_T = (TextView)findViewById(R.id.receiveTelephone);
        receiver_G = (TextView)findViewById(R.id.receiveGenre);
        receiver_V = (TextView)findViewById(R.id.receiveValidation);

        Intent intent = getIntent();

        String stN = intent.getStringExtra("message_keyN");
        receiver_N.setText(stN);

        String stP = intent.getStringExtra("message_keyP");
        receiver_P.setText(stP);

        String stA = intent.getStringExtra("message_keyA");
        receiver_A.setText(stA);

        String stM = intent.getStringExtra("message_keyM");
        receiver_M.setText(stM);

        String stT = intent.getStringExtra("message_keyT");
        receiver_T.setText(stT);

        String stG = intent.getStringExtra("message_radG");
        receiver_G.setText(stG);

        String stV = intent.getStringExtra("message_radV");
        receiver_V.setText(stV);
    }
}