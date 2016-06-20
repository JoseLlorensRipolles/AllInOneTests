package com.example.josemanuel.centralicedtests;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.josemanuel.centralicedtests.adressBook.AdressBook;
import com.example.josemanuel.centralicedtests.euroToWorld.SpinnerTest;
import com.example.josemanuel.centralicedtests.ratioConverter.SliderTest;
import com.example.josemanuel.centralicedtests.reflexes.Reflexes;

public class MainActivity extends AppCompatActivity {

    Button sliderButton;
    Button spinnerButton;
    Button buttonAdressBook;
    Button reflexButton;
    EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sliderButton = (Button) findViewById(R.id.sliderButton);
        nameEditText = (EditText)findViewById(R.id.editText);
        spinnerButton = (Button)findViewById(R.id.spinnerTestButton);
        buttonAdressBook = (Button)findViewById(R.id.buttonAdressBook);
        reflexButton = (Button)findViewById(R.id.buttonReflexes);

        sliderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Creation of the intent
                Intent intent = new Intent(MainActivity.this,SliderTest.class);

                //Creation of the bundle to pass information
                Bundle b = new Bundle();

                //Put the information in bundle
                b.putString("NAME",nameEditText.getText().toString());

                intent.putExtras(b);

                startActivity(intent);
            }
        });

        spinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SpinnerTest.class);

                Bundle b = new Bundle();

                b.putString("NAME",nameEditText.getText().toString());

                intent.putExtras(b);

                startActivity(intent);
            }
        });

        buttonAdressBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdressBook.class);

                Bundle b = new Bundle();

                b.putString("NAME",nameEditText.getText().toString());

                intent.putExtras(b);

                startActivity(intent);
            }
        });

        reflexButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Reflexes.class);

                Bundle b = new Bundle();

                b.putString("NAME",nameEditText.getText().toString());

                intent.putExtras(b);

                startActivity(intent);
            }
        });

    }
}
