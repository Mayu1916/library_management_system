package com.backendProject.library_management_system.Repository;

import com.backendProject.library_management_system.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    //findBy{attribute name}
    Student findByEmail(String email);//custom search based on attributes

    List<Student> findByAge(int age);
}
