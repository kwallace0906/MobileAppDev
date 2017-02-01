/*
* FILE			: EmployeeAdapter.java
* PROJECT		: PROG3150 - Assignment 1
* PROGRAMMER	: Justin Hergott
* FIRST VERSION	: 2017-02-01
* DESCRIPTION 	: This file holds the class EmployeeAdapter.
*/

package com.example.costanza.mada1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/*
*	NAME	: EmployeeAdapter
*	PURPOSE	: This class is used to fill in a customer ListView from a
*               list of Employee objects.
*/
public class EmployeeAdapter extends ArrayAdapter<Employee> {

    private final Context context;
    private final ArrayList<Employee> values;

    //
    // FUNCTION		: EmployeeAdapter - CONSTRUCTOR
    // DESCRIPTION	:
    //		This function sets the values when a new EmployeeAdapter
    //      is created
    // PARAMETERS	:
    //		Context context             : the current context
    //      ArrayList<Employee> theList : the list of employees to fill in the view with
    // RETURNS		:
    //		None/Void
    //
    public EmployeeAdapter(Context context, ArrayList<Employee> theList){
        super(context, -1, theList);
        this.context = context;
        this.values = theList;
    }

    //
    // FUNCTION		: getView
    // DESCRIPTION	:
    //		This function gets the view that is created for each Employee Object
    // PARAMETERS	:
    //		int position        : the position in the list to get info from
    //      View currentView    : the current view
    //      ViewGroup parent    : the parent view group
    // RETURNS		:
    //		View    : the view created for that Employee
    //
    @Override
    public View getView(int position, View currentView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.employeeFullName);
        TextView secondTextView = (TextView) rowView.findViewById(R.id.employeeTitleAndType);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.employeePic);
        textView.setText(values.get(position).GetFirstName() + " " + values.get(position).GetLastName());
        secondTextView.setText(values.get(position).GetJobTitle() + " - " + values.get(position).GetEmployeeType());
        return rowView;
    }
}
