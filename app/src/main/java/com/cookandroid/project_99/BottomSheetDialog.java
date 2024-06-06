package com.cookandroid.project_99;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialog extends BottomSheetDialogFragment implements View.OnClickListener {
    private TextView cancel;
    private TextView cart;

    public static BottomSheetDialog getInstance() {
        return new BottomSheetDialog();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_bottom_dialog, container, false);

        cancel = view.findViewById(R.id.cancelTv);
        cart = view.findViewById(R.id.gotoCartTv);

        cancel.setOnClickListener(this);
        cart.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cancelTv:
                Toast.makeText(getContext(), "cancel click!", Toast.LENGTH_SHORT).show();
                dismiss();
                break;

            case R.id.gotoCartTv:
                Toast.makeText(getContext(), "장바구니에 담았습니다!", Toast.LENGTH_LONG).show();
                break;
        }

        dismiss();
    }
}