package com.backendProject.library_management_system.Service;


import com.backendProject.library_management_system.DTO.IsseueBookRequestDto;
import com.backendProject.library_management_system.DTO.IssueBookResponseDto;
import com.backendProject.library_management_system.Entity.Book;
import com.backendProject.library_management_system.Entity.LibraryCard;
import com.backendProject.library_management_system.Entity.Transaction;
import com.backendProject.library_management_system.Enum.CardStatus;
import com.backendProject.library_management_system.Enum.TransactionStatus;
import com.backendProject.library_management_system.Repository.BookRepository;
import com.backendProject.library_management_system.Repository.CardRepository;
import com.backendProject.library_management_system.Repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    TransactionRepository transactionRepository;
    public IssueBookResponseDto issueBook(IsseueBookRequestDto isseueBookRequestDto) throws Exception {
        //we have to create transaction object
        Transaction transaction=new Transaction();
        transaction.setTractionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssuedOpration(true);

        // get card and book object
        LibraryCard card;
        try {
            card = cardRepository.findById(isseueBookRequestDto.getCardId()).get();
        }
        catch(Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setSetMessage("Invalid card id ");
            transactionRepository.save(transaction);
            throw new Exception("Invalid card id ");
        }


        //home word make folder for custom exception
        Book book;
        try{
            book = bookRepository.findById(isseueBookRequestDto.getBookId()).get();
        }catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setSetMessage("Invalid book id");
            transactionRepository.save(transaction);
            throw new Exception("invalid book id ");
        }

        // both are valid if both not throw error

        transaction.setBook(book);
        transaction.setCard(card);
        if(card.getCardStatus()!= CardStatus.ACTIVATED ){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setSetMessage("your card is not activated");
            transactionRepository.save(transaction);
            throw new Exception("your card is not activated");
        }
        if(book.isIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setSetMessage("Book is already issued");
            transactionRepository.save(transaction);
            throw new Exception("Book is already issued");

        }

        book.setIssued(true);
        book.setCard(card);
        card.getTransactions().add(transaction);
        book.getTransactions().add(transaction);
        card.getBookIssued().add(book);
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setSetMessage("Book issued success");

        cardRepository.save(card); // this will save book and transaction aslo

        //prepared respoce Dto

        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();
        issueBookResponseDto.setTransactionId(transaction.getTractionNumber());
        issueBookResponseDto.setBookName(book.getTitle());
        issueBookResponseDto.setTransactionStatus(TransactionStatus.SUCCESS);
        return issueBookResponseDto;

    }
}
