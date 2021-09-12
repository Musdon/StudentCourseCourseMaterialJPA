package com.example.studentjpa.entity;

import com.example.studentjpa.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Shofu")
                .lastName("Adeniyi")
                .build();

        Course course = Course.builder()
                .courseTitle("C#")
                .credit(4)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);
        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();
        Long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();
        System.out.println(totalPages);
        System.out.println(totalElements);
        System.out.println(courses);
    }

//    @Test
//    public void findAllWithSorting(){
//        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
//        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
//        Pageable sortByTitleAndCreditDesc = PageRequest.of(0,2, Sort.by("title").descending().and(Sort.by("credit")));
//
//        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
//        System.out.println(courses);
//    }

    @Test
    public void printByCourseTitleContaining(){
        Pageable firstPageTenRecords = PageRequest.of(0, 10);
        List<Course> courses = courseRepository.findByCourseTitleContaining("D",  firstPageTenRecords).getContent();
        System.out.println(courses);
    }


}