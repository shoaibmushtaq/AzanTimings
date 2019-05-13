package com.example.muhammadshoaib.azantimings.POJOClasses;

import com.google.gson.annotations.SerializedName;

public class AzanTimeModel {

    //fields which will come from Api

    @SerializedName("Fajr")
    private String fajr;

    @SerializedName("Zhuhr")
    private String zuhr;

    @SerializedName("Asr")
    private String asr;

    @SerializedName("Maghrib")
    private String maghrib;

    @SerializedName("Isha")
    private String isha;




    public String getFajr() {
        return fajr;
    }

    public String getZuhr() {
        return zuhr;
    }

    public String getAsr() {
        return asr;
    }

    public String getMaghrib() {
        return maghrib;
    }

    public String getIsha() {
        return isha;
    }
}
