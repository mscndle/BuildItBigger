package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.mcondle.builditbigger.gradle.udacity.com.backend.myApi.MyApi;

import java.io.IOException;

/**
 * This code has been taken from https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
 *
 * Created by mandeep.condle on 5/28/16.
 */
public class BackendAsyncTask extends AsyncTask<Void, Void, String> {

    private AsyncDelegate delegate = null;
    private static MyApi myApi = null;
    private Context context;

    public BackendAsyncTask(AsyncDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApi == null) {

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApi = builder.build();
        }
//
//        context = params[0].first;
//        String name = params[0].second;

//        try {
//            return myApi..execute().getData();
//        } catch (IOException e) {
//            return e.getMessage();
//        }

        try {
            return myApi.getJoke().execute().getJoke();
//            return myApi.sayHi("hello").execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
//        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        delegate.processResponse(result);
    }
}
