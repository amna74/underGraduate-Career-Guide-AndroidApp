package com.example.undergradcareerguide;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.undergradcareerguide.UsersData.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;
import static com.example.undergradcareerguide.MainActivity.loginCheck;

public class SignUp extends AppCompatActivity {

//    ActivitySignUpBinding binding;
    private FirebaseAuth authdata;
     FirebaseDatabase mDatabase;

     ProgressDialog dialog;

    EditText fname,lname,email,pass,conpass;
    RadioGroup radioGroup;
    RadioButton male,female;
    Button register;
    TextView alreadyAccount;


    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{6,20}" +               //at least 6 characters
                    "$");




    String FirstName,LastName, Email, Pass, ConfirmPass,Gender=null;
    Boolean isFirstName,isLastName,isEmail,isPass,isConpass,check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding= ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().hide();

        fname = findViewById(R.id.fname);
        lname =findViewById(R.id.lname);
        email =findViewById(R.id.email);
        pass =findViewById(R.id.pass);
        conpass =findViewById(R.id.confirmpass);
        radioGroup =findViewById(R.id.radiogroup);
        male =findViewById(R.id.radiomale);
        female =findViewById(R.id.radiofemale);
        register =findViewById(R.id.register);
        alreadyAccount=findViewById(R.id.alreadAccount);


        dialog=new ProgressDialog(SignUp.this);
        dialog.setTitle("Creating Account");
        dialog.setMessage("Creating your new account");
        authdata =FirebaseAuth.getInstance();
        mDatabase=FirebaseDatabase.getInstance();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



               checkDataEntered();


               if(check)
               {
                   dialog.show();

                   authdata.createUserWithEmailAndPassword(Email, Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>()
                   {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {

                           dialog.dismiss();
                           if(task.isSuccessful())
                           {
                               Users userr = new Users(FirstName,LastName, Email, Pass, ConfirmPass, Gender);
                               String id = task.getResult().getUser().getUid();
                               mDatabase.getReference().child("Users").child(id).setValue(userr);

                               makeText(SignUp.this, "Account created successfully", LENGTH_SHORT).show();
                               loginCheck=1;
                               startActivity(new Intent(getApplicationContext(),MainActivity.class));

                           }

                           else
                           {
                               makeText(SignUp.this, task.getException().getMessage(), LENGTH_SHORT).show();
                           }

                       }
                   });


               }










            }
        });

        alreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alreadyAccount.setTextColor(Color.BLUE);
                Intent logins = new Intent(SignUp.this,MainActivity.class);
                startActivity(logins);

            }
        });

    }


     public void checkDataEntered() {



         FirstName = fname.getText().toString();
         LastName = lname.getText().toString();
         Email = email.getText().toString();
         Pass = pass.getText().toString();
         ConfirmPass = conpass.getText().toString();

        if(male.isChecked())
        {
            Gender=male.getText().toString();

        }
        else if(female.isChecked())
         {
             Gender=female.getText().toString();

         }




         if (FirstName.isEmpty()) {
             Toast t = Toast.makeText(this, "You must enter first name to register", LENGTH_LONG);
             t.show();
             isFirstName=false;
         }
         else
         {
             isFirstName=true;

         }



         if (LastName.isEmpty()) {
             lname.setError("Last Name is Required");
             isLastName=false;

         }
         else
         {
             isLastName=true;
         }


         if (Email.isEmpty()) {
             email.setError("Email is Required");
             isEmail=false;

         }
         else if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches())
         {
             email.setError("Enter Valid Email Address");
             isEmail=false;
         }
         else
         {
             isEmail=true;
         }



         if (Pass.isEmpty()) {
             pass.setError("Password is Required");
             isPass=false;

         }
         else if(Pass.length()<6)
         {
             pass.setError("length should be at least 6 characters");
             isPass=false;
         }
         else if (!PASSWORD_PATTERN.matcher(Pass).matches()) {
             pass.setError("Password too weak");
             isPass=false;
         }
         else
         {
             isPass=true;
         }


         if (ConfirmPass.isEmpty()) {
             conpass.setError("Password is Required");
             isConpass=false;

         }


         else if (!ConfirmPass.equals(Pass)) {
             conpass.setError("Enter the same Password");
             isConpass=false;

         }

         else
         {
             isConpass=true;
         }




         if(isFirstName && isLastName && isEmail && isPass && isConpass)
         {

             check =true;

         }
         else
         {
             check=false;
         }

     }


}
