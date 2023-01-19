package com.example.lightweight;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Random;

public class HomeFragment extends Fragment {

    TextView welcome_text;
    LinearLayout chest_day;
    LinearLayout back_biceps_day;
    LinearLayout shoulder_triceps_day;

    int maxRandWelcomeText = 4;
    int minRandWelcomeText = 1;


    public HomeFragment() {

    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    private void getRandomWelcomeText() {

        int welcomeTextRandNum = new Random().nextInt(maxRandWelcomeText - minRandWelcomeText + 1) + minRandWelcomeText;

        if (welcomeTextRandNum == 1) {
            welcome_text.setText("Hello King! 👑");
        }
        if (welcomeTextRandNum == 2) {
            welcome_text.setText("Yeah Buddy!");
        }
        if (welcomeTextRandNum == 3) {
            welcome_text.setText("Lightweight, Babe!!!");
        }
        if (welcomeTextRandNum == 4) {
            welcome_text.setText("Nice to see you again, Chad.");
        }

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        welcome_text = view.findViewById(R.id.welcome_text);
        chest_day = view.findViewById(R.id.chest_day);
        back_biceps_day = view.findViewById(R.id.back_biceps_day);
        shoulder_triceps_day = view.findViewById(R.id.shoulder_triceps_day);

        getRandomWelcomeText();
    }
}