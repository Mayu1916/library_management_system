package com.backendProject.library_management_system.Controller;


import com.backendProject.library_management_system.DTO.IsseueBookRequestDto;
import com.backendProject.library_management_system.DTO.IssueBookResponseDto;
import com.backendProject.library_management_system.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {


    @Autowired
    TransactionService transactionService;
    @PostMapping("/issue")
    public ResponseEntity issueBook(@RequestBody IsseueBookRequestDto isseueBookRequestDto){
            IssueBookResponseDto isseueBookResponseSto;
            try {
                isseueBookResponseSto=transactionService.issueBook(isseueBookRequestDto);
            } catch (Exception e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
            }
        return new ResponseEntity(isseueBookResponseSto,HttpStatus.ACCEPTED);
    }
}
