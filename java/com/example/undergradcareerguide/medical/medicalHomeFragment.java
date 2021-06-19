package com.example.undergradcareerguide.medical;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.undergradcareerguide.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link medicalHomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class medicalHomeFragment extends Fragment {

    ArrayList numList;
    String[] medList={"Doctor of Veterinary Medicine",
            "D-pharmacy",
            "Biochemistry",
            "Health Sciences",
            "Doctor of Physical Therapy",
            "Medical Laboratory Technology",
            "Biotechnology",
            "Nanotechnology",
            "Microbiology",
            "Psychology",
           "Bio-Medical Engineering",
           "Nursing" };

    ListView medlistView;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public medicalHomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment medicalHomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static medicalHomeFragment newInstance(String param1, String param2) {
        medicalHomeFragment fragment = new medicalHomeFragment();
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
        View v = inflater.inflate(R.layout.fragment_medical_home, container, false);

        medlistView = v.findViewById(R.id.medicalUnilist);

        numList = new ArrayList();
        for(int i=1;i<=medList.length;i++)
        {
            numList.add(i);
        }


        CustomAdapter customAdapter = new CustomAdapter(getActivity(), numList, medList);
        medlistView.setAdapter(customAdapter);

        medlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int zz=0;
                zz=position;

                Fragment fragment = new medicalFieldFragment();

                Bundle args = new Bundle();
                args.putString("position", String.valueOf(zz));
                fragment.setArguments(args);


                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.medicalframeLayout, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

//                Intent medicalFields= new Intent(getActivity(),medicalFieldFragment.class);
//                //medicalField.putExtra("position",zz);
//                startActivity(medicalFields);
            }
        });


        return v;
    }

}

