package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import org.junit.Test;

/**
 * Created by mandeep.condle on 5/29/16.
 */
public class BackendAsyncTaskTest extends AndroidTestCase implements AsyncDelegate {

    private BackendAsyncTask asyncTask;
    private String response;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        asyncTask = new BackendAsyncTask(this);
    }

    @Test
    public void testNonEmptyJoke() {
        assert  (response == null);
        asyncTask.execute();
        assert (response != null);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        this.response = null;
        this.asyncTask = null;
    }

    public void processResponse(String response) {
        this.response = response;
    }
}
