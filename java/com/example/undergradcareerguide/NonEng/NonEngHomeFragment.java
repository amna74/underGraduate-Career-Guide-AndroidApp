package com.example.undergradcareerguide.NonEng;

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

import com.example.undergradcareerguide.Engineering.EngineeringFieldFragment;
import com.example.undergradcareerguide.R;
import com.example.undergradcareerguide.medical.CustomAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NonEngHomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NonEngHomeFragment extends Fragment {

    ArrayList numList;
    String[] NonEngList = { "Commercial Art",
            " Costume Design & Dress Making",
            " Interior Decoration, Textile Design",
            "Cyber Security",
            "Modern Office Management",
            "B.S Physics"};

    ListView medlistView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NonEngHomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NonEngHomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NonEngHomeFragment newInstance(String param1, String param2) {
        NonEngHomeFragment fragment = new NonEngHomeFragment();
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
        View v= inflater.inflate(R.layout.fragment_non_eng_home, container, false);
        medlistView = v.findViewById(R.id.NonEngUnilist);

        numList = new ArrayList();

        for(int i=1;i<= NonEngList.length;i++)
        {
            numList.add(i);
        }


        CustomAdapter customAdapter = new CustomAdapter(getActivity(), numList, NonEngList);
        medlistView.setAdapter(customAdapter);

        medlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int zz=0;
                zz=position;

                Fragment fragment = new NonEngFieldFragment();

                Bundle args = new Bundle();
                args.putString("position", String.valueOf(zz));
                fragment.setArguments(args);


                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.NonEngframeLayout, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });


        return v;
    }
}