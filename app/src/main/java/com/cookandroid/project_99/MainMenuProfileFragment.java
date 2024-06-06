package com.cookandroid.project_99;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainMenuProfileFragment extends Fragment {
    // 이름, 아이디, 이메일, 성별, 나이 표시해주기
    private TextView userName;
    private TextView userName2;
    private TextView userId;
    private TextView userEmail;
    private TextView userGender;
    private TextView userYears;
    private TextView logout;
    private UserDBHelper dbHelper;
    private preferenceManager pManager;

    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_menu_profile, container, false);

        pManager = new preferenceManager();
        userName = view.findViewById(R.id.usernameTv);
        userName2 = view.findViewById(R.id.usernameTv2);
        userId = view.findViewById(R.id.useridTv);
        userEmail = view.findViewById(R.id.useremailTv);
        userGender = view.findViewById(R.id.usergenderTv);
        userYears = view.findViewById(R.id.useryearsTv);
        logout = view.findViewById(R.id.logoutTv);

        dbHelper = UserDBHelper.getInstance(getContext());
        ArrayList<UserBean> userArr = dbHelper.getUserById(pManager.getString(getContext(), "user_id"));

        userName.setText(userArr.get(0).getName());
        userName2.setText(userArr.get(0).getName());
        userId.setText(userArr.get(0).getId());
        userEmail.setText(userArr.get(0).getEmail());
        userGender.setText(userArr.get(0).getGender());
        userYears.setText(userArr.get(0).getYears());

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        // 시간남으면 회원탈퇴 구현
        return view;
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("알림");
        builder.setMessage("정말 로그아웃 하시겠습니까?");
        builder.setPositiveButton("네", new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
                pManager.clear(getContext());
                ((MainActivity)getActivity()).finish();
            }
        });
        builder.show();
    }
}