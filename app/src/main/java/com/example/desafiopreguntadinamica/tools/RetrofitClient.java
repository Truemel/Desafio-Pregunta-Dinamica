package com.example.desafiopreguntadinamica.tools;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class RetrofitClient {

//    private OnRetroServicesListener onRetro;
    private static Retrofit retro;
    private static final String PATH = "https://opentdb.com/";

//    private RetrofitClient(OnRetroServicesListener onRetro){
//        this.onRetro = onRetro;
//    }

    public static Retrofit getInstance(){
        if(retro == null)
            retro = new Retrofit.Builder().baseUrl(PATH).addConverterFactory(GsonConverterFactory.create()).build();
        return retro;
    }

    public static interface OnRetroServicesListener{
        @POST("api.php?amount=1&category=18&difficulty=medium&type=boolean")
        public Call<Quizzes> listQuizz();
    }
}
