package com.example.muhammadshoaib.azantimings.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.muhammadshoaib.azantimings.Activities.R;
import com.example.muhammadshoaib.azantimings.POJOClasses.AzanTimeModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    //Declaring context and list
    private Context context;
    private List<AzanTimeModel> azanTimeModelList;

    //adapter constructer to get context and list from main activity
    public RecyclerViewAdapter(Context context,List<AzanTimeModel> azanTimeModelList) {

        //intializing context and list and set it equal to the ones coming from main activity
        this.context = context;
        this.azanTimeModelList = azanTimeModelList;
    }

    //create view object and return it into myViewHolder class
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_row_layout,viewGroup,false);
        return new MyViewHolder(view);
    }


    //Bind data coming from list to recycler view
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {


        viewHolder.id.setText(""+ position);
        viewHolder.fajr.setText(azanTimeModelList.get(position).getFajr());
        viewHolder.zuhr.setText(azanTimeModelList.get(position).getZuhr());
        viewHolder.asr.setText(azanTimeModelList.get(position).getAsr());
        viewHolder.maghrib.setText(azanTimeModelList.get(position).getMaghrib());
        viewHolder.isha.setText(azanTimeModelList.get(position).getIsha());





    }


    //return the size of list
    @Override
    public int getItemCount() {
        return azanTimeModelList.size();
    }


    //viewholder class to intialize items in recycler view layout
    public class MyViewHolder extends RecyclerView.ViewHolder {

         TextView id, fajr, zuhr, asr, maghrib, isha;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id_textview);
            fajr = itemView.findViewById(R.id.fajar_time);
            zuhr = itemView.findViewById(R.id.zuhr_time);
            asr = itemView.findViewById(R.id.asr_time);
            maghrib = itemView.findViewById(R.id.maghrib_time);
            isha = itemView.findViewById(R.id.isha_time);


        }


    }
}



