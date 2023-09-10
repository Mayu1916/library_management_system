package com.backendProject.library_management_system.Controller;

import com.backendProject.library_management_system.DTO.StudentRequestDto;
import com.backendProject.library_management_system.DTO.StudentUpdateEmailRequestDto;
import com.backendProject.library_management_system.DTO.StudentResponse;
import com.backendProject.library_management_system.Entity.Student;
import com.backendProject.library_management_system.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;


    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){
        studentService.addStudent(studentRequestDto);
        return "Added successively";
    }

    @DeleteMapping("deleteStudent")
    public String deleteStudent(@RequestParam Integer id){
        studentService.deleteStudent(id);
        return "delete succes";
    }

    @DeleteMapping("deleteALlStudent")
    public String deleteAllStudent(){
        studentService.deleteAllStudent();
        return "Delete all Stduent";
    }

    @GetMapping("/find_by_email")
    public String findStudentByEmail(@RequestParam String email){
        return studentService.findByEmail(email);
    }

    // get student of perticular age
    //try for some other attributes

    @PutMapping("/update_email")
    public StudentResponse updateMob(@RequestBody StudentUpdateEmailRequestDto studentUpdateEmailRequestDto){
        return studentService.updateEmail(studentUpdateEmailRequestDto);
    }

}
