package com.example.td1_formulaire;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Patterns;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.os.Handler;

public class Spash_act extends AppCompatActivity {

    private final int display_length = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_act);

        //supportActionBar?.hide()

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent mainIntent = new Intent(Spash_act.this, MainActivity.class);
                Spash_act.this.startActivity(mainIntent);
                Spash_act.this.finish();
            }
        }, display_length);
    }

}