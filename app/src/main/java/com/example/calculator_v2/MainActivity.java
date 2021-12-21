package com.example.calculator_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.Output;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView output;
    private Long firstArg, secondArg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.output);
    }
    public void processClick(View view) {
        String acc = null;
        Button button = (Button) view;
        String text = button.getText().toString();
        switch(text){
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                output.append(button.getText());
                break;
            case "+":
                acc = "+";
                setArg();
                break;
            case "-":
                acc = "-";
                setArg();
                break;
            case "/":
                acc = "/";
                setArg();
                break;
            case "*":
                acc = "*";
                setArg();
                break;
            case "=":
                secondArg = Long.parseLong(output.getText().toString());
                equal(acc, firstArg, secondArg);
                break;
        }
    }

    public void equal(String acc, Long firstArg, Long secondArg) {
        Long result = null;
        switch (acc){
            case "+":
                result = firstArg + secondArg;
                break;
            case "-":
                result = firstArg - secondArg;
                break;
            case "*":
                result = firstArg * secondArg;
                break;
            case "/":
                result = firstArg / secondArg;
                break;
        }
        if(result == null){
            output.setText("0");
        }else{
            output.setText(result.toString());
        }

    }

    public void setArg(){
        firstArg = Long.parseLong(output.getText().toString());
        output.setText("");
    }
}