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

    @PostMapping("/send-user_root")
    public String sendUserRootToFastApi(@RequestParam String username) {
        return folderService.sendUserRootToFastApi(username);
    }

    @DeleteMapping("/delete-user_root")
    public String eliminateUserRootToFastApi(@RequestParam String username) {
        return folderService.eliminateUserRootToFastApi(username);
    }
}

