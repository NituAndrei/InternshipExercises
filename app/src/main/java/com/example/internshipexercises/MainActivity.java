package com.example.internshipexercises;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private int IncrementValue = 0;

    private TextView IncrementTV;
    private Button IncrementBT;

    private void initViews(){
        IncrementTV = findViewById(R.id.label_counter_tv);
        IncrementBT = findViewById(R.id.increment_bt);

        IncrementTV.setText(IncrementValue + "");
        IncrementBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IncrementValue++;
                IncrementTV.setText(IncrementValue + "");
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            IncrementValue = savedInstanceState.getInt("IncValue");
            IncrementTV.setText(IncrementValue + "");
        }
        catch (Exception e){
            Log.d(TAG, "no IncValue");
        }
        setContentView(R.layout.activity_main);
        initViews();
        Log.d(TAG, "Sal din onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onCreate; app exists but is invisible");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop; clear memory here");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "save");
        outState.putInt("IncValue", IncrementValue);
        super.onSaveInstanceState(outState);
    }

//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        Log.d(TAG, "restore");
//        IncrementValue = savedInstanceState.getInt("IncValue");
//        IncrementTV.setText(IncrementValue);
//    }
}
