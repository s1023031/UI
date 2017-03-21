package com.fulibaigong.tsai.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class InteractFragment extends Fragment {


    public InteractFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        IndexActivity.mContext = getActivity();
        return inflater.inflate(R.layout.fragment_interact, container, false);
    }

}
