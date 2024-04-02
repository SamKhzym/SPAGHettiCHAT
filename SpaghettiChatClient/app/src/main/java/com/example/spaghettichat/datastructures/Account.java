package com.example.spaghettichat.datastructures;

public class Account {

    private String employeeId, firstName, lastName;
    private boolean isAdmin;

    public Account(String employeeId, String firstName, String lastName, boolean isAdmin) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAdmin = isAdmin;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() { return firstName + " " + lastName; }

}
