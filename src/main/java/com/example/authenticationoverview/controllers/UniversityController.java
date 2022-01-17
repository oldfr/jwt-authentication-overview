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

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/test")
    public String test() throws Exception {
        return "inn university";
    }

    @PreAuthorize("hasAnyRole('ADMIN','EDITOR')")
    @PostMapping
    public UniversityDB addUniversity(@RequestBody UniversityDB universityDB) throws Exception {
//        System.out.println("name:"+universityDB.getUname());
        UniversityDB universityDB1 = universityRepo.save(universityDB);
        return universityDB1;
    }

    @PreAuthorize("hasAnyRole('ADMIN','EDITOR','USER','PUBLIC')")
    @GetMapping
    public List<UniversityDB> getUniversities() throws Exception {
        List<UniversityDB> universityDB1 = universityRepo.findAll();
        return universityDB1;
    }
}
