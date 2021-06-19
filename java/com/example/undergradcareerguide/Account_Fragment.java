package com.example.undergradcareerguide;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Account_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Account_Fragment extends Fragment {
    TextView name,email,gender,textView;

    FirebaseAuth authData;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Users");
    String uid;
    FirebaseUser user;
    ImageView userProfile;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Account_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Account_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Account_Fragment newInstance(String param1, String param2) {
        Account_Fragment fragment = new Account_Fragment();
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
        View v= inflater.inflate(R.layout.fragment_account_, container, false);

        user = authData.getInstance().getCurrentUser();
        uid=user.getUid();
        loadUserInformation();


        name=v.findViewById(R.id.name);
        email=v.findViewById(R.id.email);
        gender=v.findViewById(R.id.gender);
        textView = v.findViewById(R.id.textVieweMail);
        userProfile=v.findViewById(R.id.profileImage);

        name.setText(HomeScreen.userName);
        email.setText(HomeScreen.userEmail);
        gender.setText(HomeScreen.userGender);
        return v;
    }
    private void loadUserInformation()
    {


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                textView.setText(HomeScreen.userName);



                if(snapshot.child(uid).hasChild("profilePic"))
                {
                    Glide.with(getActivity()).load(snapshot.child(uid).child("profilePic").getValue().toString()).into(userProfile);

                }




            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

                Toast.makeText(getActivity(), "Network Issue ", Toast.LENGTH_SHORT).show();

            }
        });


    }
}