package com.example.lightweight;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PassFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PassFragment extends Fragment {

    TextView textDateToday;
    TextView textDatePassExpires;
    AppCompatButton btnPassBought;
    AppCompatButton btnSetDateExpires;
    DatePickerDialog datePickerDialog;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PassFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RentalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PassFragment newInstance(String param1, String param2) {
        PassFragment fragment = new PassFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pass, container, false);

        textDateToday = view.findViewById(R.id.textDateToday);
        textDatePassExpires = view.findViewById(R.id.textDatePassExpires);
        btnPassBought = view.findViewById(R.id.btnPassBought);
        btnSetDateExpires = view.findViewById(R.id.btnSetDateExpires);

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. MM. dd.");
        String formattedCurrentDate = currentDate.format(formatter);
        textDateToday.setText(formattedCurrentDate);

        btnPassBought.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocalDate today = LocalDate.now();
                LocalDate futureDate = today.plusDays(30);
                String formattedFutureDate = futureDate.format(formatter);
                textDatePassExpires.setText(String.valueOf(formattedFutureDate));
            }

        });

        initDatePicker();

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("textDatePassExpires", textDatePassExpires.getText().toString());
        editor.apply();
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
        String textDatePassExpiresValue = prefs.getString("textDatePassExpires", "");
        textDatePassExpires.setText(textDatePassExpiresValue);
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);
            }
        };
    }

    private String makeDateString(int day, int month, int year) {
        return getMonthFormat(month) + ". " + day + ". " + year + ".";
    }

    private String getMonthFormat(int month)
    {
        if (month == 1) return "JAN";
        if (month == 2) return "FEB";

        return "JAN";
    }

    public void openDatePicker(View view) {

    }
}
