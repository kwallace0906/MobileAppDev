/*
* FILE			: Employee.java
* PROJECT		: PROG3150 - Assignment 1
* PROGRAMMER	: Justin Hergott
* FIRST VERSION	: 2017-02-01
* DESCRIPTION 	: This file holds the class Employee.
*/

package com.example.costanza.mada1;

/*
*	NAME	: Employee
*	PURPOSE	: It will be for storing employee information such as name,
*      	        job, type, and hours work. It also contains a function to be
*         	    used to validate the information.
*/
public class Employee {
    private String firstName;
    private String lastName;
    private String teamName;
    private String jobTitle;
    private String employeeType;
    private int hoursPerWeek;

    //
    // FUNCTION		: Employee - CONSTRUCTOR
    // DESCRIPTION	:
    //		This function sets the default values when a new Employee
    //      is created
    // PARAMETERS	:
    //		None/Void
    // RETURNS		:
    //		None/Void
    //
    public Employee(){
        firstName = "";
        lastName = "";
        teamName = "";
        jobTitle = "";
        employeeType = "";
        hoursPerWeek = 0;
    }

    //
    // FUNCTION		: SetFirstName
    // DESCRIPTION	:
    //		This function sets the first name of the Employee
    // PARAMETERS	:
    //		String name:    the first name to set
    // RETURNS		:
    //		boolean : true on success, false on failure
    //
    public boolean SetFirstName(String name){
        boolean retCode = true;
        if(IsWord(name) == true){
            firstName = name;
        }
        else{
            retCode = false;
        }

        return retCode;
    }

    //
    // FUNCTION		: GetFirstName
    // DESCRIPTION	:
    //		This function gets the first name of the Employee
    // PARAMETERS	:
    //		None/Void
    // RETURNS		:
    //		String  : the first name of the Employee
    //
    public String GetFirstName(){
        return firstName;
    }

    //
    // FUNCTION		: SetLastName
    // DESCRIPTION	:
    //		This function sets the last name of the Employee
    // PARAMETERS	:
    //		String name:    the last name to set
    // RETURNS		:
    //		boolean : true on success, false on failure
    //
    public boolean SetLastName(String name){
        boolean retCode = true;
        if(IsWord(name) == true){
            lastName = name;
        }
        else{
            retCode = false;
        }

        return retCode;
    }

    //
    // FUNCTION		: GetLastName
    // DESCRIPTION	:
    //		This function gets the last name of the Employee
    // PARAMETERS	:
    //		None/Void
    // RETURNS		:
    //		String  : the last name of the Employee
    //
    public String GetLastName(){
        return lastName;
    }

    //
    // FUNCTION		: SetTeamName
    // DESCRIPTION	:
    //		This function sets the team name of the Employee
    // PARAMETERS	:
    //		String name:    the team name to set
    // RETURNS		:
    //		boolean : true on success, false on failure
    //
    public boolean SetTeamName(String name){
        boolean retCode = true;
        if(IsWord(name) == true){
            teamName = name;
        }
        else{
            retCode = false;
        }

        return retCode;
    }

    //
    // FUNCTION		: GetTeamName
    // DESCRIPTION	:
    //		This function gets the team name of the Employee
    // PARAMETERS	:
    //		None/Void
    // RETURNS		:
    //		String  : the team name of the Employee
    //
    public String GetTeamName(){
        return teamName;
    }

    //
    // FUNCTION		: SetJobTitle
    // DESCRIPTION	:
    //		This function sets the job title of the Employee
    // PARAMETERS	:
    //		String name:    the job title to set
    // RETURNS		:
    //		boolean : true on success, false on failure
    //
    public boolean SetJobTitle(String title) {
        boolean retCode = true;
        if(IsWord(title) == true){
            jobTitle = title;
        }
        else{
            retCode = false;
        }

        return retCode;
    }

    //
    // FUNCTION		: GetJobTitle
    // DESCRIPTION	:
    //		This function gets the job title of the Employee
    // PARAMETERS	:
    //		None/Void
    // RETURNS		:
    //		String  : the job title of the Employee
    //
    public String GetJobTitle(){
        return jobTitle;
    }

    //
    // FUNCTION		: SetEmployeeType
    // DESCRIPTION	:
    //		This function sets the type of the Employee
    // PARAMETERS	:
    //		String name:    the type to set
    // RETURNS		:
    //		boolean : true on success, false on failure
    //
    public boolean SetEmployeeType(String type){
        boolean retCode = true;
        if(IsWord(type) == true){
            employeeType = type;
        }
        else{
            retCode = false;
        }

        return retCode;
    }

    //
    // FUNCTION		: GetEmployeeType
    // DESCRIPTION	:
    //		This function gets the type of the Employee
    // PARAMETERS	:
    //		None/Void
    // RETURNS		:
    //		String  : the type of the Employee
    //
    public String GetEmployeeType(){
        return employeeType;
    }

    //
    // FUNCTION		: SetHoursPerWeek
    // DESCRIPTION	:
    //		This function sets the hours per week of the Employee
    // PARAMETERS	:
    //		int hours:    the hours to set
    // RETURNS		:
    //		boolean : true on success, false on failure
    //
    public boolean SetHoursPerWeek(int hours){
        boolean retCode = true;
        if(hours > 0 && hours < 168){
            hoursPerWeek = hours;
        }
        else{
            retCode = false;
        }

        return retCode;
    }

    //
    // FUNCTION		: GetHoursPerWeek
    // DESCRIPTION	:
    //		This function gets the hours per week of the Employee
    // PARAMETERS	:
    //		None/Void
    // RETURNS		:
    //		int     : the hours per week of the Employee
    //
    public int GetHoursPerWeek(){
        return hoursPerWeek;
    }

    //
    // FUNCTION		: IsWord
    // DESCRIPTION	:
    //		This function checks if a string only has characters, a - and/or a '
    // PARAMETERS	:
    //		String s:    the string to check
    // RETURNS		:
    //		boolean : true if it satisfies, false if it doesn't
    //
    public boolean IsWord(String s){
        return s.matches("[a-zA-Z-']+");
    }
}
