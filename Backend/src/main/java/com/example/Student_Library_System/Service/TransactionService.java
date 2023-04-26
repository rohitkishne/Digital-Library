package com.example.Student_Library_System.Service;

import com.example.Student_Library_System.Dto.RequestDto.IssueBookRequestDto;
import com.example.Student_Library_System.Dto.RequestDto.ReturnBookRequestDto;
import com.example.Student_Library_System.Dto.ResponseDto.IssueBookResponseDto;
import com.example.Student_Library_System.Dto.ResponseDto.ReturnBookResponseDto;
import com.example.Student_Library_System.Dto.ResponseDto.TransactionResponseDto;
import com.example.Student_Library_System.Exception.BookIssuedAlreadyException;
import com.example.Student_Library_System.Exception.BookNotFoundException;
import com.example.Student_Library_System.Exception.CardNotFoundException;
import com.example.Student_Library_System.Exception.CardNotValidException;

import java.util.List;

public interface TransactionService {

    public IssueBookResponseDto issuedBook(IssueBookRequestDto issueBookRequestDto) throws CardNotFoundException, BookNotFoundException, CardNotValidException, BookIssuedAlreadyException;
    public ReturnBookResponseDto returnBook(ReturnBookRequestDto returnBookRequestBook);

    public List<TransactionResponseDto> getAllTransaction();
}
