package com.example.mymoney;

import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

//import androidx.core.app.Fragment;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.Calendar;
import java.util.Date;


@RequiresApi(api = Build.VERSION_CODES.N)

public class Fragment1 extends Fragment {

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd");
    TextView nowdate;
    View view;
    ImageButton selectdate;
    String[] items = {"오늘", "이번 주", "이번 달", "올해"};

    private String getDate() {
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_1, container, false);

        nowdate = (TextView) view.findViewById(R.id.nowdate);
        nowdate.setText(getDate());
        selectdate =(ImageButton)view.findViewById(R.id.selectdate_btn);

        Calendar c=Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
           nowdate.setText(year+"/"+(month+1)+"/"+dayOfMonth);
            }
        },mYear,mMonth,mDay);

        selectdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectdate.isClickable()){
                    datePickerDialog.show();
                }
            }
        });

//        스피너
        Spinner spinner = view.findViewById(R.id.period_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //셀렉트시 행동 items[position]
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}