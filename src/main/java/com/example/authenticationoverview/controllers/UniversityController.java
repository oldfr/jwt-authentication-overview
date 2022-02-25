package com.example.authenticationoverview.controllers;

import com.example.authenticationoverview.dao.UniversityDB;
import com.example.authenticationoverview.dao.UniversityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {

    @Autowired
    private UniversityRepo universityRepo;

//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/test")
    public String test() {
        return "in university test endpoint";
    }

//    @PreAuthorize("hasAnyRole('ADMIN','EDITOR')")
    @PostMapping
    public UniversityDB addUniversity(@RequestBody UniversityDB universityDB) {
        UniversityDB savedUniversity = universityRepo.save(universityDB);
        return savedUniversity;
    }

//    @PreAuthorize("hasAnyRole('ADMIN','EDITOR','USER','PUBLIC')")
    @GetMapping
    public List<UniversityDB> getUniversities() {
        List<UniversityDB> allUniversitydata = universityRepo.findAll();
        return allUniversitydata;
    }
}
