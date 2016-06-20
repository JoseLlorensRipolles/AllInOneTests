package com.example.josemanuel.centralicedtests.ratioConverter;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.josemanuel.centralicedtests.R;

import java.text.DecimalFormat;

public class SliderTest extends AppCompatActivity {

    TextView wellcomeText;
    TextView ratioTxt;
    SeekBar slider;
    TextInputLayout textInputLayout;
    EditText inputText;
    RadioButton radioButtonAdd;
    RadioButton radioButtonMult;
    RadioButton radioButtonDiv;
    RadioGroup radioGroupOperation;
    CheckBox checkBoxInvertRatio;
    TextView numberConvertedText;
    TextInputEditText inputEditText;
    DecimalFormat decimalformatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_test);

        //Intantiation of variables
        wellcomeText = (TextView) findViewById(R.id.wellcomeTxt);
        slider = (SeekBar) findViewById(R.id.slider);
        ratioTxt = (TextView) findViewById(R.id.ratioTxt);
        inputText = (EditText) findViewById(R.id.EditTextNumberToConvert);
        inputEditText =  (TextInputEditText)findViewById(R.id.EditTextNumberToConvert);
        radioButtonAdd = (RadioButton) findViewById(R.id.radioButtonAdd);
        radioButtonMult = (RadioButton) findViewById(R.id.radioButtonMultiply);
        radioButtonDiv = (RadioButton) findViewById(R.id.radioButtonDivide);
        radioGroupOperation = (RadioGroup) findViewById(R.id.radioGroupOperationType);
        checkBoxInvertRatio = (CheckBox) findViewById(R.id.checkBoxNegativeRatio);
        numberConvertedText = (TextView) findViewById(R.id.numberConvertedTxt);
        textInputLayout = (TextInputLayout)findViewById(R.id.TiLayout);
        decimalformatter = new DecimalFormat("#.##");



        textInputLayout.setErrorEnabled(true);



        //Geting the bundle passed from main activity
        Bundle b = this.getIntent().getExtras();

        //Setting wellcome label with info provided by bundle
        wellcomeText.setText("Wellcome " + b.get("NAME"));

        //Setting add radiobuttion to checked
        radioButtonAdd.setChecked(true);

        //Setting max value of slider to 20
        slider.setMax(20);


        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ratioTxt.setText("Ratio: " + progress);
                update();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        inputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                update();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        radioGroupOperation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                update();
            }
        });

        checkBoxInvertRatio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBoxInvertRatio.isChecked()){
                    textInputLayout.setError("Ratio inverted");

                }else{
                    textInputLayout.setError(null);
                }
                update();
            }
        });

    }

    public void update() {

        try {
            double value = Integer.parseInt(inputText.getText().toString());
            int ratio = slider.getProgress();
            inputEditText.setError(null);
            if (checkBoxInvertRatio.isChecked()) {
                ratio = ratio * -1;
            }
            double res = 0.0;
            switch (radioGroupOperation.getCheckedRadioButtonId()) {

                case R.id.radioButtonAdd:
                    res = value + ratio;
                    numberConvertedText.setText("Number converted:" + " " + res);
                    break;

                case R.id.radioButtonDivide:
                    if (ratio != 0) {
                        res = value / ratio;
                        String aux = decimalformatter.format(res);
                        numberConvertedText.setText("Number converted:" + " " + aux);
                    }
                    break;

                case R.id.radioButtonMultiply:
                    res = value * ratio;
                    numberConvertedText.setText("Number converted:" + " " + res);
                    break;
            }
        }catch (Exception e){
            inputEditText.setError("Must input a valid number");
        }

    }

}
