package com.example.undergradcareerguide.medical;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.undergradcareerguide.NTS.NTS_Activity;
import com.example.undergradcareerguide.R;
import com.example.undergradcareerguide.demoTest.NTest;
import com.example.undergradcareerguide.demoTest.selectionQActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestFragment extends Fragment {
    LinearLayout generalTest,NTS,NTS22;
            Button generalTest1,generalTest2,NTS1,NTS12,NTS23,NTS24;
    public static String TestType=null;
    public static int chosenType=0;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TestFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TestFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TestFragment newInstance(String param1, String param2) {
        TestFragment fragment = new TestFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_test, container, false);

        generalTest=v.findViewById(R.id.GeneralTest);
        generalTest1=v.findViewById(R.id.generalTest1);
        generalTest2=v.findViewById(R.id.generalTest2);
        NTS=v.findViewById(R.id.NTS);
        NTS1=v.findViewById(R.id.NTS1);
        NTS12=v.findViewById(R.id.NTS12);
        NTS22=v.findViewById(R.id.NTS22);
        NTS23=v.findViewById(R.id.NTS23);
        NTS24=v.findViewById(R.id.NTS24);

        generalTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestType="General";
                startActivity(new Intent(getActivity(), selectionQActivity.class));
            }
        });
        generalTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestType="General";
                startActivity(new Intent(getActivity(), selectionQActivity.class));
            }
        });
        generalTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestType="General";
                startActivity(new Intent(getActivity(), selectionQActivity.class));
            }
        });


        NTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestType="NTS";
                chosenType=1;
                startActivity(new Intent(getActivity(), NTS_Activity.class));
            }
        });
        NTS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestType="NTS";
                chosenType=1;
                startActivity(new Intent(getActivity(), NTS_Activity.class));
            }
        });
        NTS12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestType="NTS";
                chosenType=1;
                startActivity(new Intent(getActivity(), NTS_Activity.class));
            }
        });

        NTS22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestType="NTS 2";
                chosenType=2;
                startActivity(new Intent(getActivity(), NTS_Activity.class));
            }
        });
        NTS23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestType="NTS 2";
                chosenType=2;
                startActivity(new Intent(getActivity(), NTS_Activity.class));
            }
        });
        NTS24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestType="NTS 2";
                chosenType=2;
                startActivity(new Intent(getActivity(), NTS_Activity.class));
            }
        });


        return v;
    }
}