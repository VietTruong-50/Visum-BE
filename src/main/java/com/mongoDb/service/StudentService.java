package com.mongoDb.service;

import com.mongoDb.repository.StudentRepository;
import com.mongoDb.entities.Music;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Music> getAllStudents() {
        return studentRepository.findAll();
    }
}
