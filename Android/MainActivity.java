package com.codecademy.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText firstnumber = findViewById(R.id.number1);
        final EditText secondnumber = findViewById(R.id.number2);
        final RadioGroup opreators = findViewById(R.id.operators);
        final RadioButton add = findViewById(R.id.add);
        final RadioButton multiply = findViewById(R.id.multiply);
        final RadioButton subtract = findViewById(R.id.subtract);
        final Button equals = findViewById(R.id.equals);
        final TextView result = findViewById(R.id.result);

        equals.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final int firstNumberValue = Integer.parseInt(firstnumber.getText().toString());
                final int secondNumberValue = Integer.parseInt(secondnumber.getText().toString());

                final int operatorButtonId = opreators.getCheckedRadioButtonId();

                Integer answer;

                if(operatorButtonId == add.getId()) {
                    answer = firstNumberValue + secondNumberValue;
                } else if (operatorButtonId == subtract.getId()) {
                    answer = firstNumberValue - secondNumberValue;
                } else if (operatorButtonId == multiply.getId()) {
                    answer = firstNumberValue * secondNumberValue;
                }else {
                    answer = firstNumberValue / secondNumberValue;
                }


                result.setText(answer.toString());
            }
        });



    }
}