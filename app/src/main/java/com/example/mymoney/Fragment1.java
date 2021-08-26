package com.example.mymoney;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//import androidx.core.app.Fragment;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.Date;


@RequiresApi(api = Build.VERSION_CODES.N)

public class Fragment1 extends Fragment {

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd");
    TextView nowdate;
    View view;
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
        // Inflate the layout for this fragment
        return view;
    }

}