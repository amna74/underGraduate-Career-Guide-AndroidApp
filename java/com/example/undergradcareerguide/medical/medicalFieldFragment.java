package com.example.undergradcareerguide.medical;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.undergradcareerguide.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link medicalFieldFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class medicalFieldFragment extends Fragment {

    ArrayList numList;
    String Array[];

    String med[][]={
            {" University of Agriculture Faisalabad", "Pir Mehr Ali Shah Arid Agriculture University(Rawalpindi)", "RIPHAH International University (Islamabad)", "University of Veterinary and Animal Sciences (Lahore)", "Riphah College of Veterinary Sciences, Lahore"},
            { "University of Agriculture Faisalabad", "Government College University(Faisalabad)", "Quaid-i-Azam University( Islamabad)", "Hamdard University (Islamabad Campus)"," University of Lahore (Islamabad Campus)", "Benazir Bhutto Shaheed University(Karachi)"," Dow University of Health Sciences (Karachi)", "Jinnah Sindh Medical University (Karachi)", "Lahore College For Women University", "University Of The Punjab (Lahore)", "University of Veterinary and Animal Sciences(Lahore)"},
            {"University of The Punjab (Lahore)", "University of Veterinary and AnimalSciences (Lahore)", "Kinnaird College for Women","University of Karachi", "Federal Urdu University (Karachi)", "Jinnah Sindh Medical University(Karachi)"," Quaid-e-Azam University(ISB)", "Allama Iqbal Open University", "Pir Mehr Ali Shah Arid Agriculture University(Rawalpindi)", "Government College University(Faisalabad)", "Government College Women University, Faisalabad", "University of Agriculture Faisalabad"},
            { "University of Health Sciences (Lahore)", "King Edward Medical University(Lahore)"," Lahore Medical & Dental College, Aga Khan University", "Dow University of Health Sciences (Karachi)"," Ziauddin Medical University, Karachi", "Al-Nafees Medical College Islamabad", "Rawal Institute of Health Sciences(Islamabad)", "HBS Medical and Dental College, Islamabad"},
            {" University of Agriculture Faisalabad", "Pir Mehr Ali Shah Arid Agriculture University(Rawalpindi)", "RIPHAH International University (Islamabad)", "University of Veterinary and Animal Sciences (Lahore)", "Riphah College of Veterinary Sciences, Lahore"},
            {" University of Agriculture Faisalabad", "Pir Mehr Ali Shah Arid Agriculture University(Rawalpindi)", "RIPHAH International University (Islamabad)", "University of Veterinary and Animal Sciences (Lahore)", "Riphah College of Veterinary Sciences, Lahore"},
            {" University of Agriculture Faisalabad", "Pir Mehr Ali Shah Arid Agriculture University(Rawalpindi)", "RIPHAH International University (Islamabad)", "University of Veterinary and Animal Sciences (Lahore)", "Riphah College of Veterinary Sciences, Lahore"},
            {" University of Agriculture Faisalabad", "Pir Mehr Ali Shah Arid Agriculture University(Rawalpindi)", "RIPHAH International University (Islamabad)", "University of Veterinary and Animal Sciences (Lahore)", "Riphah College of Veterinary Sciences, Lahore"},
            { "University of Agriculture Faisalabad", "Government College University(Faisalabad)", "Quaid-i-Azam University( Islamabad)", "Hamdard University (Islamabad Campus)"," University of Lahore (Islamabad Campus)", "Benazir Bhutto Shaheed University(Karachi)"," Dow University of Health Sciences (Karachi)", "Jinnah Sindh Medical University (Karachi)", "Lahore College For Women University", "University Of The Punjab (Lahore)", "University of Veterinary and Animal Sciences(Lahore)"},
            { "University of Agriculture Faisalabad", "Government College University(Faisalabad)", "Quaid-i-Azam University( Islamabad)", "Hamdard University (Islamabad Campus)"," University of Lahore (Islamabad Campus)", "Benazir Bhutto Shaheed University(Karachi)"," Dow University of Health Sciences (Karachi)", "Jinnah Sindh Medical University (Karachi)", "Lahore College For Women University", "University Of The Punjab (Lahore)", "University of Veterinary and Animal Sciences(Lahore)"},
            { "University of Agriculture Faisalabad", "Government College University(Faisalabad)", "Quaid-i-Azam University( Islamabad)", "Hamdard University (Islamabad Campus)"," University of Lahore (Islamabad Campus)", "Benazir Bhutto Shaheed University(Karachi)"," Dow University of Health Sciences (Karachi)", "Jinnah Sindh Medical University (Karachi)", "Lahore College For Women University", "University Of The Punjab (Lahore)", "University of Veterinary and Animal Sciences(Lahore)"},
            { "University of Agriculture Faisalabad", "Government College University(Faisalabad)", "Quaid-i-Azam University( Islamabad)", "Hamdard University (Islamabad Campus)"," University of Lahore (Islamabad Campus)", "Benazir Bhutto Shaheed University(Karachi)"," Dow University of Health Sciences (Karachi)", "Jinnah Sindh Medical University (Karachi)", "Lahore College For Women University", "University Of The Punjab (Lahore)", "University of Veterinary and Animal Sciences(Lahore)"}};

    ListView medFieldList;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public medicalFieldFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment medicalFieldFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static medicalFieldFragment newInstance(String param1, String param2) {
        medicalFieldFragment fragment = new medicalFieldFragment();
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
        View v= inflater.inflate(R.layout.fragment_medical_field, container, false);
        medFieldList = v.findViewById(R.id.medicalFieldlist);

        numList = new ArrayList();

        String selectPos = getArguments().getString("position");
        int selectedPos=Integer.parseInt(selectPos);

        for(int i = 1; i<=med[selectedPos].length; i++)
        {
            numList.add(i);
        }



       //int Pos= Integer.valueOf(selectPos);

//        int Pos=1;
//
//
//        for(int i=Pos;i<=Pos;i++)
//        {
//            for(int j=0;j<4;j++)
//            {
//                Array[j]=DVM[Pos][j];
//            }
//
//        }
//
//        Log.d("ArrayOf", String.valueOf(Array));


        medFieldList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int fieldK=0;
                fieldK=position;

               Intent uniIntent= new Intent(getActivity(),UniMedActivity.class);
               uniIntent.putExtra("Uni",String.valueOf(fieldK));

            }
        });

        FieldCustomAdapter fieldCustomAdapter = new FieldCustomAdapter(getActivity(), numList, med,selectedPos);
        medFieldList.setAdapter(fieldCustomAdapter);


        return v;
    }
}