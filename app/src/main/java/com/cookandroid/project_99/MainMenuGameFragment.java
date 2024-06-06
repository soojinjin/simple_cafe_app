package com.cookandroid.project_99;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;//GAME 눌렀을때
import android.widget.Button;

public class MainMenuGameFragment extends Fragment {
    private Button buttonStartGame;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main_menu_game,
                container, false);
        buttonStartGame = (Button) rootView.findViewById(R.id.button_start_game);

        buttonStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Puzzlegame.class);
                startActivity(intent);
            }
        });

        return rootView;
    }


}





