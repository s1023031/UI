package com.fulibaigong.tsai.ui;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectFragment extends Fragment {

    int[] imagesGet = {R.drawable.chaosc1, R.drawable.chenkk1, R.drawable.chenmt1, R.drawable.chenyf1,
    R.drawable.choumw1, R.drawable.huangcc1, R.drawable.liaosw1, R.drawable.shicx1, R.drawable.tsaij1,R.drawable.chaosc1};

    int[] imagesNotGet = {R.drawable.chaosc0, R.drawable.chenkk0, R.drawable.chenmt0, R.drawable.chenyf0,
            R.drawable.choumw0, R.drawable.huangcc0, R.drawable.liaosw0, R.drawable.shicx0, R.drawable.tsaijy0};

    int[] imgNameAry = new int[] { R.drawable.chaosc, R.drawable.chenkk,
            R.drawable.chenmt, R.drawable.chenyf,R.drawable.choumw,R.drawable.huangcc,
            R.drawable.liaosw,R.drawable.shihch,R.drawable.tsaijy,R.drawable.test1};
    ListView lv;
    int[] item_picture={R.drawable.chaosc0, R.drawable.chenkk0, R.drawable.chenmt0, R.drawable.chenyf0,
            R.drawable.choumw0, R.drawable.huangcc0, R.drawable.liaosw0, R.drawable.shicx0, R.drawable.tsaijy0,R.drawable.chaosc0};

    SQLiteDatabase db; // DB物件

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        View v = getView();
        lv= (ListView)v.findViewById(R.id.collect_listView);
        IndexActivity.mContext = getActivity();
        //db = db.openOrCreateDatabase(dbName,null, null);
        db = getActivity().openOrCreateDatabase(MainActivity.dbName, Context.MODE_PRIVATE, null);
        String createTable = "CREATE TABLE IF NOT EXISTS " +
                "mainTB" +
                "(id INT(32), " + "name VARCHAR(50), " + "imagepath VARCHAR(200), " + "active BOOLEAN, "
                + "latitutue DOUBLE(32), " + "longtidue DOUBLE(32))";

        db.execSQL(createTable);

        Cursor cs = db.rawQuery("SELECT * FROM " + MainActivity.tbName , null);

        // 判斷active是否為1
        if(cs.moveToFirst())
        {

            if(cs.getInt(3)==1)
                item_picture[0]=imagesGet[0];
            int count=1;
            while(cs.moveToNext())
            {

                if(cs.getInt(cs.getColumnIndex("active"))==1)
                    item_picture[count]=imagesGet[count];
                count++;
            }
        }


        // 为List集合添加数据
        SimpleAdapter adapter= new SimpleAdapter(getContext(), getData(),
                R.layout.single_row, new String[] {"collectGet","imageName"},
                new int[] { R.id.collect_content_item_img,R.id.collect_content_name_img});
        lv.setAdapter(adapter);

        db.close();
    }
    private List getData()
    {
        List list = new ArrayList();
        Map map ;
        for (int i = 0; i < 10; i++) {
            map = new HashMap();
            map.put("collectGet", item_picture[i]);
            map.put("imageName", imgNameAry[i]);
            list.add(map);
        }
        return list;
    }

    public CollectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_collect, container, false);
    }
}