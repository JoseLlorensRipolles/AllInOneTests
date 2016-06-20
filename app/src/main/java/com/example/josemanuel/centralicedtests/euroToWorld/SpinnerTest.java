package com.example.josemanuel.centralicedtests.euroToWorld;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.josemanuel.centralicedtests.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by JoseManuel on 13/06/2016.
 */
public class SpinnerTest extends AppCompatActivity {

    String[] data;
    TextInputLayout textInputLayout;
    TextInputEditText textInputEditText;
    Spinner spinner;
    ImageView currencyImageSpinner;
    ImageView currencyImageToConvert;
    TextView currentAmountToConvert;
    TextView currentAmountConverted;

    double euro_dollar, euro_pound, euro_yen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_test);

        spinner = (Spinner)findViewById(R.id.currencySpinner);
        textInputLayout = (TextInputLayout)findViewById(R.id.TiLayout);
        textInputEditText = (TextInputEditText)findViewById(R.id.TextInputTextEditCunrrency);
        currencyImageSpinner = (ImageView)findViewById(R.id.convertedCurrencyImageSpinner);
        currencyImageToConvert = (ImageView)findViewById(R.id.convertedCurrencyImage);
        currentAmountToConvert = (TextView)findViewById(R.id.toConvertCurrencyTextView);
        currentAmountConverted =  (TextView)findViewById(R.id.cenvertedCurrencyTextView);
        euro_dollar = 1.13;
        euro_pound = 0.79;
        euro_yen = 119.83;


        data = new String[]{"Euro","Dolar","Yen","Pound"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_spinner_item,data);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(adapter);
        spinner.setSelection(1);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               updateIcons();
                updateTextsViews();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        textInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateTextsViews();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void updateTextsViews() {
        try {
            DecimalFormat decimalFormatter = new DecimalFormat("#.##");
            currentAmountToConvert.setText(textInputEditText.getText());
            double convertedAmount = Double.parseDouble(textInputEditText.getText().toString());
            String currencyToConvert = spinner.getSelectedItem().toString();
            switch (currencyToConvert) {
                case "Euro":
                    break;
                case "Dolar":
                    convertedAmount = convertedAmount * euro_dollar;
                    break;
                case "Yen":
                    convertedAmount = convertedAmount * euro_yen;
                    break;
                case "Pound":
                    convertedAmount = convertedAmount * euro_pound;
                    break;
            }

            currentAmountConverted.setText(decimalFormatter.format(convertedAmount));
        }catch (NumberFormatException e){
            currentAmountConverted.setText("");
        }
    }

    private void updateIcons(){
        String currencyToConvert = spinner.getSelectedItem().toString();
        switch (currencyToConvert){
            case "Euro":
                currencyImageSpinner.setImageResource(R.drawable.euro);
                currencyImageToConvert.setImageResource(R.drawable.euro);
                break;
            case "Dolar":
                currencyImageSpinner.setImageResource(R.drawable.dollar);
                currencyImageToConvert.setImageResource(R.drawable.dollar);
                break;
            case "Yen":
                currencyImageSpinner.setImageResource(R.drawable.yen);
                currencyImageToConvert.setImageResource(R.drawable.yen);
                break;
            case "Pound":
                currencyImageSpinner.setImageResource(R.drawable.pound);
                currencyImageToConvert.setImageResource(R.drawable.pound);
                break;
        }
    }
}
