package com.alorma.multialarm;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.bugsense.trace.BugSenseHandler;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BugSenseHandler.initAndStartSession(this, "bc8e43c4");
    }
    
}
