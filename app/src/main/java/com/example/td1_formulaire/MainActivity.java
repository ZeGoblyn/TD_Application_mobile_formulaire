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

public class MainActivity<button, boutonVal> extends AppCompatActivity {

    private TextInputLayout textInputNom;
    private TextInputLayout textInputPrenom;
    private TextInputLayout textInputAge;
    private TextInputLayout textInputMail;
    private TextInputLayout textInputTelephone;

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private TextView textView;
    private RadioGroup radioGp2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textInputNom = findViewById(R.id.text_input_nom);
        textInputPrenom = findViewById(R.id.text_input_prenom);
        textInputAge = findViewById(R.id.text_input_age);
        textInputMail = findViewById(R.id.text_input_mail);
        textInputTelephone = findViewById(R.id.text_input_telephone);



        //addListenerOnButton();

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    private boolean validationMail()
    {
        String emailInput = textInputMail.getEditText().getText().toString().trim();
        if (emailInput.isEmpty()){
            textInputMail.setError("Champ obligatoire");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            textInputMail.setError("Veuillez entrer une adresse mail valide");
            return false;
        } else {
            textInputMail.setError(null);
            return true;
        }
    }

    private boolean validationNom()
    {
        String nomInput = textInputNom.getEditText().getText().toString().trim();
        if (nomInput.isEmpty() | nomInput.contains("Nom")){
            textInputNom.setError("Champ obligatoire");
            return false;
        } else {
            textInputNom.setError(null);
            return true;
        }
    }

    private boolean validationPrenom()
    {
        String prenomInput = textInputPrenom.getEditText().getText().toString().trim();
        if (prenomInput.isEmpty() | prenomInput.contains("Prenom")){
            textInputPrenom.setError("Champ obligatoire");
            return false;
        } else {
            textInputPrenom.setError(null);
            return true;
        }
    }





    public void confirmationInput(View v){
        if(!validationMail() | !validationMail()){
            return;
        }

        if(!validationNom() | !validationNom()){
            return;
        }

        if(!validationPrenom() | !validationPrenom()){
            return;
        }
        String input = "Email : "+textInputMail.getEditText().getText().toString();
        input += "\n";

        String inputN = "Nom : "+textInputNom.getEditText().getText().toString();
        inputN += "\n";

        String inputP = "Prenom : "+textInputPrenom.getEditText().getText().toString();
        inputP += "\n";

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, inputN, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, inputP, Toast.LENGTH_SHORT).show();

        onClick(v);
    }

    public void onClick(View v)
    {
        String strN = textInputNom.getEditText().getText().toString();
        Intent intent = new Intent(getApplicationContext(), Second_activity.class);
        intent.putExtra("message_keyN", strN);

        String strP = textInputPrenom.getEditText().getText().toString();
        intent.putExtra("message_keyP", strP);

        String strA = textInputAge.getEditText().getText().toString();
        intent.putExtra("message_keyA", strA);

        String strM = textInputMail.getEditText().getText().toString();
        intent.putExtra("message_keyM", strM);

        String strT = textInputTelephone.getEditText().getText().toString();
        intent.putExtra("message_keyT", strT);

        RadioGroup radioGroup = findViewById(R.id.groupGenre);
        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (selectedRadioButtonId != -1) {
            radioButton = findViewById(selectedRadioButtonId);
            String selectedRbText = radioButton.getText().toString();
            intent.putExtra("message_radG", selectedRbText);
        }

        RadioGroup radioGp2 = findViewById(R.id.groupAffirm);
        int selectedRadioButtonId2 = radioGp2.getCheckedRadioButtonId();
        if (selectedRadioButtonId2 != -1) {
            radioButton = findViewById(selectedRadioButtonId2);
            String selectedRbText2 = radioButton.getText().toString();
            intent.putExtra("message_radV", selectedRbText2);
        }

        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}