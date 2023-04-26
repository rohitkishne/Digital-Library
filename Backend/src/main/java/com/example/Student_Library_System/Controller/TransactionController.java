package com.example.Student_Library_System.Controller;

import com.example.Student_Library_System.Dto.RequestDto.IssueBookRequestDto;
import com.example.Student_Library_System.Dto.RequestDto.ReturnBookRequestDto;
import com.example.Student_Library_System.Dto.ResponseDto.IssueBookResponseDto;
import com.example.Student_Library_System.Dto.ResponseDto.ReturnBookResponseDto;
import com.example.Student_Library_System.Dto.ResponseDto.TransactionResponseDto;
import com.example.Student_Library_System.Exception.BookIssuedAlreadyException;
import com.example.Student_Library_System.Exception.BookNotFoundException;
import com.example.Student_Library_System.Exception.CardNotFoundException;
import com.example.Student_Library_System.Exception.CardNotValidException;
import com.example.Student_Library_System.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issueBook")
    public IssueBookResponseDto issuedBook(@RequestBody IssueBookRequestDto issueBookRequestDto) throws CardNotFoundException, BookNotFoundException, CardNotValidException, BookIssuedAlreadyException {
        return transactionService.issuedBook(issueBookRequestDto);
    }

    @PostMapping("/returnBook")
    public ReturnBookResponseDto returnBook(@RequestBody ReturnBookRequestDto returnBookRequestDto)
    {
        return transactionService.returnBook(returnBookRequestDto);
    }

    @GetMapping("/getAllTransaction")
    public List<TransactionResponseDto> getAllTransaction(){
        return transactionService.getAllTransaction();
    }


}
