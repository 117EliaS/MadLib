package com.example.madlib;

import android.content.Intent;
import android.support.v4.text.HtmlCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
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


        name = "<font color='#EE0000'>" + name + "</font>";
        age = "<font color='#EE0000'>" + age + "</font>";
        verb1 = "<font color='#EE0000'>" + verb1 + "</font>";
        noun = "<font color='#EE0000'>" + noun + "</font>";
        verb2 = "<font color='#EE0000'>" + verb2 + "</font>";
        adj = "<font color='#EE0000'>" + adj + "</font>";

        //Experimental Code
        //name = "<b>" + name + "</b>";
        //Spanned nameHTML = HtmlCompat.fromHtml(name, HtmlCompat.FROM_HTML_MODE_COMPACT);

        String madLib = "There once was a person named " + name + ", who was " + age + " years old. "
                + name + " was " + verb1 + " one day when they saw a " + noun + " flying through the sky!"
                + " The " + noun + " came down and " + verb2 + ". " + name + " was so " + adj +". The End";

        TextView madLibText = (TextView) findViewById(R.id.textViewMadLib);



        madLibText.setText(Html.fromHtml(madLib));



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
