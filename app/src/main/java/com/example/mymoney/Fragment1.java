package com.example.mymoney;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

//import androidx.core.app.Fragment;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


@RequiresApi(api = Build.VERSION_CODES.N)

public class Fragment1 extends Fragment {

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd");
    TextView nowdate;
    View view;
    ImageButton selectdate, income_btn, spend_btn;
    String[] items = {"오늘", "이번 주", "이번 달", "올해"};
    Dialog incomedialog, spenddialog;

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
        income_btn = (ImageButton)view.findViewById(R.id.income_btn);
        spend_btn = (ImageButton)view.findViewById(R.id.spend_btn);

        Calendar c=Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
//달력 다이얼로그
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
           nowdate.setText(year+"/"+(month+1)+"/"+dayOfMonth);
            }
        },mYear,mMonth,mDay);
//버튼

        selectdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectdate.isClickable()){
                    datePickerDialog.show();
                }
            }
        });
        income_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incomedialog = new Dialog(getContext());  //다이얼로그 초기화
                incomedialog.requestWindowFeature(Window.FEATURE_NO_TITLE);  //타이틀 제거
                incomedialog.setContentView(R.layout.incomedialog);  //xml 연결
                incomedialog.show();  //다이얼로그 띄우기
                //다이얼로그 안의 버튼 액션 넣기
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
//리사이클뷰
        Adapter listadapter;
        RecyclerView recyclerView;


        //데이터 모델리스트
        ArrayList<DataModel> dataModels = new ArrayList();

        dataModels.add(new DataModel("간식먹었다",50));
        dataModels.add(new DataModel("새벽공방 : 다섯밤",100));
        dataModels.add(new DataModel("폴킴 : 우리 만남이",150));
        dataModels.add(new DataModel("안녕하신가영 : 니가 좋아",200));
        dataModels.add(new DataModel("넬 : 멀어지다",250));
        dataModels.add(new DataModel("꽃잠프로젝트 : 그대는 어디 있나요",300));
        dataModels.add(new DataModel("검정치마 : 기다린 만큼 ,더",350));
        dataModels.add(new DataModel("어쿠루브 : 그게 뭐라고",400));
        dataModels.add(new DataModel("우효 : Grace",450));
        dataModels.add(new DataModel("브로콜리너마저 : 보편적인 노래",500));


        recyclerView = view.findViewById(R.id.recyceler_view);
        listadapter = new Adapter(getContext(),dataModels);
        recyclerView.setAdapter(listadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        // Inflate the layout for this fragment
        return view;
    }

}