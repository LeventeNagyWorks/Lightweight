package com.example.lightweight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView welcome_text;

    int maxRandWelcomeText = 4;
    int minRandWelcomeText = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome_text = findViewById(R.id.welcome_text);

        getRandomWelcomeText();



    }

    private void getRandomWelcomeText() {

        int welcomeTextRandNum = new Random().nextInt(maxRandWelcomeText - minRandWelcomeText + 1) + minRandWelcomeText;

        if (welcomeTextRandNum == 1) {
            welcome_text.setText("Hello King!");
        }
        if (welcomeTextRandNum == 2) {
            welcome_text.setText("Yeah Buddy!");
        }
        if (welcomeTextRandNum == 3) {
            welcome_text.setText("Lightweight!!!");
        }
        if (welcomeTextRandNum == 4) {
            welcome_text.setText("Nice to see you again, Chad.");
        }

    }
}