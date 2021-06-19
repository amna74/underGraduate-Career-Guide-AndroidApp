package com.example.undergradcareerguide.Computer;

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
 * Use the {@link ITFieldFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ITFieldFragment extends Fragment {

    ArrayList numList;
    String Array[];

    String ComField[][]={
            {"University of Engineering and Technology (UET)", "COMSATS Institute of Information Technology, Islamabad", "National University Of Sciences And Technology (NUST), Islamabad", "Qurtuba University, D.I.Khan", "GIKI ( Ghulam Ishaq Khan University)"},
            { "GIKI ( Ghulam Ishaq Khan University)", "University Of Engineering And Technology (UET)", "Quaid-i-Azam University( Islamabad)", "COMSATS Institute of Information Technology, Islamabad"," FAST University Islamabad", "Lahore University of Management Sciences (LUMS)"," Institute of Business Administration (IBA), Karachi", "Air University, Islamabad", "Lahore College For Women University", "University Of The Punjab (Lahore)", "Qurtuba University, D.I.Khan"},
            {"COMSATS, Islamabad", "Ghulam Ishaq Khan Institute of Engineering Sciences and Technology", "NU-FAST","Institute of Space Technology, Islamabad", "University of Engineering & Technology, Peshawar", "Air University, Islamabad"," Quaid-e-Azam University(ISB)", "MUET, Sindh", "Pir Mehr Ali Shah Arid Agriculture University(Rawalpindi)", "Government College University(Faisalabad)", "NED, Karachi"},
            { "The Islamia University Of Bahawalpur", "Air University	Islamabad"," Comsats University	Islamabad", "National University Of Computer And Emerging Sciences, Islamabad"," Air University, Aerospace & Aviation Campus Kamra", "Khawaja Fareed University Of Engineering & Information Technology	Rahim Yar Khan", "Institute Of Southern Punjab	Multan", " Riphah International University, Faisalabad Campus"},
            {" Abbottabad University Of Science And Technology	Abbottabad", "The Islamia University Of Bahawalpur", "University Of Haripur", "National University Of Computer And Emerging Sciences, Islamabad", "Comsats University	Islamabad"},
            { "Comsats University	Islamabad", " Institute Of Space Technology	Islamabad", "Quaid-i-Azam University( Islamabad)", "National University Of Science & Technology	Islamabad"," University of Lahore (Islamabad Campus)", "University Of Karachi"," Pir Mahar Ali Shah Arid Agriculture University	Rawalpindi", "Institute Of Space Technology (sub Campus)", "University Of The Punjab (Lahore)"}
    };

    ListView medFieldList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ITFieldFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ITFieldFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ITFieldFragment newInstance(String param1, String param2) {
        ITFieldFragment fragment = new ITFieldFragment();
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
        View  v= inflater.inflate(R.layout.fragment_i_t_field, container, false);
        medFieldList = v.findViewById(R.id.ComFieldlist);

        numList = new ArrayList();

        String selectPos = getArguments().getString("position");
        int selectedPos=Integer.parseInt(selectPos);

        for(int i = 1; i<=ComField[selectedPos].length; i++)
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





        FieldCustomAdapter fieldCustomAdapter = new FieldCustomAdapter(getActivity(), numList, ComField,selectedPos);
        medFieldList.setAdapter(fieldCustomAdapter);


        return v;
    }

}