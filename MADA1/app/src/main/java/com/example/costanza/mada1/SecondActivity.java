package com.example.costanza.mada1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Costanza on 2017-01-30.
 */

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        Log.d("DEBUG", "DEBUG1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Log.d("DEBUG", "DEBUG2");
    }
}
