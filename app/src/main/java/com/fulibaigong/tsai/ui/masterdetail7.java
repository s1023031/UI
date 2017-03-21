package com.fulibaigong.tsai.ui;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;

public class masterdetail7 extends AppCompatActivity {

    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masterdetail7);
        IndexActivity.mContext = this;
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.BGPro_Info));
        actionBar = this.getSupportActionBar();
        actionBar.setTitle("店家介紹");

        TextView txv = (TextView)findViewById(R.id.textView20);
        TextPaint tp = txv.getPaint();
        tp.setFakeBoldText(true);

        TextView txv1 = (TextView)findViewById(R.id.textView22);
        TextPaint name1 = txv1.getPaint();
        name1.setFakeBoldText(true);

        TextView txv2 = (TextView)findViewById(R.id.textView29);
        TextPaint name2 = txv2.getPaint();
        name2.setFakeBoldText(true);
    }
    public void onGo7(View v)
    {
        Intent it = new Intent(this,mapsnav.class);
        it.putExtra("testt",7);
        startActivity(it);
    }
}
