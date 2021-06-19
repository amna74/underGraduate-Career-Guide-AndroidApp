package com.example.undergradcareerguide;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.undergradcareerguide.UsersData.Users;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    static int loginCheck=0;
    EditText email,pass;
    Button login,google;
    private LoginButton loginButton; //facebook button widget
    Boolean isemail,ispass,ischeck;
    FirebaseAuth authData;
    ProgressDialog dialog;
   public static String userEmail;
           String userPass;
    GoogleSignInClient mGoogleSignInClient;  //google
    FirebaseDatabase firebaseDatabase;
    private FirebaseUser user;
    private static final String EMAIL = "email";
    private static final String TAG = "FbAuth";
    private CallbackManager  callbackManager;  //Facebook


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar properties
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        dialog=new ProgressDialog(MainActivity.this);
        dialog.setTitle("login");
        dialog.setMessage("logging into your account");
        authData=FirebaseAuth.getInstance();

//        For Current User

        if(loginCheck!=1)
        {
            if(authData.getCurrentUser()!=null)
            {
                Intent home = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(home);
            }

        }

        firebaseDatabase=FirebaseDatabase.getInstance();

        email=findViewById(R.id.emailad);
        pass=findViewById(R.id.passs);
        login=findViewById(R.id.login);
        google=findViewById(R.id.google);

        //For Facebook
        callbackManager= CallbackManager.Factory.create();
        loginButton = (LoginButton) findViewById(R.id.fBTn);
        loginButton.setPermissions(Arrays.asList(EMAIL));
        // If you are using in a fragment, call loginButton.setFragment(this);

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                handleFacebookAccessToken(loginResult.getAccessToken());

            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                Log.d(TAG,"onError: "+exception.getMessage());

            }
        });




        //For Google SignIn
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkLogin();

                if(ischeck)
                {
                    dialog.show();
                    dialog.setTitle("Loading");

                    authData.signInWithEmailAndPassword(userEmail,userPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            dialog.dismiss();
                            if(task.isSuccessful())
                            {
                                finish();
                                Intent home = new Intent(getApplicationContext(), HomeScreen.class);
                                Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(home);
                            }

                            else
                            {
                                Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });


                }

            }
        });


        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });



    }





    public void checkLogin() {

        userEmail=email.getText().toString();
        userPass=pass.getText().toString();

        if(userEmail.isEmpty())
        {
            email.setError("Email is Required");
            isemail=false;
        }
        else
        {

            isemail=true;
        }

        if(userPass.isEmpty())
        {
            pass.setError("Password is Required");
            ispass=false;
        }
        else
        {
            ispass=true;
        }


        if(isemail && ispass)
        {

            ischeck=true;
        }
        else
        {

            ischeck=false;
        }
    }

    public void btn_signup(View view) {


        Intent signup = new Intent(getApplicationContext(), SignUp.class);
        startActivity(signup);

    }


    //chOOSE any random
    int RC_SIGN_IN=55;

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d("TAG", "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w("TAG", "Google sign in failed", e);
            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        dialog.show();
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        authData.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithCredential:success");
                            FirebaseUser user = authData.getCurrentUser();

                            Users users = new Users();
                           if(user!=null)
                           {
                               users.setUserid(user.getUid());
                               users.setUserName(user.getDisplayName());
                               users.setProfilePic(user.getPhotoUrl().toString());
                               users.setEmail(user.getEmail());
                           }

                            firebaseDatabase.getReference().child("Users").child(user.getUid()).setValue(users);
                           dialog.dismiss();
                            finish();
                            Intent home = new Intent(getApplicationContext(), HomeScreen.class);
                            Toast.makeText(MainActivity.this, "Sign In with google", Toast.LENGTH_SHORT).show();
                            startActivity(home);
                           // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithCredential:failure", task.getException());
                           // updateUI(null);
                        }
                    }
                });
    }


    //For Facebook

    private void handleFacebookAccessToken(AccessToken token) {
        dialog.show();
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        authData.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        if (task.isSuccessful()) {

                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = authData.getCurrentUser();

                            Users users = new Users();
                           if(user!=null)
                           {
                               users.setUserid(user.getUid());
                               users.setUserName(user.getDisplayName());
                               users.setProfilePic(user.getPhotoUrl().toString());
                               users.setEmail(user.getEmail());
                           }

                            firebaseDatabase.getReference().child("Users").child(user.getUid()).setValue(users);
                           dialog.dismiss();
                            finish();
                            Intent homes = new Intent(getApplicationContext(), HomeScreen.class);
                            Toast.makeText(MainActivity.this, "Sign In with Facebook", Toast.LENGTH_SHORT).show();
                            startActivity(homes);
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
//                            Toast.makeText(MainActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
                            Intent homes = new Intent(getApplicationContext(), HomeScreen.class);
                            dialog.dismiss();
                            Toast.makeText(MainActivity.this, "Sign In with Facebook", Toast.LENGTH_SHORT).show();
                            startActivity(homes);
//                            updateUI(null);
                        }
                    }
                });
    }

//    @Override
//    protected void onStart() {
//
//        super.onStart();
//        if (authData.getCurrentUser() != null) {
//            Intent homes = new Intent(MainActivity.this, HomeScreen.class);
//
//            startActivity(homes);
//        }
//    }
}