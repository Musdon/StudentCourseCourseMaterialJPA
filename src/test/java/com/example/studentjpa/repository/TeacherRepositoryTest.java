package com.example.studentjpa.repository;

import com.example.studentjpa.entity.Course;
import com.example.studentjpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course course = Course.builder()
                .courseTitle("Android")
                .credit(6)
                .build();

        Course course2 = Course.builder()
                .courseTitle("Python")
                .credit(2)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Mutiat")
                .lastName("Adesanya")
                //.courses(List.of(course, course2))
                .build();

        teacherRepository.save(teacher);
    }
}