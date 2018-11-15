package com.ephantus.royaldesigns;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.findLogInButton) Button mLoginButton;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;
    @BindView(R.id.findSignUpButton) Button mSignUpButton;
    @BindView(R.id.mottoEntry) TextView mMottoEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface logoFonts = Typeface.createFromAsset(getAssets(), "fonts/Black_Ops_One/BlackOpsOne-Regular.ttf");
        mAppNameTextView.setTypeface(logoFonts);

        Typeface robsterFonts = Typeface.createFromAsset(getAssets(), "fonts/Rochester/Rochester-Regular.ttf");
        mMottoEntry.setTypeface(robsterFonts);




        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Signup.class);
                startActivity(intent);
            }
        });
    }
}