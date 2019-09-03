package com.example.madlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import org.xml.sax.XMLReader;

public class MadLibDone extends AppCompatActivity {

    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String VERB1 = "verb1";
    public static final String NOUN = "noun";
    public static final String VERB2 = "verb2";
    public static final String ADJ = "adj";



    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_lib_done);

        Intent intent = getIntent();
        String name = intent.getStringExtra(NAME);
        String age = intent.getStringExtra(AGE);
        String verb1 = intent.getStringExtra(VERB1);
        String noun = intent.getStringExtra(NOUN);
        String verb2 = intent.getStringExtra(VERB2);
        String adj = intent.getStringExtra(ADJ);

        name = name.toUpperCase();
        age = age.toUpperCase();
        verb1 = verb1.toUpperCase();
        noun = noun.toUpperCase();
        verb2 = verb2.toUpperCase();
        adj = adj.toUpperCase();


        String madLib = "There once was a person named " + name + ", who was " + age + " years old. "
                + name + " was " + verb1 + " one day when they saw a " + noun + " flying through the sky!"
                + " The " + noun + " came down and " + verb2 + ". " + name + " was so " + adj +". The End";

        TextView madLibText = (TextView) findViewById(R.id.textViewMadLib);

        madLibText.setText(madLib);



    }

    public void goBack(View v){

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }

    public void shareMadLib(View v){

        Intent intent = getIntent();
        String name = intent.getStringExtra(NAME);
        String age = intent.getStringExtra(AGE);
        String verb1 = intent.getStringExtra(VERB1);
        String noun = intent.getStringExtra(NOUN);
        String verb2 = intent.getStringExtra(VERB2);
        String adj = intent.getStringExtra(ADJ);




        String madLib = "There once was a person named " + name + ", who was " + age + " years old. "
                + name + " was " + verb1 + " one day when they saw a " + noun + " flying through the sky!"
                + " The " + noun + " came down and " + verb2 + ". " + name + " was so " + adj +". The End";

        Intent intentShare = new Intent(Intent.ACTION_SEND);
        intentShare.setType("text/plain");
        intentShare.putExtra(Intent.EXTRA_INTENT, madLib);

        String chooserTitle = "Choose an app to send your MadLib";

        Intent chosenIntent = Intent.createChooser(intentShare, chooserTitle);
        startActivity(chosenIntent);


    }
}
