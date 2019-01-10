package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndPointsAsyncTask extends AsyncTask<Void, Void, String> {

    private static MyApi myApi = null;
    private JokeReceivedInterface jokeReceivedInterface;

    public interface JokeReceivedInterface {
        void onJokeReceived(String joke);
    }

    public EndPointsAsyncTask(JokeReceivedInterface jokeReceivedInterface) {
        this.jokeReceivedInterface = jokeReceivedInterface;
    }

    @Override
    protected String doInBackground(Void... voids) {
        if (myApi == null) {
            MyApi.Builder myApiBuilder = new MyApi.Builder(
                    AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(),
                    null)
                    .setRootUrl("https://builditbigger-227509.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            myApi = myApiBuilder.build();
        }

        try {
            return myApi.retrieveJoke().execute().getData();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        jokeReceivedInterface.onJokeReceived(joke);
    }
}
