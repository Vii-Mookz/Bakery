package com.example.vipavee.bakery;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private TextView  textHead ;
    private ListView ListViewData;
    private Button BtnClick;
    private String UrlClick = "https://www.cornerbakerycafe.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textHead = (TextView) findViewById(R.id.txtHead);
        ListViewData = (ListView) findViewById(R.id.listview);
        BtnClick = (Button) findViewById(R.id.btn_click);


        BtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetText(); //เรียก Function มาใช้
                SetSound(); //เรียก Function มาใช้
                OpenUrl();
            }
        });

        final int[] intsPic = new int[]{
                R.drawable.breads,
                R.drawable.strawberrycake,
                R.drawable.strawberrypie,
                R.drawable.croissant,
                R.drawable.chocolatechipcookies,
                R.drawable.eclair,
                R.drawable.custard1
        };

        final String[] stringBakery = getResources().getStringArray(R.array.data_main); //เรียกข้อมูลชื่อ bakery array
        final String[] stringsDetail = getResources().getStringArray(R.array.data_detail);

        MainAdapter mainAdapter = new MainAdapter(this,intsPic,stringBakery,stringsDetail);
        ListViewData.setAdapter(mainAdapter);

        ListViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("Name", stringBakery[i]);
                intent.putExtra("Detail", stringsDetail[i]);
                intent.putExtra("Image", intsPic[i]);
                intent.putExtra("index",i);






                startActivity(intent);
            }
        });

    }//Main Method

    private void  SetText(){
        textHead.setText("LIST BAKERY");
//        textHead.setText(Head);
    } //SetText Function ไว้เรียกใช้

    private  void SetSound(){ //Function ไว้เรียกใช้

        MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(),R.raw.alert);
        mediaPlayer.start();
    }//SetSound Function ไว้เรียกใช้
    private void OpenUrl(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(UrlClick));
        startActivity(intent);
    }//OpenUrl Funtion
    //Intent เป็นการส่งข้อมูลระหว่าง Activity

}
