package com.example.costanza.mada1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Costanza on 2017-01-30.
 */

public class SecondActivity extends Activity {

    private Spinner sortSpinner;
    private ListView theList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewing_employees);
        List<Employee> viewingList = MainActivity.theTeam.GetFullList();

        //Populate the spinner
        List<String> spinnerItems = new ArrayList<String>();
        spinnerItems.add("All");
        for(Iterator<Employee> i = viewingList.iterator(); i.hasNext();){
            Employee temp = i.next();
            if(!spinnerItems.contains(temp.GetTeamName())){
                spinnerItems.add(temp.GetTeamName());
            }
        }
        ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerItems);
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortSpinner = (Spinner) findViewById(R.id.teamPickerSpinner);
        sortSpinner.setAdapter(spinAdapter);
        sortSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                FillTheList(sortSpinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Do nothing.
            }
        });

        //Populate the list
        FillTheList(sortSpinner.getSelectedItem().toString());

        /*Log.d("DEBUG", "Showing List Screen");
        for(Iterator<Employee> i = viewingList.iterator(); i.hasNext();){
            Employee temp = i.next();
            Log.d("DEBUG", temp.GetLastName());
        }*/
    }

    public void FillTheList(String sortWord){
        /*List<Employee> viewingList = MainActivity.theTeam.GetFullList();
        List<String> listItems = new ArrayList<String>();
        //Populate the list of the names to be in the list view
        for(Iterator<Employee> i = viewingList.iterator(); i.hasNext();){
            Employee temp = i.next();
            if(sortWord.equals("All")){
                listItems.add(temp.GetFirstName() + " " + temp.GetLastName());
            }
            else{
                if(temp.GetTeamName().equals(sortWord)){
                    listItems.add(temp.GetFirstName() + " " + temp.GetLastName());
                }
            }
        }
        //Create adapter for the list view
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        theList = (ListView) findViewById(R.id.employeeListView);
        theList.setAdapter(listAdapter);*/
        List<Employee> viewingList = MainActivity.theTeam.GetFullList();
        ArrayList<Employee> listItems = new ArrayList<Employee>();
        //Populate the list of the names to be in the list view
        for(Iterator<Employee> i = viewingList.iterator(); i.hasNext();){
            Employee temp = i.next();
            if(sortWord.equals("All")){
                listItems.add(temp);
            }
            else{
                if(temp.GetTeamName().equals(sortWord)){
                    listItems.add(temp);
                }
            }
        }
        //Create adapter for the list view
        EmployeeAdapter listAdapter = new EmployeeAdapter(this, listItems);
        theList = (ListView) findViewById(R.id.employeeListView);
        theList.setAdapter(listAdapter);
    }
}
