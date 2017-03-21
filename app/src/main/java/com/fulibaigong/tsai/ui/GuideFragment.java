package com.fulibaigong.tsai.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class GuideFragment extends Fragment {


    public GuideFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_guide,
                container, false);
        Button button = (Button) view.findViewById(R.id.button2);
        IndexActivity.mContext = getActivity();
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(getContext(),Area.class);
                startActivity(it);
            }
        });
        return view;
    }
}