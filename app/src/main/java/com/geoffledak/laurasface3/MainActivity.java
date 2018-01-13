package com.geoffledak.laurasface3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String TAG = MainActivity.class.getSimpleName();

    TextView mChangingText;
    Button mChangingButton;
    boolean mSwitch;

    Button mStartKittyActivity;

    Button mAddNumberButton;
    TextView mAddNumberTextView;
    int mNumberValue = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        findViews();
        setClickListeners();
    }


    private void findViews() {

        mChangingText = (TextView) findViewById(R.id.changing_text);
        mChangingButton = (Button) findViewById(R.id.changing_button);
        mStartKittyActivity = (Button) findViewById(R.id.start_kitty_activity);
        mAddNumberButton = (Button) findViewById(R.id.add_number_button);
        mAddNumberTextView = (TextView) findViewById(R.id.add_number_text);
    }


    private void setClickListeners() {

        mChangingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                flipText();
            }
        });


        mStartKittyActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                startKittyActivity();
            }
        });

        mAddNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateNumberTextView(5);
            }
        });
    }



    private void flipText() {

        if (mSwitch){
            mChangingText.setText("Balls");
            mSwitch = false;
        }
        else {
            mChangingText.setText("Double muh nutz!");
            mSwitch = true;
        }
    }


    private void startKittyActivity() {

        Intent oneOff;
        oneOff = new Intent(MainActivity.this, DetailActivity.class);
        startActivity(oneOff);
    }


    private void updateNumberTextView(int theValue) {

        mNumberValue = mNumberValue + theValue;

        Log.v(TAG, "The value of mNumberValue is " + mNumberValue);

        mAddNumberTextView.setText( "The number is " + mNumberValue );
    }





}

