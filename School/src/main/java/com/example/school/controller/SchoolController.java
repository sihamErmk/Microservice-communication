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
@RequestMapping("api/v2/school") // Changed "School" to "school" for consistent naming
public class SchoolController {
    private final SchoolService schoolService;

    // Save a school
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school) {
        schoolService.saveSchool(school);
    }

    // Find all schools
    @GetMapping
    public ResponseEntity<List<School>> findAllSchools() {
        return ResponseEntity.ok(schoolService.findAllSchools());
    }

    // Find a school with students
    @GetMapping("/with-students/{school-id}") // Match variable name to method
    public ResponseEntity<FullSchoolResponse> findSchoolsWithStudents(@PathVariable("school-id") Integer schoolId) {
        return ResponseEntity.ok(schoolService.findSchoolsWithStudents(schoolId));
    }
}
