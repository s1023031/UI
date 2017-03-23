package com.fulibaigong.tsai.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class MasterFragment extends Fragment implements AdapterView.OnItemClickListener{

    ListView lv;
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        IndexActivity.mContext = getActivity();
        View v = getView();
        //Toast.makeText(v.getContext(),"1111111",Toast.LENGTH_SHORT).show();
        lv = (ListView)v.findViewById(R.id.listView);
        lv.setOnItemClickListener(MasterFragment.this);

  /*      String[] strAry = new String[] { "图片1", "图片2", "图片3", "图片4"
                , "图片5", "图片6", "图片7", "图片8", "图片9"};*/
        // 放在listView中的图片资源id

        //2017/3/23 delete test1
        int[] imgAry = new int[] { R.drawable.chaosc, R.drawable.chenkk,
                R.drawable.chenmt, R.drawable.chenyf,R.drawable.choumw,R.drawable.huangcc,
                R.drawable.liaosw,R.drawable.shihch,R.drawable.tsaijy};
        // 创建List集合对象
        List list = new ArrayList();
        // 为List集合添加数据
        for (int i = 0; i < imgAry.length; i++) {
            Map map = new HashMap();
            map.put("image", imgAry[i]);
            //map.put("text", strAry[i]);
            list.add(map);
        }
        // 参数1：context - 上下文对象
        // 参数2：data - 设置到listView的数据集合
        // 参数3：resource - 放在listView中每一行的布局资源文件
        // 参数4：from - 指定每一行数据的键（和to里面的id对应）
        // 参数5：to - 指定每一行数据应用到哪个组件上
        //Toast.makeText(getActivity(), "HHHHH", Toast.LENGTH_SHORT).show();
        SimpleAdapter adapter = new SimpleAdapter(getContext(), list,
                R.layout.main_test_listview, new String[] { "image"},
                new int[] { R.id.listview_content_img});
        // 如果只有文本可以使用下面的ArrayAdapter适配器
        // ArrayAdapter adapter = new ArrayAdapter(this,
        // android.R.layout.simple_list_item_checked, strAry);
        // 得到ListView对象
        // 设置ListView的内容
        lv.setAdapter(adapter);

    }
    public MasterFragment() {
        // Required empty public constructor
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        if(position==0)
        {
            Intent it = new Intent(getContext(),masterdetail.class);
            startActivity(it);
        }
        else if(position==1)
        {
            Intent it = new Intent(getContext(),masterdetail2.class);
            startActivity(it);
        }
        else if(position==2)
        {
            Intent it = new Intent(getContext(),masterdetail3.class);
            startActivity(it);
        }
        else if(position==3)
        {
            Intent it = new Intent(getContext(),masterdetail4.class);
            startActivity(it);
        }
        else if(position==4)
        {
            Intent it = new Intent(getContext(),masterdetail5.class);
            startActivity(it);
        }
        else if(position==5)
        {
            Intent it = new Intent(getContext(),masterdetail6.class);
            startActivity(it);
        }
        else if(position==6)
        {
            Intent it = new Intent(getContext(),masterdetail7.class);
            startActivity(it);
        }
        else if(position==7)
        {
            Intent it = new Intent(getContext(),masterdetail8.class);
            startActivity(it);
        }
        else if(position==8)
        {
            Intent it = new Intent(getContext(),masterdetail9.class);
            startActivity(it);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_master, container, false);
    }


}
