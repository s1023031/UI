package com.fulibaigong.tsai.ui;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    static final String dbName = "mainDB"; // 資料庫名稱
    static final String tbName = "mainTB"; // 資料表名稱
    SQLiteDatabase db; // DB物件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 資料庫名稱 \ 運作模式(僅供自己使用) \ 回傳查詢結果回傳值
        db = openOrCreateDatabase(dbName, Context.MODE_PRIVATE, null);

        String createTable = "CREATE TABLE IF NOT EXISTS " +
                tbName +
                "(id INT(32), " + "name VARCHAR(50), " + "imagepath VARCHAR(200), " + "active BOOLEAN, "
                + "latitutue DOUBLE(32), " + "longtidue DOUBLE(32))";

        db.execSQL(createTable);

        Cursor cs = db.rawQuery("SELECT * FROM " + tbName , null);

        // 沒有資料時加入新資料
        if(cs.getCount() == 0)
        {
            addData(0, "Chao_SC", "testPath0", false, 24.2321570, 120.6454390);
            addData(1, "Chen_KK", "testPath1", false, 24.1684150, 120.6451980);
            addData(2, "Chen_MT", "testPath2", false, 24.1436280, 120.6762500);
            addData(3, "Chen_YF", "testPath3", false, 24.1744040, 120.6800980);
            addData(4, "Chou_MW", "testPath4", false, 24.2508020, 120.5554670);
            addData(5, "Huang_CC","testPath5", false, 24.2603170, 120.7226020);
            addData(6, "Liao_SW", "testPath6", false, 24.3608930, 120.6383870);
            addData(7, "Shih_CH", "testPath7", false, 24.2518210, 120.7501270);
            addData(8, "Tsai_JY", "testPath8", false, 24.0600260, 120.6972850);
            addData(9, "Testing", "testPath9", false, 24.1600260, 120.3972850);
        }
        db.close();


    }
    public void addData(int id, String name, String imagePath, boolean active, double latitutue, double longtidue)
    {
        ContentValues cv = new ContentValues(6);

        cv.put("id", id);
        cv.put("name", name);
        cv.put("imagepath", imagePath);
        cv.put("active", active);
        cv.put("latitutue", latitutue);
        cv.put("longtidue", longtidue);


        db.insert(tbName, null, cv);
    }
    public void onInToIndex(View v)
    {
        Intent it = new Intent(this,IndexActivity.class);
        startActivity(it);
    }
}
