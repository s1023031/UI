package com.fulibaigong.tsai.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IndexActivity extends Activity implements LocationListener {
    static final int mintime = 5000;
    static final float mindist = 5;
    public static float[]results = new float[1];
    LocationManager mgr;
    Intent it;
    private Button PIBtn;
 //   TextView txv;
    public static Context mContext;
    String []name=new String[]{"Chao_SC","Chen_KK","Chen_MT","Chen_YF","Chou_MW","Huang_CC",
            "Liao_SW","Shih_CH","Tsai_JY"};
    static String place ="";
    int flags = 0;
    double []la =new double[]{24.2321570,24.1684150,24.1436280,24.1744040,24.2508020,24.2603170,24.3608930,24.2518210,24.0600260};
    double []lo=new double[]{120.6454390,120.6451980,120.6762500,120.6800980,120.55546700,120.7226020,120.6383870,120.7501270,120.6972850};
    static final String tbName = MainActivity.tbName;
    SQLiteDatabase db; // DB物件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        it = new Intent(this,ProInfoActivity.class);
        mContext = this;
       // txv = (TextView)findViewById(R.id.textView31);
        mgr = (LocationManager)getSystemService(LOCATION_SERVICE);

    }
    public void onProIntro(View v)
    {
       // Intent it = new Intent(this,ProInfoActivity.class);
        it.putExtra("entry",1);
        startActivity(it);
    }
    public void onMasterIntro(View v) {
        //Intent it = new Intent(this,ProInfoActivity.class);
        it.putExtra("entry",2);
        startActivity(it);
    }
    public void onMapGui(View v)
    {
        //Intent it = new Intent(this,ProInfoActivity.class);
        it.putExtra("entry",3);
        startActivity(it);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        String best = mgr.getBestProvider(new Criteria(),true);
        if(best!=null)
        {
           // txv.setText("取得定位諮詢中...");
            mgr.requestLocationUpdates(best, mintime, mindist, this);
        }
        else
        {
            //txv.setText("請確認已開啟定位功能!");
        }

    }


    @Override
    public void onLocationChanged(Location location) {
        if(location!=null)
        {
            db = mContext.openOrCreateDatabase(MainActivity.dbName, Context.MODE_PRIVATE, null);
            String createTable = "CREATE TABLE IF NOT EXISTS " +
                    "mainTB" +
                    "(id INT(32), " + "name VARCHAR(50), " + "imagepath VARCHAR(200), " + "active BOOLEAN, "
                    + "latitutue DOUBLE(32), " + "longtidue DOUBLE(32))";

            db.execSQL(createTable);
            Cursor cs = db.rawQuery("SELECT * FROM " + MainActivity.tbName , null);
            //  Toast.makeText(this, "OK", Toast.LENGTH_SHORT);

            for(int i=0;i<9;i++)
            {
                Location.distanceBetween(location.getLatitude(), location.getLongitude(), la[i], lo[i], results);
                if(results[0]<=500)
                {
                    //txv.setText(String.format("距離: %.4f",results[0]));
                    if(cs.moveToFirst())
                    {
                        if(cs.getString(1).equals(name[i]) && cs.getInt(3)==0)
                        {
                            place = name[i];
                            Displayalert dis = new Displayalert(mContext);
                            dis.displayalert();
                        }
                        while(cs.moveToNext())
                        {
                            if( cs.getString(cs.getColumnIndex("name")).equals(name[i]) && cs.getInt(3)==0 )
                            {
                                place = name[i];
                                Displayalert dis = new Displayalert(mContext);
                                dis.displayalert();
                            }
                        }
                    }

                }

            }

        }
        else
        {
            //txv.setText("無法取得定位的資訊!");
        }

    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}