/*
* FILE			: ViewEmployeesActivity.java
* PROJECT		: PROG3150 - Assignment 1
* PROGRAMMER	: Justin Hergott
* FIRST VERSION	: 2017-02-01
* DESCRIPTION 	: This file holds the class ViewEmployeeActivity.
*/

package com.example.costanza.mada1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
*	NAME	: ViewEmployeesActivity
*	PURPOSE	: This class determines what happens when this activity is called.
*               When it is created it will fill a spinner with all the team names
*               from the list, and a list view of all the employees.
*/
public class ViewEmployeesActivity extends Activity {
    private Spinner sortSpinner;
    private ListView theList;

    //
    // FUNCTION		: onCreate
    // DESCRIPTION	:
    //		This function fills the spinner and the list view when the Activity is created.
    // PARAMETERS	:
    //		Bundle savedInstanceState   : the saved instance state
    // RETURNS		:
    //		None/Void
    //
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

    }

    //
    // FUNCTION		: FillTheList
    // DESCRIPTION	:
    //		This function fills the list view with Employees that have the team name selected.
    // PARAMETERS	:
    //		String sortWord : the word to sort by (teamName)
    // RETURNS		:
    //		None/Void
    //
    public void FillTheList(String sortWord){
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
