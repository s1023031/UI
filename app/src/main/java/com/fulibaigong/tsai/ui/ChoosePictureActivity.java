package com.fulibaigong.tsai.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class ChoosePictureActivity extends AppCompatActivity {

    private ImageButton btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_picture);
        btn1 = (ImageButton)findViewById(R.id.poscard1);
        btn2 = (ImageButton)findViewById(R.id.poscard2);
        btn3 = (ImageButton)findViewById(R.id.poscard3);
        btn4 = (ImageButton)findViewById(R.id.poscard4);
        IndexActivity.mContext = this;

    }

    public void onTakePicture(View v)
    {
        Intent itc = new Intent(this,TakePictureActivity.class);
        String uri;
        if(v.getId()==R.id.poscard1)
        {
            uri = "@drawable/poscard1";
            itc.putExtra("datab",uri);
        }
        else if(v.getId()==R.id.poscard2)
        {
            uri = "@drawable/poscard2";
            itc.putExtra("datab",uri);
        }
        else if(v.getId()==R.id.poscard3)
        {
            uri = "@drawable/poscard3";
            itc.putExtra("datab",uri);
        }
        else if(v.getId()==R.id.poscard4)
        {
            uri = "@drawable/poscard4";
            itc.putExtra("datab",uri);
        }
        startActivity(itc);
    }
}
