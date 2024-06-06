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
 * Use the {@link BlankFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment2 extends Fragment {
    GridView gridView2;
    GridViewAdapter adapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment2 newInstance(String param1, String param2) {
        BlankFragment2 fragment = new BlankFragment2();
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
        View view = inflater.inflate(R.layout.fragment_blank2, container, false);
        gridView2 = (GridView) view.findViewById(R.id.gridView2);
        adapter = new GridViewAdapter();
        gridView2.setAdapter(adapter);


        adapter.addItem("바닐라라떼", "4000", (R.drawable.ice3));
        adapter.addItem("녹차라떼", "4000", (R.drawable.ice4));
        adapter.addItem( "카라멜마끼아또", "4000", (R.drawable.ice5));
        adapter.addItem( "초코라떼", "4000", (R.drawable.ice6));
        adapter.addItem( "레몬에이드", "4500", (R.drawable.ice9));
        adapter.addItem( "자몽에이드", "4500", (R.drawable.ice10));
        adapter.addItem( "청포도에이드", "4500", (R.drawable.ice11));
        adapter.addItem( "딸기에이드", "4000", (R.drawable.ice12));
        adapter.addItem( "삼라봉에이드", "5000", (R.drawable.ice13));
        adapter.addItem( "민트초코라떼", "4000", (R.drawable.ice14));
        adapter.addItem( "초코라떼", "4000", (R.drawable.ice15));
        adapter.addItem( "딸기라떼", "4000", (R.drawable.ice16));
        adapter.addItem( "블랙펄라떼", "4200", (R.drawable.ice17));
        adapter.addItem( "딸기요거트스무디", "4500", (R.drawable.ice18));
        adapter.addItem( "블루베리요거트스무디", "5300", (R.drawable.ice19));
        adapter.addItem( "플레인요거트스무디", "4000", (R.drawable.ice20));
        adapter.addItem( "깔라만시에이드", "4000", (R.drawable.ice21));
        adapter.addItem( "딸기주스", "4500", (R.drawable.ice22));
        adapter.addItem( "오렌지자몽블랙티", "4000", (R.drawable.ice23));
        adapter.addItem( "페퍼민트티", "3000", (R.drawable.ice24));
        adapter.addItem( "캐모마일티", "3000", (R.drawable.ice25));
        adapter.addItem( "수박주스", "43000", (R.drawable.ice26));
        adapter.addItem( "망고주스", "4000", (R.drawable.ice27));
        adapter.addItem( "토마토주스", "4500", (R.drawable.ice28));
        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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