package com.example.studentjpa.repository;

import com.example.studentjpa.entity.Guardian;
import com.example.studentjpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder().emailId("musa.ajibade@decagon.dev")
                .firstName("Musa").lastName("Ajibade")
                //.guardianName("Mutiat")
                //.guardianEmail("mutiat@gmail.com").guardianMobile("08027416819")
        .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardianDetails(){
        Guardian guardian = Guardian.builder().name("Musdon")
                .email("musdonbaba@gmail.com")
                .mobile("08118524908")
                .build();
        Student student = Student.builder().firstName("Maryam")
                .emailId("maryam@gmail.com")
                .lastName("Ajibade")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student list: " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByfirstName("Maryam");
        System.out.println(students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("Ma");
        System.out.println(students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Musdon");
        System.out.println(students);
    }

    @Test
    public void printGetStudentByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailId("maryam@gmail.com");
        System.out.println(firstName);
    }

    @Test
    public void printStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("musa.ajibade@decagon.dev");
        System.out.println(student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("maryam@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("Mariam MyBaby", "maryam@gmail.com");
    }
}