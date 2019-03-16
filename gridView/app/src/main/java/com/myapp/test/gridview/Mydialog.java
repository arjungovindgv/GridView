package com.myapp.test.gridview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Mydialog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydialog);
        Intent intent = getIntent();
        if (intent!=null){
            String countryName =  intent.getStringExtra("CountryName");
           int imageId =  intent.getIntExtra("CountryImage",R.drawable.india);
            ImageView imageView = findViewById(R.id.myDialogImg);
            imageView.setImageResource(imageId);
            TextView textView = findViewById(R.id.myDialogText);
            textView.setText(countryName);
        }    }

    public void closeDialogue(View v){
        finish();

    }}
