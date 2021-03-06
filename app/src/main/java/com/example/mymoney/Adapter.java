package com.example.mymoney;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter {

    /*
    어댑터의 동작원리 및 순서
    1.(getItemCount) 데이터 개수를 세어 어댑터가 만들어야 할 총 아이템 개수를 얻는다.
    2.(getItemViewType)[생략가능] 현재 itemview의 viewtype을 판단한다
    3.(onCreateViewHolder)viewtype에 맞는 뷰 홀더를 생성하여 onBindViewHolder에 전달한다.
    4.(onBindViewHolder)뷰홀더와 position을 받아 postion에 맞는 데이터를 뷰홀더의 뷰들에 바인딩한다.
    */
    String TAG = "RecyclerViewAdapter";

    //리사이클러뷰에 넣을 데이터 리스트
    ArrayList<DataModel> dataModels;
    Context context;

    //생성자를 통하여 데이터 리스트 context를 받음
    public Adapter(Context context, ArrayList<DataModel> dataModels){
        this.dataModels = dataModels;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        //데이터 리스트의 크기를 전달해주어야 함
        return dataModels.size();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG,"onCreateViewHolder");

        //자신이 만든 itemview를 inflate한 다음 뷰홀더 생성
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);


        //생선된 뷰홀더를 리턴하여 onBindViewHolder에 전달한다.
        return viewHolder;
    }




    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG,"onBindViewHolder");

        MyViewHolder myViewHolder = (MyViewHolder)holder;

        myViewHolder.list.setText(dataModels.get(position).getListmemo());
        myViewHolder.list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, position+"번째 텍스트 뷰 클릭", Toast.LENGTH_SHORT).show();
            }
        });
        myViewHolder.listmoney.setText(String.valueOf(dataModels.get(position).getListmoney()));
//        myViewHolder.imageView.setImageResource(dataModels.get(position).image_path);

    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView list, listmoney;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            list =  itemView.findViewById(R.id.list);
            listmoney = itemView.findViewById(R.id.listmoney);
        }
    }


}
