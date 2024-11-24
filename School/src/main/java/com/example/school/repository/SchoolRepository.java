package com.example.school.repository;

import com.example.school.entity.School;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface SchoolRepository extends JpaRepository<School,Integer> {
}
