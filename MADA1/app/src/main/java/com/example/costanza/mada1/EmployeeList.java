/*
* FILE			: EmployeeList.java
* PROJECT		: PROG3150 - Assignment 1
* PROGRAMMER	: Justin Hergott
* FIRST VERSION	: 2017-02-01
* DESCRIPTION 	: This file holds the class EmployeeList.
*/

package com.example.costanza.mada1;

import java.util.ArrayList;
import java.util.List;

/*
*	NAME	: EmployeeList
*	PURPOSE	: It will be for storing Employee objects in a List object.
*               It has an Add function to add an employee to the list and
*               will return error codes depending on any errors.
*/
public class EmployeeList {
    private List<Employee> empList = new ArrayList<Employee>();

    public static final int FNAME_ERROR = 100;
    public static final int LNAME_ERROR = 101;
    public static final int TNAME_ERROR = 102;
    public static final int JTITLE_ERROR = 103;
    public static final int ETYPE_ERROR = 104;
    public static final int HOURS_ERROR = 105;

    //
    // FUNCTION		: EmployeeList - CONSTRUCTOR
    // DESCRIPTION	:
    //		This function does nothing when a new object is initialized.
    // PARAMETERS	:
    //		None/Void
    // RETURNS		:
    //		None/Void
    //
    public EmployeeList(){
        //Do nothing
    }

    //
    // FUNCTION		: GetFullList
    // DESCRIPTION	:
    //		This function returns the full list of Employees
    // PARAMETERS	:
    //		None/Void
    // RETURNS		:
    //		List<Employee>  : the list of Employees
    //
    public List<Employee> GetFullList(){
        return empList;
    }

    //
    // FUNCTION		: AddEmployee
    // DESCRIPTION	:
    //		This function adds an Employee to the List. It will check each parameter to see if it is valid.
    // PARAMETERS	:
    //		String firstName    : the first name of the employee
    //      String lastName     : the last name of the employee
    //      String teamName     : the team name of the employee
    //      String jobTitle     : the job title of the employee
    //      String employeeType : the type of the employee
    //      int hoursPerWeek    : the hours per week of the employee
    // RETURNS		:
    //		int     : 0 on success, a constant code if showing which parameter failed first.
    //
    //Returns 0 on success, error code on failure
    public int AddEmployee(String firstName, String lastName, String teamName, String jobTitle, String employeeType, int hoursPerWeek){
        Employee empToAdd = new Employee();
        int retCode = 0;

        //Try to set the first name
        if(empToAdd.SetFirstName(firstName) == true){
            //Try to set the last name
            if(empToAdd.SetLastName(lastName) == true){
                //Try to set the team name
                if(empToAdd.SetTeamName(teamName) == true){
                    //Try to set the job title
                    if(empToAdd.SetJobTitle(jobTitle) == true){
                        //try to set employee type
                        if(empToAdd.SetEmployeeType(employeeType) == true){
                            //Try to set hours per week
                            if(empToAdd.SetHoursPerWeek(hoursPerWeek) == true){
                                empList.add(empToAdd);
                            }
                            else{
                                retCode = HOURS_ERROR;
                            }
                        }
                        else{
                            retCode = ETYPE_ERROR;
                        }
                    }
                    else{
                        retCode = JTITLE_ERROR;
                    }
                }
                else{
                    retCode = TNAME_ERROR;
                }
            }
            else{
                retCode = LNAME_ERROR;
            }
        }
        else{
            retCode = FNAME_ERROR;
        }

        return retCode;
    }
}
