package com.cookandroid.project_99;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridViewAdapter extends BaseAdapter {
    ArrayList<GridViewItem> arrayList = new ArrayList<>();
    /*
     Context context;
     int[] coffee;
     String[] coffee_str;
     String[] coffee_prc;*/
    public  GridViewAdapter(){
        /*
        Context context, int[] coffee, String[] coffee_str, String[] coffee_prc
        this.context = context;
        this.coffee = coffee;
        this.coffee_str = coffee_str;
        this.coffee_prc = coffee_prc;*/
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout 을 inflate 하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_item_card, parent, false);
        }

        // 화면에 표시될 View(Layout 이 inflate 된)으로부터 위젯에 대한 참조 획득
        ImageView icon = (ImageView) convertView.findViewById(R.id.imageView) ;
        TextView title = (TextView) convertView.findViewById(R.id.productNameTv) ;
        TextView price = (TextView) convertView.findViewById(R.id.productPriceTv) ;

        // Data Set(listViewItemList)에서 position 에 위치한 데이터 참조 획득
        GridViewItem gridViewItem = arrayList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        icon.setImageResource(gridViewItem.getIcon());
        title.setText(gridViewItem.getTitle());
        price.setText(gridViewItem.getPrice());

        return convertView;
    }
    public void addItem ( String title, String price, int icon){
        GridViewItem item = new GridViewItem();

        item.setIcon(icon);
        item.setTitle(title);
        item.setPrice(price);

        arrayList.add(item);
    }

}