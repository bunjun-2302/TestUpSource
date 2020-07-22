package com.example.musicbyjun.Service;

public class APIService {
    private static String BASE_URL = "https://musicbyjun.000webhostapp.com/Server/";
    public static Dataservice getService(){
        return APIRetrofitClient.getClient(BASE_URL).create(Dataservice.class);
    }
}
