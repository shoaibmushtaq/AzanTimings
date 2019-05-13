package com.example.muhammadshoaib.azantimings.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.muhammadshoaib.azantimings.Adapters.RecyclerViewAdapter;
import com.example.muhammadshoaib.azantimings.POJOClasses.AzanTimeModel;
import com.example.muhammadshoaib.azantimings.Retrofit.RetrofitApiClient;
import com.example.muhammadshoaib.azantimings.Retrofit.RetrofitApiInterface;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing recycler view and layout manager and set layout manager in recycler view
        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        //creating retrofit api instance
        retrofitApiInterface = RetrofitApiClient.getApiClient().create(RetrofitApiInterface.class);

        //make api call and return the response in call object
        retrofit2.Call<List<AzanTimeModel>> apiCall = retrofitApiInterface.getAzanTimings();

        apiCall.enqueue(new Callback<List<AzanTimeModel>>() {
            @Override
            public void onResponse(retrofit2.Call<List<AzanTimeModel>> call, Response<List<AzanTimeModel>> response) {


                //stores the response data in list and adapter for recycler view and pass the list
                azanTimeModelList = response.body();
                recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,azanTimeModelList);
                recyclerView.setAdapter(recyclerViewAdapter);

            }

            @Override
            public void onFailure(retrofit2.Call<List<AzanTimeModel>> call, Throwable t) {

            }
        });




    }
}
