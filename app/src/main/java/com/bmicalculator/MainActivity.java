package com.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText height,weight;
    Button calculate;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height=findViewById(R.id.et_height);
        weight=findViewById(R.id.et_weight);
        calculate=findViewById(R.id.btn_calculate);
        result=findViewById(R.id.tv_result);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double height_in_centimeter=Double.parseDouble(height.getText().toString())*0.01;
                Double weight_in_kilogram=Double.parseDouble(weight.getText().toString());

                Double height_in_metersquare=height_in_centimeter*2;
                Double BMI=weight_in_kilogram/height_in_metersquare;
                result.setText("Your BMI is"+BMI.toString());

                if (BMI<18.9){
                    Toast.makeText(MainActivity.this, "You are UnderWeight", Toast.LENGTH_SHORT).show();
                }
                else if (BMI>18.9 && BMI<24.9){
                    Toast.makeText(MainActivity.this, "Your weight is Normal", Toast.LENGTH_SHORT).show();
                }

                else if (BMI>25 && BMI<29.9){
                    Toast.makeText(MainActivity.this, "You are overweight", Toast.LENGTH_SHORT).show();
                }

                else if (BMI>30){
                    Toast.makeText(MainActivity.this, "Your weight is obesity", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
