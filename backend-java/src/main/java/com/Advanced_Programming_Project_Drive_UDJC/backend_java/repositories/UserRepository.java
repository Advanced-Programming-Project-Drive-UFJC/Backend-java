/*
 * This module contains the data of all user registered in the system
 */
package com.Advanced_Programming_Project_Drive_UDJC.backend_java.repositories;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;

import com.Advanced_Programming_Project_Drive_UDJC.backend_java.dataObjects.UserData;

@Repository
public class UserRepository {

    private List<UserData> users = new ArrayList<>();
    
    private final String filePath = "data/users.json";

    @PostConstruct
    public void init(){
        System.out.println("Loading users data...");
        this.users = JSONOperations.loadData(this.filePath, UserData.class);
    }

    public Optional<UserData> getUserByName(String username) {
        for(UserData user : this.users) 
            if(user.username.equals(username)) 
                return Optional.of(user);
        return Optional.empty();
    }

    public Optional<UserData> authUser(String username, String password) {
        for(UserData user : this.users) 
            if (user.username.equals(username) && user.password.equals(password)) 
                return Optional.of(user);
        
        return Optional.empty();
    }

    public boolean addUser(String username, String password) {
        for(UserData user : this.users) 
            if (user.username.equals(username)) 
                return false;
        UserData new_user = new UserData(username, password);
        this.users.add(new_user);
        JSONOperations.saveData(this.filePath, this.users);
        return true;
    }

    public boolean deleteUser(String username, String password) {

        Optional<UserData> user = this.getUserByName(username);
        boolean result = false;
        if (user.isPresent()) {
            if ( user.get().username.equals(username) && user.get().password.equals(password)) {
                this.users.remove(user.get());
                JSONOperations.saveData(this.filePath, this.users);
                result = true;
            }
        }
        return result;        
    }

    public boolean updatePassword(String username, String password) {
        boolean result = false;
        Optional<UserData> user = this.getUserByName(username);
        if(user.isPresent()) {
            if ( user.get().username.equals(username) && user.get().password.equals(password)) {
                user.get().password = password;
                result = true;
                JSONOperations.saveData(this.filePath, this.users);
            }
        }
        
        return result;
    }
    
}