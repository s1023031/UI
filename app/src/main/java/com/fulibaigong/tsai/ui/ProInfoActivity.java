package com.fulibaigong.tsai.ui;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ProInfoActivity extends AppCompatActivity {


    private TextView txv;
    ImageButton InfomationBtn,GuiBtn,ActBtn,ColBtn;
    MasterFragment masterFragment;
    IntroFragment f1;
    GuideFragment f2;
    InteractFragment f3;
    CollectFragment f4;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_info);
        // set title's background
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.BGPro_Info));
        actionBar = this.getSupportActionBar();
        IndexActivity.mContext = this;
        f1 = new IntroFragment();
        f2 = new GuideFragment();
        f3 = new InteractFragment();
        f4 = new CollectFragment();
        masterFragment = new MasterFragment();

        InfomationBtn = (ImageButton)findViewById(R.id.infoBtn);
        GuiBtn = (ImageButton)findViewById(R.id.guiBtn);
        ActBtn = (ImageButton)findViewById(R.id.acBtn);
        ColBtn = (ImageButton)findViewById(R.id.colBtn);

        Intent it = getIntent();
        int entry_num = it.getIntExtra("entry",0);
        if(entry_num==1)
        {
            actionBar.setTitle("計畫簡介");

            String uri = "@drawable/jianjie";
            int imageResource = getResources().getIdentifier(uri, null, getPackageName()); //取得圖片Resource位子
            InfomationBtn.setImageResource(imageResource);

            changeFragment(f1);
        }
        else if(entry_num==2)
        {
            String uri = "@drawable/mapb";
            int imageResource = getResources().getIdentifier(uri, null, getPackageName()); //取得圖片Resource位子
            GuiBtn.setImageResource(imageResource);

            changeFragment(masterFragment);
        }
        else if(entry_num==3)
        {
            actionBar.setTitle("地圖導覽");

            String uri = "@drawable/mapb";
            int imageResource = getResources().getIdentifier(uri, null, getPackageName()); //取得圖片Resource位子
            GuiBtn.setImageResource(imageResource);

            changeFragment(f2);
        }
    }
    public void onFInfo(View v)
    {
        actionBar.setTitle("計畫簡介");

        changeFragment(f1);

        String uri = "@drawable/jianjie";
        int imageResource = getResources().getIdentifier(uri, null, getPackageName()); //取得圖片Resource位子
        InfomationBtn.setImageResource(imageResource);

        uri = "@drawable/map";
        imageResource = getResources().getIdentifier(uri, null, getPackageName()); //取得圖片Resource位子
        GuiBtn.setImageResource(imageResource);

        uri = "@drawable/game";
        imageResource = getResources().getIdentifier(uri, null, getPackageName()); //取得圖片Resource位子
        ActBtn.setImageResource(imageResource);

        uri = "@drawable/prize";
        imageResource = getResources().getIdentifier(uri, null, getPackageName()); //取得圖片Resource位子
        ColBtn.setImageResource(imageResource);
    }
    public void onFGui(View v)
    {
        actionBar.setTitle("地圖導覽");

        changeFragment(f2);

        String uri = "@drawable/jianjieb";
        int imageResource = getResources().getIdentifier(uri, null, getPackageName()); //取得圖片Resource位子
        InfomationBtn.setImageResource(imageResource);

        uri = "@drawable/mapb";
        imageResource = getResources().getIdentifier(uri, null, getPackageName()); //取得圖片Resource位子
        GuiBtn.setImageResource(imageResource);

        uri = "@drawable/game";
        imageResource = getResources().getIdentifier(uri, null, getPackageName()); //取得圖片Resource位子
        ActBtn.setImageResource(imageResource);

        uri = "@drawable/prize";
        imageResource = getResources().getIdentifier(uri, null, getPackageName()); //取得圖片Resource位子
        ColBtn.setImageResource(imageResource);
    }
    public void onFInteract(View v)
    {
        actionBar.setTitle("互動");

        changeFragment(f3);

        String uri = "@drawable/jianjieb";
        int imageResource = getResources().getIdentifier(uri, null, getPackageName()); //取得圖片Resource位子
        InfomationBtn.setImageResource(imageResource);

        uri = "@drawable/map";
        imageResource = getResources().getIdentifier(uri, null, getPackageName()); //取得圖片Resource位子
        GuiBtn.setImageResource(imageResource);

        uri = "@drawable/gameb";
        imageResource = getResources().getIdentifier(uri, null, getPackageName()); //取得圖片Resource位子
        ActBtn.setImageResource(imageResource);

        uri = "@drawable/prize";
        imageResource = getResources().getIdentifier(uri, null, getPackageName()); //取得圖片Resource位子
        ColBtn.setImageResource(imageResource);
    }
    public void onFCollect(View v)
    {
        actionBar.setTitle("收藏");

        changeFragment(f4);

        String uri = "@drawable/jianjieb";
        int imageResource = getResources().getIdentifier(uri, null, getPackageName()); //取得圖片Resource位子
        InfomationBtn.setImageResource(imageResource);

        uri = "@drawable/map";
        imageResource = getResources().getIdentifier(uri, null, getPackageName()); //取得圖片Resource位子
        GuiBtn.setImageResource(imageResource);

        uri = "@drawable/game";
        imageResource = getResources().getIdentifier(uri, null, getPackageName()); //取得圖片Resource位子
        ActBtn.setImageResource(imageResource);

        uri = "@drawable/prizeb";
        imageResource = getResources().getIdentifier(uri, null, getPackageName()); //取得圖片Resource位子
        ColBtn.setImageResource(imageResource);
    }
    private void changeFragment(Fragment f) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, f);
        transaction.commitAllowingStateLoss();
    }



    public void onChoosePoscard(View v)
    {
        Intent it = new Intent(this,ChoosePictureActivity.class);
        startActivity(it);
    }
    public void onClickMaster(View v)
    {
        actionBar.setTitle("地方工藝師");
        changeFragment(masterFragment);
    }

    public void onAr(View v)
    {
        Intent it = new Intent(this,ImageTargets.class);
        it.putExtra("number",10);
        startActivity(it);
    }

}
