package com.mcondle.droidjoker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by mandeep.condle on 5/28/16.
 */
public class JokeDetailActivity extends AppCompatActivity {

    private static final String JOKE_ID = "joke_id_haha";

    private TextView jokeTextView;
    private String joke;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_detail);
        jokeTextView = (TextView) findViewById(R.id.joke_textView);
    }

    @Override
    public void onResume() {
        super.onResume();

        joke = getIntent().getStringExtra(JOKE_ID);

        if (joke != null) {
            jokeTextView.setText(joke);
        } else {
            jokeTextView.setText("no joke :(");
        }
    }
}
