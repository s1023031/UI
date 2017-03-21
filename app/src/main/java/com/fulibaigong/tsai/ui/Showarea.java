package com.fulibaigong.tsai.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Showarea extends AppCompatActivity {

    GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showarea);
        IndexActivity.mContext = this;
        map = ((SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        marking();
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(24.2603170, 120.7226020), 10.0f));
    }

    public void marking()
    {
        MarkerOptions markerOpt = new MarkerOptions();
        markerOpt.position(new LatLng(24.2321570, 120.6454390));
        markerOpt.title("趙家窯工藝坊");

        MarkerOptions markerOpt2 = new MarkerOptions();
        markerOpt2.position(new LatLng(24.1684150,120.6451980));
        markerOpt2.title("陳光國 怡陶居工作室");

        MarkerOptions markerOpt3 = new MarkerOptions();
        markerOpt3.position(new LatLng(24.1436280,120.6762500));
        markerOpt3.title("陳銘堂 觀竹堂");

        MarkerOptions markerOpt4 = new MarkerOptions();
        markerOpt4.position(new LatLng(24.1744040,120.6800980));
        markerOpt4.title("陳遠芳 遠芳金屬工藝坊");

        MarkerOptions markerOpt5 = new MarkerOptions();
        markerOpt5.position(new LatLng(24.2508020,120.55546700));
        markerOpt5.title("周妙文 陶妍藝術創作坊");

        MarkerOptions markerOpt6 = new MarkerOptions();
        markerOpt6.position(new LatLng(24.2603170,120.7226020));
        markerOpt6.title("黃吉正 士口一止陶藝工作室");

        MarkerOptions markerOpt7 = new MarkerOptions();
        markerOpt7.position(new LatLng(24.3608930,120.6383870));
        markerOpt7.title("廖勝文 鐵山漆坊");

        MarkerOptions markerOpt8 = new MarkerOptions();
        markerOpt8.position(new LatLng(24.2518210,120.7501270));
        markerOpt8.title("史嘉祥 憶林舍工作室");

        MarkerOptions markerOpt9 = new MarkerOptions();
        markerOpt9.position(new LatLng(24.0600260, 120.6972850));
        markerOpt9.title("蔡榮祐 廣達藝苑");

        map.addMarker(markerOpt);
        map.addMarker(markerOpt2);
        map.addMarker(markerOpt3);
        map.addMarker(markerOpt4);
        map.addMarker(markerOpt5);
        map.addMarker(markerOpt6);
        map.addMarker(markerOpt7);
        map.addMarker(markerOpt8);
        map.addMarker(markerOpt9);
    }

}