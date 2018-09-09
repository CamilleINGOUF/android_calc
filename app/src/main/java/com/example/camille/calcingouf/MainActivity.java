package com.example.camille.calcingouf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private Button reset;
    private Button equal;
    private Button leave;

    private EditText value1;
    private EditText value2;

    private RadioButton plus;
    private RadioButton minus;
    private RadioButton times;
    private RadioButton divide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reset = findViewById(R.id.resetButton);
        equal = findViewById(R.id.equalButton);
        leave = findViewById(R.id.leaveButton);

        value1 = findViewById(R.id.enterValue);
        value2 = findViewById(R.id.enterValue2);

        plus = findViewById(R.id.plusButton);
        minus = findViewById(R.id.minusButton);
        times = findViewById(R.id.timesButton);
        divide = findViewById(R.id.divideButton);

        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                value1.setText("");
                value2.setText("");
            }
        });
    }


}
