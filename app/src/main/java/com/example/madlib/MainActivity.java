package com.example.madlib;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createMadLib(View v){

             TextView warning = (TextView) findViewById(R.id.warning);

            EditText name = (EditText) findViewById(R.id.editName);
            EditText integer = (EditText) findViewById(R.id.editInt);
            EditText verb1 = (EditText) findViewById(R.id.editVerb1);
            EditText noun = (EditText) findViewById(R.id.editNoun);
            EditText verb2 = (EditText) findViewById(R.id.editVerb2);
            EditText adj = (EditText) findViewById(R.id.editAdj);

            String nameStr = name.getText().toString();
            String intStr = integer.getText().toString();
            String verb1Str = verb1.getText().toString();
            String nounStr = noun.getText().toString();
            String verb2Str = verb2.getText().toString();
            String adjStr = adj.getText().toString();

            if(nameStr.equals("")){
                warning.setVisibility(View.VISIBLE);
                return;

            }
            if(intStr.equals("")){
            warning.setVisibility(View.VISIBLE);
            return;
            }
            if(verb1Str.equals("")){
            warning.setVisibility(View.VISIBLE);
            return;
            }
            if(nounStr.equals("")){
            warning.setVisibility(View.VISIBLE);
            return;
            }
            if(verb2Str.equals("")){
            warning.setVisibility(View.VISIBLE);
            return;
            }
            if(adjStr.equals("")){
            warning.setVisibility(View.VISIBLE);
            return;
            }




                Intent intent = new Intent(this, MadLibDone.class);

                intent.putExtra(MadLibDone.NAME, nameStr);
                intent.putExtra(MadLibDone.AGE, intStr);
                intent.putExtra(MadLibDone.VERB1, verb1Str);
                intent.putExtra(MadLibDone.NOUN, nounStr);
                intent.putExtra(MadLibDone.VERB2, verb2Str);
                intent.putExtra(MadLibDone.ADJ, adjStr);

                startActivity(intent);


        }









    }

