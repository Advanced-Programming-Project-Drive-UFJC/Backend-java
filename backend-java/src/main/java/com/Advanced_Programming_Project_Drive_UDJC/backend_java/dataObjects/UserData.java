/*
 * This module contains a DAO Structure for users 
 */
package com.Advanced_Programming_Project_Drive_UDJC.backend_java.dataObjects;

public class UserData {

    public String username;
    public String password;

    public UserData(){
    }
    public UserData(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
