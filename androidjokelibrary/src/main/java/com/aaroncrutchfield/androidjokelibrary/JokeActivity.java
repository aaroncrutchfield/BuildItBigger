package com.aaroncrutchfield.androidjokelibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE = "joke";
    private TextView tvJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        tvJoke = findViewById(R.id.tv_joke);

        Intent intent = getIntent();
        String text;

        if (intent.hasExtra(JOKE))
            text = intent.getStringExtra(JOKE);
        else
            text = "Error loading the joke";

        tvJoke.setText(text);
    }
}
