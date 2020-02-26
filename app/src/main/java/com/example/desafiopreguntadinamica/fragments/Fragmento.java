package com.example.desafiopreguntadinamica.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.desafiopreguntadinamica.R;
import com.example.desafiopreguntadinamica.tools.Quizzes;
import com.google.gson.Gson;

//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;

public class Fragmento extends Fragment /*implements Callback<Quizzes>*/ {

    private ImageView image;
    private TextView quest, categ, dific;
    private RadioButton rad1, rad2;
//    private RetrofitClient.OnRetroServicesListener service;
//    private Call<Quizzes> call;

    public Fragmento() {
        // Required empty public constructor
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        service = RetrofitClient.getInstance().create(RetrofitClient.OnRetroServicesListener.class);
//        call = service.listQuizz();
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        image = view.findViewById(R.id.fragImage);
        image.setImageResource(R.drawable.myrrh_great_dragon);
        quest = view.findViewById(R.id.question);
        categ = view.findViewById(R.id.cat);
        dific = view.findViewById(R.id.dificult);
        rad1 = view.findViewById(R.id.rb1);
        rad2 = view.findViewById(R.id.rb2);

        Quizzes quiz = new Gson().fromJson(getArguments().getString("response"), Quizzes.class);
        int index = (int)(Math.random()*quiz.getResults().size()-1);
        quest.setText(quiz.getResults().get(index).question);
        categ.setText(quiz.getResults().get(index).category);
        dific.setText(quiz.getResults().get(index).difficulty);
//        call.enqueue(this);

        return view;
    }
/*
    @Override
    public void onResponse(Call<Quizzes> call, Response<Quizzes> response) {
        if(response != null){
            Quizzes quiz = response.body();
            Log.i("Total", quiz.getResults().size()+"");
            int index = (int)(Math.random()*quiz.getResults().size()-1);
            quest.setText(quiz.getResults().get(index).question);
            categ.setText(quiz.getResults().get(index).category);
            dific.setText(quiz.getResults().get(index).difficulty);
        }
    }

    @Override
    public void onFailure(Call<Quizzes> call, Throwable t) {
        Toast.makeText(getActivity(), "Error, falla en la adquisicion de datos", Toast.LENGTH_SHORT).show();
    }
 */
}
