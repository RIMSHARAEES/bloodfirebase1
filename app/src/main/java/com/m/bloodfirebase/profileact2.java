package com.m.bloodfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class profileact2 extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth firebaseAuth;
    private TextView logout;
    private Button logoutsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileact2);
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, loginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        logout = (TextView) findViewById(R.id.logout);

        logoutsubmit = (Button) findViewById(R.id.logoutsubmit);


        logoutsubmit.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view==logoutsubmit){
            firebaseAuth.signOut();
            finish();

            startActivity(new Intent(this,loginActivity.class));
        }

    }
}
