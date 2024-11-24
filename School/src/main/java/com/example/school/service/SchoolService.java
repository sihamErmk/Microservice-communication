package com.example.school.service;

import com.example.school.entity.School;
import com.example.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private  final SchoolRepository schoolRepository;

    public void  saveSchool(School school){
        schoolRepository.save(school);
    }
    public List<School> findAllSchools(){
        return  schoolRepository.findAll();

    }
}
