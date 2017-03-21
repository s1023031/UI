package com.fulibaigong.tsai.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class IntroFragment extends Fragment {
    //TextView txv1,txv6,txv7,txv8,txv9,txv12,txv14,txv15,txv16,txv17;
    float x = IndexActivity.results[0];

    public IntroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        /*View v = getView();
        txv1 = (TextView)v.findViewById(R.id.textView);
        txv6 = (TextView)v.findViewById(R.id.textView6);
        txv7 = (TextView)v.findViewById(R.id.textView7);
        txv8 = (TextView)v.findViewById(R.id.textView8);
        txv9 = (TextView)v.findViewById(R.id.textView9);
        txv12 = (TextView)v.findViewById(R.id.textView12);
        txv14 = (TextView)v.findViewById(R.id.textView14);
        txv15 = (TextView)v.findViewById(R.id.textView15);
        txv16 = (TextView)v.findViewById(R.id.textView16);
        txv17 = (TextView)v.findViewById(R.id.textView17);*/

        //txv1.setTextScaleX(3f);
        IndexActivity.mContext = getActivity();
        return inflater.inflate(R.layout.fragment_intro, container, false);

    }

}
