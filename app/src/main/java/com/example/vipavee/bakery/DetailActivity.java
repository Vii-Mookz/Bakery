package com.example.vipavee.bakery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private TextView txtName,txtDetail;
    private ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = (ImageView) findViewById(R.id.imageView);
        txtName = (TextView) findViewById(R.id.txtName);
        txtDetail = (TextView) findViewById(R.id.txtDeail1);

        String stringName = getIntent().getStringExtra("Name");
        txtName.setText(stringName);

        String stringDetail = getIntent().getStringExtra("Detail");
        txtDetail.setText(stringDetail);

        int Inspic = getIntent().getIntExtra("Image", R.drawable.breads);
        imageView.setImageResource(Inspic);

    }
}
