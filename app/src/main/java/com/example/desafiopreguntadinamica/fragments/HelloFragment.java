package com.example.desafiopreguntadinamica.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.desafiopreguntadinamica.MainActivity;
import com.example.desafiopreguntadinamica.R;

import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 */
public class HelloFragment extends Fragment implements View.OnClickListener {

    private ImageView image;

//    public HelloFragment() {
//        // Required empty public constructor
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hello, container, false);
        image = view.findViewById(R.id.helloImage);
        image.setImageResource(R.drawable.myrrh_great_dragon);
        view.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        ((MainActivity)getActivity()).changeFragment(new Fragmento());
    }

}
