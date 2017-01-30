package com.example.costanza.mada1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity
implements View.OnClickListener{

    private TextView testTextView;
    private Button addButton;
    private Button viewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testTextView = (TextView)findViewById(R.id.testTextView);
        addButton = (Button)findViewById(R.id.addEmployeeButton);
        addButton.setOnClickListener(this);
        viewButton = (Button)findViewById(R.id.viewListButton);
        viewButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.addEmployeeButton:
                Log.d("DEBUG", "DEBUG0");
                setContentView(R.layout.activity_two);
                break;
            case R.id.viewListButton:
                testTextView.setText("View.");
                break;
        }
    }
}
