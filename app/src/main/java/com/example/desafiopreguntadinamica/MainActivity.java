package com.example.desafiopreguntadinamica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.desafiopreguntadinamica.fragments.HelloFragment;
import com.example.desafiopreguntadinamica.tools.Quizzes;
import com.example.desafiopreguntadinamica.tools.RetrofitClient;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<Quizzes> {

    private RetrofitClient.OnRetroServicesListener service;
    private Call<Quizzes> call;
    private Bundle bundle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service = RetrofitClient.getInstance().create(RetrofitClient.OnRetroServicesListener.class);
        call = service.listQuizz();
        call.enqueue(this);
        changeFragment(new HelloFragment());
    }

    public void changeFragment(Fragment fragment){
        if(bundle != null)
            fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frame, fragment).commit();
    }

    @Override
    public void onResponse(Call<Quizzes> call, Response<Quizzes> response) {
        if(response != null){
            Quizzes quiz = response.body();
            Log.i("Total", quiz.getResults().size()+"");
//            int index = (int)(Math.random()*quiz.getResults().size()-1);
            bundle = new Bundle();
            bundle.putString("response", new Gson().toJson(quiz));
        }
    }

    @Override
    public void onFailure(Call<Quizzes> call, Throwable t) {
        Toast.makeText(this, "Error, falla en la adquisicion de datos", Toast.LENGTH_SHORT).show();

    }
}
