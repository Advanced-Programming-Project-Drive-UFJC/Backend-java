package com.Advanced_Programming_Project_Drive_UDJC.backend_java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Advanced_Programming_Project_Drive_UDJC.backend_java.services.FolderService;

@RestController
public class FolderController {

    @Autowired
    private FolderService folderService;
    /*
     * This class is responsible for the folder operations.
     * 
     */

    @PostMapping("/send-user_root")
    /*
     * This method sends the user root to the FastAPI.
     * Args:
     * username: String
     * Returns:
     * String
     */
    public String sendUserRootToFastApi(@RequestParam String username) {
        /*
         * This method sends the user root to the FastAPI.
         * Args:
         * username: String
         * Returns:
         * String
         */
        return folderService.sendUserRootToFastApi(username);
    }

    @DeleteMapping("/delete-user_root")
    public String eliminateUserRootToFastApi(@RequestParam String username) {
        /*
         * This method eliminates the user root to the FastAPI.
         * Args:
         * username: String
         * Returns:
         * String
         */
        return folderService.eliminateUserRootToFastApi(username);
    }
}

