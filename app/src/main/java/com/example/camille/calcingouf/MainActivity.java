package com.example.camille.calcingouf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button reset;
    private Button equal;
    private Button leave;

    private EditText value1;
    private EditText value2;

    private RadioGroup groupOpe;

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reset = findViewById(R.id.resetButton);
        equal = findViewById(R.id.equalButton);
        leave = findViewById(R.id.leaveButton);

        value1 = findViewById(R.id.enterValue);
        value2 = findViewById(R.id.enterValue2);

        groupOpe = findViewById(R.id.opeGroup);

        result = findViewById(R.id.textResult);

        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                value1.setText("");
                value2.setText("");
            }
        });

        leave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int selectedId = groupOpe.getCheckedRadioButtonId();
                if(selectedId == -1)
                    return;

                // find the radiobutton by returned id
                RadioButton radioButton = findViewById(selectedId);
                String ope =  radioButton.getText().toString();
                String v1 = value1.getText().toString();
                String v2  = value2.getText().toString();
                if(!v1.equals("") && !v2.equals("")) {
                    switch (ope) {
                        case "plus":
                            plus(v1,v2);
                            break;
                        case "minus":
                            minus(v1,v2);
                            break;
                        case "times":
                            times(v1,v2);
                            break;
                        case "divide":
                            divide(v1,v2);
                            break;
                        default:
                            break;
                    }
                }
            }
        });
    }

    private void plus(String value1, String value2)
    {
        int v1 = Integer.valueOf(value1);
        int v2 = Integer.valueOf(value2);
        int val = v1+v2;
        result.setText(""+val);
    }

    private void minus(String value1, String value2)
    {
        int v1 = Integer.valueOf(value1);
        int v2 = Integer.valueOf(value2);
        int val = v1-v2;
        result.setText(""+val);
    }

    private void times(String value1, String value2)
    {
        int v1 = Integer.valueOf(value1);
        int v2 = Integer.valueOf(value2);
        int val = v1*v2;
        result.setText(""+val);
    }

    private void divide(String value1, String value2)
    {
        int v1 = Integer.valueOf(value1);
        int v2 = Integer.valueOf(value2);
        if(v2 != 0)
        {
            int val = v1/v2;
            result.setText("" + val);
        }
        else
            Toast.makeText(MainActivity.this,"Can't divide by 0",Toast.LENGTH_SHORT).show();
    }
}
