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
    public static EmployeeList theTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testTextView = (TextView)findViewById(R.id.testTextView);
        addButton = (Button)findViewById(R.id.addEmployeeButton);
        addButton.setOnClickListener(this);
        viewButton = (Button)findViewById(R.id.viewListButton);
        viewButton.setOnClickListener(this);
        theTeam = new EmployeeList();
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.addEmployeeButton:
                theTeam.AddEmployee("Justin", "hergott", "RIM", "Captain", "Full-Time", 40);
                theTeam.AddEmployee("Tyler", "hergott", "Brock", "Captain", "Full-Time", 40);
                break;
            case R.id.viewListButton:
                testTextView.setText("View.");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                break;
        }
    }
}
