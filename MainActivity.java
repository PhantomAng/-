package com.example.logvi.myapplication;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText in;
    TextView out;
    Button button, res;
    protected int number;
    protected int randNum;
    protected Random rand = new Random();
    protected int trying = 7;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        randNum = rand.nextInt(51) + 1;
        setContentView(R.layout.activity_main);
        in = findViewById(R.id.Input);
        out = findViewById(R.id.outPut);
        button = findViewById(R.id.InBitton);
        res = findViewById(R.id.reset);
        out.setText("Ваша задача угадать число в диапозоне от 1 до 50. На это у вас есть 7 попыток");
        res.setEnabled(false);
        in.setText("");
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
               number = Integer.parseInt(in.getText().toString());
                if(number == randNum){
                    res.setEnabled(true);
                    button.setEnabled(false);
                    out.setText("Вы угадали. Поздравляю!");
                }
                if(number != randNum){
                    if(number < randNum){
                        if(trying == 0){
                            out.setText("У вас осталось 0 попыток. К сожелению вы проиграли!");
                            button.setEnabled(false);
                            res.setEnabled(true);
                        }
                        else{
                            trying--;
                            out.setText("Ваше число меньше загадоного. У вас осталось: " + trying + " попыток!");
                            in.setText("");
                        }
                    }
                    else{
                        if(trying == 0){
                            button.setEnabled(false);
                            res.setEnabled(true);
                            out.setText("У вас осталось 0 попыток. К сожелению вы проиграли!");
                        }
                        else{
                            trying--;
                            out.setText("Ваше число больше загадоного. У вас осталось " + trying + " попыток!");
                            in.setText("");

                        }
                    }
                }
            }
        });
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trying = 7;
                randNum = rand.nextInt(51) + 1;
                button.setEnabled(true);
                res.setEnabled(false);
                out.setText("Ваша задача угадать число в диапозоне от 1 до 50. На это у вас есть 7 попыток");
                in.setText("");
            }
        });

    }
}
