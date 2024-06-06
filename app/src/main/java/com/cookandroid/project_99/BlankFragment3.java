package com.cookandroid.project_99;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment3 extends Fragment {
    GridView gridView3;
    GridViewAdapter adapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment3 newInstance(String param1, String param2) {
        BlankFragment3 fragment = new BlankFragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank3, container, false);
        gridView3 = (GridView) view.findViewById(R.id.gridView3);
        adapter = new GridViewAdapter();
        gridView3.setAdapter(adapter);


        adapter.addItem( "순우유마카롱", "3000", (R.drawable.ice29));
        adapter.addItem("딸기크런치마카롱", "3000", (R.drawable.ice30));
        adapter.addItem( "초코크런치마카롱", "3000", (R.drawable.ice31));
        adapter.addItem( "파맛공공치빵", "3000", (R.drawable.ice32));
        adapter.addItem( "초코맛공공치빵", "3000", (R.drawable.ice33));
        adapter.addItem( "크리미슈", "2300", (R.drawable.ice34));
        adapter.addItem( "크리미단팥빵", "2300", (R.drawable.ice35));
        adapter.addItem( "소프트아이스크림", "1500", (R.drawable.ice36));
        adapter.addItem( "달고나크런치", "2000", (R.drawable.ice37));
        adapter.addItem( "페스츄리와플", "2500", (R.drawable.ice38));
        adapter.addItem( "오리지널마들렌", "2800", (R.drawable.ice39));
        adapter.addItem( "초콜릿머핀", "2300", (R.drawable.ice40));
        gridView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                GridViewItem item = (GridViewItem) parent.getItemAtPosition(position);
                Intent intent = new Intent(getContext(), Basket.class);
                intent.putExtra("title", item.getTitle());
                intent.putExtra("price", item.getPrice());
                intent.putExtra("icon", item.getIcon());
                startActivity(intent);
            }
        });
        return view;
    }
}