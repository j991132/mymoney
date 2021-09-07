package com.example.mymoney;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<String> arrayList;
public Adapter(){
    arrayList = new ArrayList<>();
}
    class ViewHolder extends RecyclerView.ViewHolder{
public TextView list, listmoney;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            list = itemView.findViewById(R.id.list);
            listmoney = itemView.findViewById(R.id.listmoney);
        }
    }

    @NonNull
//    @org.jetbrains.annotations.NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_list, parent, false);
//        RecyclerView.ViewHolder viewholder = new ViewHolder(context, view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
