package com.cookandroid.project_99;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
//shop 눌렀을때
public class MainMenuShopFragment extends Fragment implements ItemClickListener {
    private static final String TYPE_COFFEE = "COFFEE";
    private static final String TYPE_BEVERAGE = "BEVERAGE";
    private static final String TYPE_DESSERT = "DESSERT";

    private View view;
    private RecyclerView recyclerView;
    private SelectRecyclerAdapter tAdapter;
    private String[] tData;
    private ShopRecyclerAdapter pAdapter;
    private ArrayList<ProductBean> pData;
    private ProductDBHelper dbHelper;

    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_menu_shop, container, false);

        showTypeSelecter();
        showProduct();

        return view;
    }

    private void showTypeSelecter() {
        tData = getContext().getResources().getStringArray(R.array.type);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView = view.findViewById(R.id.typeSelectRecycler);
        recyclerView.setLayoutManager(layoutManager);
        tAdapter = new SelectRecyclerAdapter(tData, this);
        recyclerView.setAdapter(tAdapter);
    }

    private void showProduct() {
        dbHelper = ProductDBHelper.getInstance(getContext());
        pData = dbHelper.getAllProduct();

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView = view.findViewById(R.id.productRecycler);
        recyclerView.setLayoutManager(layoutManager);
        pAdapter = new ShopRecyclerAdapter(pData, this);
        recyclerView.setAdapter(pAdapter);
    }

    private void showProduct(String type) {
        pData.clear();
        pData = dbHelper.getProductbyType(type);
        pAdapter.updateData(pData);
    }

    @Override
    public void onItemClick(View v, int position) {
        String type = String.valueOf(((TextView)(v.findViewById(R.id.typeSelectTv))).getText());

        if(type.equals(TYPE_COFFEE)){
            showProduct(type);
        } else if(type.equals(TYPE_BEVERAGE)) {
            showProduct(type);
        } else if(type.equals(TYPE_DESSERT)) {
            showProduct(type);
        }
    }
}
