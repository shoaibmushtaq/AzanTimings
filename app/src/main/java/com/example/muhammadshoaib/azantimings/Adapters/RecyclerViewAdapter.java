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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    //Declaring context and list
    private Context context;
    private List<AzanTimeModel> azanTimeModelList;
    private int format;

    //adapter constructer to get context and list from main activity
    public RecyclerViewAdapter(Context context, List<AzanTimeModel> azanTimeModelList, int format) {

        //intializing context and list and set it equal to the ones coming from main activity
        this.context = context;
        this.azanTimeModelList = azanTimeModelList;
        this.format = format;
    }

    //create view object and return it into myViewHolder class
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_row_layout, viewGroup, false);
        return new MyViewHolder(view);
    }



    //Bind data coming from list to recycler view
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {


        //this condition will check if the format value is 24, this code will convert 24 hour format into 12 hour format
        if (format == 12) {

            String fajar24Hour = azanTimeModelList.get(position).getFajr();
            DateFormat inFormat1 = new SimpleDateFormat("HH:mm");

            String zuhur24Hour = azanTimeModelList.get(position).getZuhr();
            DateFormat inFormat2 = new SimpleDateFormat("HH:mm");

            String asar24Hour = azanTimeModelList.get(position).getAsr();
            DateFormat inFormat3 = new SimpleDateFormat("HH:mm");

            String maghrib24Hour = azanTimeModelList.get(position).getMaghrib();
            DateFormat inFormat4 = new SimpleDateFormat("HH:mm");

            String isha24Hour = azanTimeModelList.get(position).getIsha();
            DateFormat inFormat5 = new SimpleDateFormat("HH:mm");

            DateFormat outFormat = new SimpleDateFormat("hh:mm");
            Date date1 = null;
            Date date2 = null;
            Date date3 = null;
            Date date4 = null;
            Date date5 = null;
            String myDate1=null;
            String myDate2=null;
            String myDate3 = null;
            String myDate4=null;
            String myDate5=null;
            try {
                date1 = inFormat1.parse(fajar24Hour);
                date2 = inFormat2.parse(zuhur24Hour);
                date3 = inFormat3.parse(asar24Hour);
                date4 = inFormat3.parse(maghrib24Hour);
                date5 = inFormat3.parse(isha24Hour);

            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (date1 != null) {
                myDate1 = outFormat.format(date1);
                myDate2 = outFormat.format(date2);
                myDate3 = outFormat.format(date3);
                myDate4 = outFormat.format(date4);
                myDate5 = outFormat.format(date5);

            }

            int serial_no = position + 1;
            viewHolder.id.setText(String.valueOf(serial_no));
            viewHolder.fajr.setText(myDate1);
            viewHolder.zuhr.setText(myDate2);
            viewHolder.asr.setText(myDate3);
            viewHolder.maghrib.setText(myDate4);
            viewHolder.isha.setText(myDate5);
        }


        //else it will set data in default format which is 24 hour
        else{

            int serial_no = position + 1;
            viewHolder.id.setText(String.valueOf(serial_no));
            viewHolder.fajr.setText(azanTimeModelList.get(position).getFajr());
            viewHolder.zuhr.setText(azanTimeModelList.get(position).getZuhr());
            viewHolder.asr.setText(azanTimeModelList.get(position).getAsr());
            viewHolder.maghrib.setText(azanTimeModelList.get(position).getMaghrib());
            viewHolder.isha.setText(azanTimeModelList.get(position).getIsha());
        }




}




    //return the size of list
    @Override
    public int getItemCount() {
        return azanTimeModelList.size();
    }




    //viewholder class to intialize items in recycler view layout
    class MyViewHolder extends RecyclerView.ViewHolder {

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

