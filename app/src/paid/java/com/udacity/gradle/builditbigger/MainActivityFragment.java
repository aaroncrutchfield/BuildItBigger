package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.aaroncrutchfield.androidjokelibrary.JokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment
        implements EndPointsAsyncTask.JokeReceivedInterface{

    private Button btnTellJoke;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        btnTellJoke = root.findViewById(R.id.btn_tell_joke);
        btnTellJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tellJoke();
            }
        });

        return root;
    }

    private void tellJoke() {
        EndPointsAsyncTask asyncTask = new EndPointsAsyncTask(this);
        asyncTask.execute();
    }

    @Override
    public void onJokeReceived(String joke) {
        Intent intent = new Intent(getContext(), JokeActivity.class);
        intent.putExtra("joke", joke);
        startActivity(intent);
    }
}