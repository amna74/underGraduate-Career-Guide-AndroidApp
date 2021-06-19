package com.example.undergradcareerguide.Engineering;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.undergradcareerguide.R;
import com.example.undergradcareerguide.medical.CustomAdapter;
import com.example.undergradcareerguide.medical.medicalFieldFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EngineeringHomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EngineeringHomeFragment extends Fragment {

    ArrayList numList;
    String[] EngList={"Mechanical Engineering",
            "Electrical Engineering",
            "Civil Engineering",
            "Mechatronics",
            "Software Engineering",
            "Chemical Engineering",
            "Aerospace engineering.",
            "Textile Engineering",
            "Food Engineering",
            "Petroleum Engineering.",
            "Biochemical Engineering"};

    ListView medlistView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EngineeringHomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EngineeringHomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EngineeringHomeFragment newInstance(String param1, String param2) {
        EngineeringHomeFragment fragment = new EngineeringHomeFragment();
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
        View v =  inflater.inflate(R.layout.fragment_engineering_home, container, false);
        medlistView = v.findViewById(R.id.EngUnilist);

        numList = new ArrayList();

        for(int i=1;i<= EngList.length;i++)
        {
            numList.add(i);
        }


       CustomAdapter customAdapter = new CustomAdapter(getActivity(), numList, EngList);
        medlistView.setAdapter(customAdapter);

        medlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int zz=0;
                zz=position;

                Fragment fragment = new EngineeringFieldFragment();

                Bundle args = new Bundle();
                args.putString("position", String.valueOf(zz));
                fragment.setArguments(args);


                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.EngframeLayout, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });


        return v;

    }
}