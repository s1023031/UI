package com.fulibaigong.tsai.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Area extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        ListView lv = (ListView)findViewById(R.id.listView);
        lv.setOnItemClickListener(this);
        IndexActivity.mContext = this;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position)
        {
            case 0:
                Toast.makeText(this,"尚未開放",Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this,"尚未開放",Toast.LENGTH_SHORT).show();
                break;

            case 2:
                Toast.makeText(this,"尚未開放",Toast.LENGTH_SHORT).show();
                break;

            case 3:
                Intent it = new Intent(this,Showarea.class);
                startActivity(it);
                break;
            case 4:
                Toast.makeText(this,"尚未開放",Toast.LENGTH_SHORT).show();
                break;

            case 5:
                Toast.makeText(this,"尚未開放",Toast.LENGTH_SHORT).show();
                break;

            case 6:
                Toast.makeText(this,"尚未開放",Toast.LENGTH_SHORT).show();
                break;

            case 7:
                Toast.makeText(this,"尚未開放",Toast.LENGTH_SHORT).show();
                break;

            case 8:
                Toast.makeText(this,"尚未開放",Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
