package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class EndPointsAsyncTaskTest {

    @Test
    public void testDoInBackground() {
        try {
            EndPointsAsyncTask.JokeReceivedInterface jokeReceivedInterface = new EndPointsAsyncTask.JokeReceivedInterface() {
                @Override
                public void onJokeReceived(String joke) {

                }
            };
            EndPointsAsyncTask asyncTask = new EndPointsAsyncTask(jokeReceivedInterface);

            asyncTask.execute();
            String jokeResult = asyncTask.get(30, TimeUnit.SECONDS);

            assertNotNull(jokeResult);
            assertTrue(jokeResult.length() > 0);
        } catch (Exception e) {
            Log.e("Test:", " Timed out");
        }

    }
}