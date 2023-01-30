package com.example.lightweight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lightweight.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

//    TextView welcome_text;
    LinearLayout chest_day_button;
//    LinearLayout back_biceps_day_button;
//    LinearLayout shoulder_triceps_day_button;
//
    BottomNavigationView topNavigatonView;
//
//    int maxRandWelcomeText = 4;
//    int minRandWelcomeText = 1;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

//        welcome_text = findViewById(R.id.welcome_text);
        chest_day_button = findViewById(R.id.chest_day_button);
//        back_biceps_day_button = findViewById(R.id.back_biceps_day_button);
//        shoulder_triceps_day_button = findViewById(R.id.back_biceps_day_button);
//
//        getRandomWelcomeText();

        topNavigatonView = findViewById(R.id.topNavigatonView);
        topNavigatonView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;

                case R.id.pass:
                    replaceFragment(new PassFragment());
                    break;

            }

            return true;
        });


        chest_day_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChestDayActivity.class);
                startActivity(intent);
            }
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }


//    private void getRandomWelcomeText() {
//
//        int welcomeTextRandNum = new Random().nextInt(maxRandWelcomeText - minRandWelcomeText + 1) + minRandWelcomeText;
//
//        if (welcomeTextRandNum == 1) {
//            welcome_text.setText("Hello King! 👑");
//        }
//        if (welcomeTextRandNum == 2) {
//            welcome_text.setText("Yeah Buddy!");
//        }
//        if (welcomeTextRandNum == 3) {
//            welcome_text.setText("Lightweight, Babe!!!");
//        }
//        if (welcomeTextRandNum == 4) {
//            welcome_text.setText("Nice to see you again, Chad.");
//        }
//
//    }

}