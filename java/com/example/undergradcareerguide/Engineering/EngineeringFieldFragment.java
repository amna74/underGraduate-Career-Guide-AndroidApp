package com.example.undergradcareerguide.Engineering;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.undergradcareerguide.R;
import com.example.undergradcareerguide.medical.FieldCustomAdapter;
import com.example.undergradcareerguide.medical.UniMedActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EngineeringFieldFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EngineeringFieldFragment extends Fragment {


    ArrayList numList;
    String Array[];

    String EngField[][]={
            {"University of Engineering and Technology (UET)","National University of Science & Technology (NUST) Islamabad", "FAST University Islamabad", "Quaid-e-Azam University Islamabad", "University Of Central Punjab Lahore", "University of Lahore", "NED University of Engineering & Technology Karachi", "Indus University Karachi", "Dawood University of Engineering & Technology Karachi","The University of Faisalabad", "Government College University Faisalabad"},
            {"University of Engineering and Technology (UET)","National University of Science & Technology (NUST) Islamabad", "FAST University Islamabad", "Quaid-e-Azam University Islamabad", "University Of Central Punjab Lahore", "University of Lahore", "NED University of Engineering & Technology Karachi", "Indus University Karachi", "Dawood University of Engineering & Technology Karachi","The University of Faisalabad", "Government College University Faisalabad"},
            {"University of Engineering and Technology (UET)","National University of Science & Technology (NUST) Islamabad", "FAST University Islamabad", "Quaid-e-Azam University Islamabad", "University Of Central Punjab Lahore", "University of Lahore", "NED University of Engineering & Technology Karachi", "Indus University Karachi", "Dawood University of Engineering & Technology Karachi","The University of Faisalabad", "Government College University Faisalabad"},
            {"University of Engineering and Technology (UET)","National University of Science & Technology (NUST) Islamabad", "FAST University Islamabad", "Quaid-e-Azam University Islamabad", "University Of Central Punjab Lahore", "University of Lahore", "NED University of Engineering & Technology Karachi", "Indus University Karachi", "Dawood University of Engineering & Technology Karachi","The University of Faisalabad", "Government College University Faisalabad"},
            {" University of Engineering and Technology Lahore", "COMSATS Institute of Information Technology, Islamabad", "National University Of Sciences And Technology (NUST), Islamabad", "Qurtuba University, D.I.Khan", "GIKI ( Ghulam Ishaq Khan University)"},
            {"COMSATS Islamabad", "Pakistan Institute of Engineering & Applied Sciences (PIEAS) Islamabad", "National University of Science & Technology (NUST) Islamabad", "Dawood University of Engineering & Technology Karachi", "NED University of Engineering & Technology Karachi", "University of Karachi", "University of Engineering & Technology, Lahore", "University Of The Punjab Lahore", "FAST University Lahore"},
            {"COMSATS Islamabad", "Pakistan Institute of Engineering & Applied Sciences (PIEAS) Islamabad", "National University of Science & Technology (NUST) Islamabad", "Dawood University of Engineering & Technology Karachi", "NED University of Engineering & Technology Karachi", "University of Karachi", "University of Engineering & Technology, Lahore", "University Of The Punjab Lahore", "FAST University Lahore"},
            {"University of Engineering and Technology (UET)","National Textile University (NTU)", "FAST University Islamabad", "Quaid-e-Azam University Islamabad", "University Of Central Punjab Lahore", "University of Lahore", "NED University of Engineering & Technology Karachi", "Indus University Karachi", "Dawood University of Engineering & Technology Karachi","The University of Faisalabad", "Government College University Faisalabad"},
            {"University of Engineering and Technology (UET)","National University of Science & Technology (NUST) Islamabad", "FAST University Islamabad", "Quaid-e-Azam University Islamabad", "University Of Central Punjab Lahore", "University of Lahore", "NED University of Engineering & Technology Karachi", "Indus University Karachi", "Dawood University of Engineering & Technology Karachi","The University of Faisalabad", "Government College University Faisalabad"},
            {"University of Engineering and Technology (UET)","National University of Science & Technology (NUST) Islamabad", "FAST University Islamabad", "Quaid-e-Azam University Islamabad", "University Of Central Punjab Lahore", "University of Lahore", "NED University of Engineering & Technology Karachi", "Indus University Karachi", "Dawood University of Engineering & Technology Karachi","The University of Faisalabad", "Government College University Faisalabad"},
            {"University of Engineering and Technology (UET)","National University of Science & Technology (NUST) Islamabad", "FAST University Islamabad", "Quaid-e-Azam University Islamabad", "University Of Central Punjab Lahore", "University of Lahore", "NED University of Engineering & Technology Karachi", "Indus University Karachi", "Dawood University of Engineering & Technology Karachi","The University of Faisalabad", "Government College University Faisalabad"}
    };
    ListView medFieldList;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EngineeringFieldFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EngineeringFieldFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EngineeringFieldFragment newInstance(String param1, String param2) {
        EngineeringFieldFragment fragment = new EngineeringFieldFragment();
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
        View v= inflater.inflate(R.layout.fragment_engineering_field, container, false);
        medFieldList = v.findViewById(R.id.EngFieldlist);

        numList = new ArrayList();

        String selectPos = getArguments().getString("position");
        int selectedPos=Integer.parseInt(selectPos);

        for(int i = 1; i<=EngField[selectedPos].length; i++)
        {
            numList.add(i);
        }


        medFieldList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int fieldK=0;
                fieldK=position;

                Intent uniIntent= new Intent(getActivity(), UniMedActivity.class);
                uniIntent.putExtra("Uni",String.valueOf(fieldK));

            }
        });





        FieldCustomAdapter fieldCustomAdapter = new FieldCustomAdapter(getActivity(), numList, EngField,selectedPos);
        medFieldList.setAdapter(fieldCustomAdapter);


        return v;
    }
}