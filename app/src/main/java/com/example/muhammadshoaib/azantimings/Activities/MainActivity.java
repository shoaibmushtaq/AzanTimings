package com.example.muhammadshoaib.azantimings.Activities;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.muhammadshoaib.azantimings.Adapters.RecyclerViewAdapter;
import com.example.muhammadshoaib.azantimings.POJOClasses.AzanTimeModel;
import com.example.muhammadshoaib.azantimings.Retrofit.RetrofitApiClient;
import com.example.muhammadshoaib.azantimings.Retrofit.RetrofitApiInterface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    //declaring nneded objects
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<AzanTimeModel> azanTimeModelList;
    private RetrofitApiInterface retrofitApiInterface;
    private RecyclerViewAdapter recyclerViewAdapter;
    private int format;
    private String FORMAT_KEY = "format_key";

    //declaring alrm button
    private Button alarmButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing recycler view and layout manager and set layout manager in recycler view
        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        //initializing alarm button instance
        alarmButton = findViewById(R.id.alarm_button);

        //creating retrofit api instance
        retrofitApiInterface = RetrofitApiClient.getApiClient().create(RetrofitApiInterface.class);


        //getting time format value from intent
        final Intent intent = getIntent();
        format = intent.getIntExtra(FORMAT_KEY, 24);

        //calling fetchData() method
        fetchData(format);


        //set onclick listener for alarm button
        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //getting first row of data from arraylist
                AzanTimeModel firstElement = null;
                if (!azanTimeModelList.isEmpty() && azanTimeModelList.size() > 0) {
                    firstElement = azanTimeModelList.get(0);
                }
                //save fajr time in string
                String fajrAlarmTime = firstElement.getFajr();

                //Declaring hour and minute varriables
                String fajarHourOfTheDay = null;
                String fajarMinOfTheDay = null;

                //split the time varriable and get hour and minute
                String[] fajarTimehour = fajrAlarmTime.split("\\:");
                for (int i = 0; i < fajarTimehour.length; i++) {

                    fajarHourOfTheDay = fajarTimehour[0];
                    fajarMinOfTheDay = fajarTimehour[1];
                }

                //initializing calender instance and set the hour and minute
                Calendar calendar1 = Calendar.getInstance();
                calendar1.setTimeInMillis(System.currentTimeMillis());
                calendar1.set(

                        calendar1.get(Calendar.YEAR),
                        calendar1.get(Calendar.MONTH),
                        calendar1.get(Calendar.DAY_OF_MONTH),
                        Integer.parseInt(fajarHourOfTheDay),
                        Integer.parseInt(fajarMinOfTheDay),
                        0
                );


                //save zuhar tim in string
                String zuharAlarmTime = firstElement.getZuhr();

                //Declaring hour and minute varriables
                String zuharHourOfTheDay = null;
                String zuharMinOfTheDay = null;

                //split the time varriable and get hour and minute
                String[] zuharTimehour = zuharAlarmTime.split("\\:");
                for (int i = 0; i < zuharTimehour.length; i++) {

                    zuharHourOfTheDay = zuharTimehour[0];
                    zuharMinOfTheDay = zuharTimehour[1];
                }

                //initializing calender instance and set the hour and minute
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTimeInMillis(System.currentTimeMillis());
                calendar2.set(

                        calendar2.get(Calendar.YEAR),
                        calendar2.get(Calendar.MONTH),
                        calendar2.get(Calendar.DAY_OF_MONTH),
                        Integer.parseInt(zuharHourOfTheDay),
                        Integer.parseInt(zuharMinOfTheDay),
                        0
                );


                //save asar tim in string
                String asarAlarmTime = firstElement.getAsr();

                //Declaring hour and minute varriables
                String asarHourOfTheDay = null;
                String asarMinOfTheDay = null;

                //split the time varriable and get hour and minute
                String[] asarTimehour = asarAlarmTime.split("\\:");
                for (int i = 0; i < asarTimehour.length; i++) {

                    asarHourOfTheDay = asarTimehour[0];
                    asarMinOfTheDay = asarTimehour[1];
                }

                //initializing calender instance and set the hour and minute
                Calendar calendar3 = Calendar.getInstance();
                calendar3.setTimeInMillis(System.currentTimeMillis());
                calendar3.set(

                        calendar3.get(Calendar.YEAR),
                        calendar3.get(Calendar.MONTH),
                        calendar3.get(Calendar.DAY_OF_MONTH),
                        Integer.parseInt(asarHourOfTheDay),
                        Integer.parseInt(asarMinOfTheDay),
                        0
                );

                //save maghrib time in string
                String maghribAlarmTime = firstElement.getMaghrib();

                //Declaring hour and minute varriables
                String maghribHourOfTheDay = null;
                String maghribMinOfTheDay = null;

                //split the time varriable and get hour and minute
                String[] maghribTimehour = maghribAlarmTime.split("\\:");
                for (int i = 0; i < maghribTimehour.length; i++) {

                    maghribHourOfTheDay = maghribTimehour[0];
                    maghribMinOfTheDay = maghribTimehour[1];
                }

                //initializing calender instance and set the hour and minute
                Calendar calendar4 = Calendar.getInstance();
                calendar4.setTimeInMillis(System.currentTimeMillis());
                calendar4.set(

                        calendar4.get(Calendar.YEAR),
                        calendar4.get(Calendar.MONTH),
                        calendar4.get(Calendar.DAY_OF_MONTH),
                        Integer.parseInt(maghribHourOfTheDay),
                        Integer.parseInt(maghribMinOfTheDay),
                        0
                );


                //save isha time in string
                String ishaAlarmTime = firstElement.getIsha();

                //Declaring hour and minute varriables
                String ishaHourOfTheDay = null;
                String ishaMinOfTheDay = null;

                //split the time varriable and get hour and minute
                String[] ishaTimehour = ishaAlarmTime.split("\\:");
                for (int i = 0; i < ishaTimehour.length; i++) {

                    ishaHourOfTheDay = ishaTimehour[0];
                    ishaMinOfTheDay = ishaTimehour[1];
                }

                //initializing calender instance and set the hour and minute
                Calendar calendar5 = Calendar.getInstance();
                calendar5.setTimeInMillis(System.currentTimeMillis());
                calendar5.set(

                        calendar5.get(Calendar.YEAR),
                        calendar5.get(Calendar.MONTH),
                        calendar5.get(Calendar.DAY_OF_MONTH),
                        Integer.parseInt(ishaHourOfTheDay),
                        Integer.parseInt(ishaMinOfTheDay),
                        0
                );

                //Adding all calender instances in arraylist
                ArrayList<Calendar> timeInMillis = new ArrayList<>();
                timeInMillis.add(calendar1);
                timeInMillis.add(calendar2);
                timeInMillis.add(calendar3);
                timeInMillis.add(calendar4);
                timeInMillis.add(calendar5);

                //calling setAlarm method
                setAlarm(timeInMillis);


            }
        });

    }

    //this method will accept time format as argument and fetch the data from api
    private void fetchData(final int format) {

        //make api call and return the response in call object
        retrofit2.Call<List<AzanTimeModel>> apiCall = retrofitApiInterface.getAzanTimings();

        apiCall.enqueue(new Callback<List<AzanTimeModel>>() {
            @Override
            public void onResponse(retrofit2.Call<List<AzanTimeModel>> call, Response<List<AzanTimeModel>> response) {
                //stores the response data in list and adapter for recycler view and pass the list
                azanTimeModelList = response.body();
                recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, azanTimeModelList, format);
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(retrofit2.Call<List<AzanTimeModel>> call, Throwable t) {
            }
        });
    }

    //this method gets arraylist of calender instances and set alarm
    private void setAlarm(ArrayList<Calendar> timeInMillis) {

        //arraylist to put all pendingInent
        ArrayList<PendingIntent> pendingIntentArrayList = new ArrayList<PendingIntent>();

        //time varriable to store alarm time
        Long time = null;

        //day varriable to check whether the alarm is for today or tommorow
        String currentDay=null;

        //declaring and initializing Alarm manager instance
        AlarmManager[] alarmManagers = new AlarmManager[timeInMillis.size()];

        //Declaring and initializing Intent object
        Intent intents[] = new Intent[alarmManagers.length];

        //loop is used to set multiple alarm
        for (int i = 0; i < alarmManagers.length; i++) {

            //intializing intent array
            intents[i] = new Intent(MainActivity.this, MyAlarm.class);
            intents[i].putExtra("AZAN_ID",i);

            //initializing pending intent and pass i as request code which will increament by 1
            PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), i, intents[i], 0);

            //initializing alarm manager object array
            alarmManagers[i] = (AlarmManager) getApplicationContext().getSystemService(ALARM_SERVICE);

            //to check if the given alarm time is not past it will set alarm for today
            if (System.currentTimeMillis() < timeInMillis.get(i).getTimeInMillis()) {

                //and initialize the varriable to given time
                time = timeInMillis.get(i).getTimeInMillis();

                //and set the currentDay String to "today"
                currentDay = "today";
            }

            //otherwise if the given alarm time is past it will set alarm for tommorow
           else{

                //and initialize the "time" varriable to given time + interval
                time = timeInMillis.get(i).getTimeInMillis() + AlarmManager.INTERVAL_DAY;

                //and set the currentDay String to "tommorow"
                currentDay = "tommorow";
            }

            //set the repeating alarm based on loop position
            alarmManagers[i].setRepeating(AlarmManager.RTC_WAKEUP, time,AlarmManager.INTERVAL_DAY, pendingIntent);

            //it will show the mesage that alarm is set and pecify the alarm poistion
            Toast.makeText(this, "alarm "+(i+1)+" is set for "+currentDay, Toast.LENGTH_LONG).show();

        }

    }
}