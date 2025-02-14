package com.Advanced_Programming_Project_Drive_UDJC.backend_java.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Advanced_Programming_Project_Drive_UDJC.backend_java.dataObjects.UserData;
import com.Advanced_Programming_Project_Drive_UDJC.backend_java.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserData> getUserByName(String name) {
        return userRepository.getUserByName(name);
    }

    public Optional<UserData> authUser(String username, String password) {
        if (password == null || username == null) {
            return Optional.empty();
        }
        return userRepository.authUser(username, password);
    }

    public String addUser(String username, String password) {
        if (username == null || password == null) {
            return "Metodo falla en repository";
        }
        return userRepository.addUser(username, password);
    }

    public boolean deleteUser(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        return userRepository.deleteUser(username, password);
    }

    public Boolean updatePassword(String username, String password) {
        if ( username == null || password == null) {
            return false;
        }
        return userRepository.updatePassword(username, password);
    }
    
}
