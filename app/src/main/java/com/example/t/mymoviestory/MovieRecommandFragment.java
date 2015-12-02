package com.example.t.mymoviestory;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MovieRecommandFragment extends Fragment {
    private static final String ARG_NAME = "테스트";

    private String mName;


    public static MovieRecommandFragment newInstance(String name) {
        MovieRecommandFragment estimateFragment = new MovieRecommandFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        estimateFragment.setArguments(args);
        return estimateFragment;
    }

    public MovieRecommandFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mName = getArguments().getString(ARG_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_recommand_layout, container, false);
        ((TextView)view.findViewById(R.id.text_name)).setText(mName);
        return view;
    }


}
