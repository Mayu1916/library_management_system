package com.backendProject.library_management_system.Service;

import com.backendProject.library_management_system.DTO.StudentRequestDto;
import com.backendProject.library_management_system.DTO.StudentUpdateEmailRequestDto;
import com.backendProject.library_management_system.DTO.StudentResponse;
import com.backendProject.library_management_system.Entity.LibraryCard;
import com.backendProject.library_management_system.Entity.Student;
import com.backendProject.library_management_system.Enum.CardStatus;
import com.backendProject.library_management_system.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(StudentRequestDto studentRequestDto){
//        //before adding student we have to create LibrearyCard for him/her and add it to card table
//        LibraryCard libraryCard =new LibraryCard();
//        libraryCard.setCardStatus(CardStatus.ACTIVATED);
//        libraryCard.setValidTill("03/2024");
//        libraryCard.setStudent();
//        //set card in student
//        student.setCard(libraryCard);
//        //save student in student table
//        studentRepository.save(student);

        Student student= new Student();
        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setEmail(studentRequestDto.getEmail());

            //create card object
        LibraryCard card = new LibraryCard();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudent(student);
        student.setCard(card);

        studentRepository.save(student);//will save both student and card
    }

    public String deleteStudent(Integer id){
        studentRepository.deleteById(id);
        return "delete success";
    }

    public String deleteAllStudent(){
        studentRepository.deleteAll();
        return "all student deleted";
    }

    public String findByEmail(String email){
        Student student = studentRepository.findByEmail(email);
        return student.getName();
    }

    public StudentResponse updateEmail(StudentUpdateEmailRequestDto studentUpdateEmailRequestDto){
        Student student = studentRepository.findById(studentUpdateEmailRequestDto.getId()).get();
        student.setEmail(studentUpdateEmailRequestDto.getEmail());

        //update step
        Student updatedStudent = studentRepository.save(student);

        //convert updated student to responce dto
        StudentResponse  studentResponse = new StudentResponse();
        studentResponse.setId(updatedStudent.getId());
        studentResponse.setEmail(updatedStudent.getEmail());
        studentResponse.setName(updatedStudent.getName());
        return studentResponse;
    }
}
