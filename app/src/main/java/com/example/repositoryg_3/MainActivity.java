package com.example.repositoryg_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String TAG = "PW3";
    public static final String INPUT = "input";
    public static final String SHARED_PREFS = "sharedPrefs";
    private String inp_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //preference
        loadPreference();
        updateView();
        //dropdown list
        Spinner spinThemes = findViewById(R.id.theme_choice);
        spinThemes.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adp = ArrayAdapter.createFromResource(this, R.array.themes, android.R.layout.simple_spinner_item);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinThemes.setAdapter(adp);
    }
    public void onButtonClickSave(View view){
        Log.d(TAG, "I clicked save");
        EditText input = findViewById(R.id.txtInput);
        String prefSave = input.getText().toString();
        SharedPreferences preference = getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putString(INPUT,prefSave);
        editor.apply();
        Toast.makeText(this,"Saved preference",Toast.LENGTH_SHORT).show();
    }
    public void updateView(){
        EditText input = findViewById(R.id.txtInput);
        input.setText(inp_text);
    }
    public void loadPreference(){
        SharedPreferences preference = getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE);
        inp_text = preference.getString(INPUT,"");
    }
    public void onButtonClickNext(View view){
        Log.d(TAG, "I clicked next");
        Intent activityIntent = new Intent(this, NextActivity.class);
        startActivity(activityIntent);
    }
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        parent.getItemAtPosition(pos);
        String choice = parent.getItemAtPosition(pos).toString();
        Log.d(TAG, id + "ID" + "Chosen theme: " + choice);
        switch ((int)id) {
            case 0:
                if(id == 0){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                }
                break;
            case 1:
                if (id == 1) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                break;
            case 2:
                if (id == 2) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                break;
            default:
                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.d(TAG, " Nothing selected");
    }
}