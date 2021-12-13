package com.example.repositoryg_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {
    String TAG = "PW3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
    }
    public void onButtonClickBack(View view){
        Log.d(TAG, "I clicked it back");
        Intent activityIntent = new Intent(this, MainActivity.class);
        startActivity(activityIntent);
        activityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    }
    public void onButtonClickLoad(View view){
        TextView outPref = findViewById(R.id.textView);
        SharedPreferences preference = getSharedPreferences(MainActivity.SHARED_PREFS,Context.MODE_PRIVATE);
        String output = preference.getString(MainActivity.INPUT,"");
        if(output.length() == 0){
            Toast.makeText(this,"Nothing found", Toast.LENGTH_SHORT).show();
        }else{
            outPref.setText(output);
        }
    }
}