package com.example.school.controller;

import com.example.school.entity.School;
import com.example.school.service.FullSchoolResponse;
import com.example.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v2/School")
public class SchoolController {
    private final SchoolService schoolService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school){
        schoolService.saveSchool(school);
    }


    @GetMapping
    public ResponseEntity<List<School>> findAllSchools(){
        return ResponseEntity.ok(schoolService.findAllSchools());
    }
    @GetMapping("with-students/{school-id}")
    public ResponseEntity<List<FullSchoolResponse>> findAllSchools(@PathVariable("school_id") Integer schoolId){

        return ResponseEntity.ok(schoolService.findSchoolsWithStudents(schoolId));
    }

}
