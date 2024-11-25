package com.example.school.service;

import com.example.school.client.StudentClient;
import com.example.school.entity.School;
import com.example.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private StudentClient studentClient;

    // Create a logger instance using SLF4J
    private static final Logger logger = LoggerFactory.getLogger(SchoolService.class);

    public void saveSchool(School school) {
        try {
            schoolRepository.save(school);
        } catch (DataIntegrityViolationException e) {
            // Log the error message properly using SLF4J
            logger.error("Data integrity violation: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to save school due to data integrity violation", e);
        } catch (Exception e) {
            // Log the error message properly using SLF4J
            logger.error("Error saving school: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to save school", e);
        }
    }

    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }
    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId){
        var school = schoolRepository.findById(schoolId)
                .orElse(School.builder()
                        .name("Not_ Found")
                        .email("Not_ Found")
                        .build());
        var student =studentClient.findAllStudentsBySchool(schoolId);//find all  the students from  the student micro service
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .student(student)
                .build();

    }

}

