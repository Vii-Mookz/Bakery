package com.example.vipavee.bakery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Vipavee on 14/07/2017.
 */

//Context เปรียบเหมือนท่อ เป็นตัวกลางสำหรับส่งข้อมูล
//Constructor คือ ตัวรับส่ง ข้อมูล มี Context ก่อน
//extent คือการสืบทอด
public class MainAdapter extends BaseAdapter {
    private Context context;
    private int[] intsPic;
    private String[] name;
    private String[] detail;

    public MainAdapter(Context context,
                       int[] intsPic,
                       String[] name,
                       String[] detail) {
        this.context = context;
        this.intsPic = intsPic;
        this.name = name;
        this.detail = detail;
    }

    @Override
    public int getCount() {
        return intsPic.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.listview_layout, viewGroup, false);
        ImageView imageView = (ImageView) view1.findViewById(R.id.imgView);
        TextView textName = (TextView) view1.findViewById(R.id.txtHead);
//        TextView textDetail = (TextView) view1.findViewById(R.id.txtDetail);


        imageView.setImageResource(intsPic[position]);
        textName.setText(name[position]);
//        textDetail.setText(detail[position]);

        return view1;
    }
}

