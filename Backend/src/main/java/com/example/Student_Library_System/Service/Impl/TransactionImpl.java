package com.example.Student_Library_System.Service.Impl;

import com.example.Student_Library_System.Dto.RequestDto.IssueBookRequestDto;
import com.example.Student_Library_System.Dto.RequestDto.ReturnBookRequestDto;
import com.example.Student_Library_System.Dto.ResponseDto.IssueBookResponseDto;
import com.example.Student_Library_System.Dto.ResponseDto.ReturnBookResponseDto;
import com.example.Student_Library_System.Dto.ResponseDto.TransactionResponseDto;
import com.example.Student_Library_System.Entity.Book;
import com.example.Student_Library_System.Entity.Card;
import com.example.Student_Library_System.Entity.Transaction;
import com.example.Student_Library_System.Enum.CardStatus;
import com.example.Student_Library_System.Enum.IssueOperation;
import com.example.Student_Library_System.Enum.TransactionStatus;
import com.example.Student_Library_System.Exception.BookIssuedAlreadyException;
import com.example.Student_Library_System.Exception.BookNotFoundException;
import com.example.Student_Library_System.Exception.CardNotFoundException;
import com.example.Student_Library_System.Exception.CardNotValidException;
import com.example.Student_Library_System.Repository.BookRepository;
import com.example.Student_Library_System.Repository.CardRepository;
import com.example.Student_Library_System.Repository.TransactionRepository;
import com.example.Student_Library_System.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TransactionImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    private JavaMailSender emailSender;
    @Override
    public IssueBookResponseDto issuedBook(IssueBookRequestDto issueBookRequestDto) throws CardNotFoundException, BookNotFoundException, CardNotValidException, BookIssuedAlreadyException {

        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(IssueOperation.ISSUED);

        Card card;
        try{

            card = cardRepository.findById(issueBookRequestDto.getCardId()).get();

        }catch(Exception e)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new CardNotFoundException("Card is not found");
        }

        transaction.setCard(card);

        Book book;
        try{

            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();

        }catch(Exception e)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new BookNotFoundException("Book is not found");
        }

        transaction.setBook(book);

        if(card.getStatus()!= CardStatus.ACTIVATED)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new CardNotValidException("Card has been Expired");
        }

        if(book.isIssued()==true)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new BookIssuedAlreadyException("Book is Already Issued");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);
        book.setCard(card);
        book.getTransactions().add(transaction);

        card.getBookIssued().add(book);
        card.getTransactions().add(transaction);

        cardRepository.save(card);

        IssueBookResponseDto issuedBookReponse = new IssueBookResponseDto();
        issuedBookReponse.setTransactionNumber(transaction.getTransactionNumber());
        issuedBookReponse.setTransactionStatus(transaction.getTransactionStatus());
        issuedBookReponse.setBookName(book.getTitle());

        String text = "Your request for issuing the book "+ book.getTitle()+" has been Successfully issued.";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("projectpurposetesting@gmail.com");
        message.setTo(card.getStudent().getEmail());
        message.setSubject("Issue Book");
        message.setText(text);
        emailSender.send(message);

        return issuedBookReponse;
    }

    @Override
    public ReturnBookResponseDto returnBook(ReturnBookRequestDto returnBookRequestDto) {
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(IssueOperation.RETURNED);

        Card card = cardRepository.findById(returnBookRequestDto.getCardId()).get();
        transaction.setCard(card);

        Book book = bookRepository.findById(returnBookRequestDto.getBookId()).get();
        transaction.setBook(book);

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(false);
        book.setCard(null);
        book.getTransactions().add(transaction);

        card.getBookIssued().remove(book);
        card.getTransactions().add(transaction);

        transactionRepository.save(transaction);

        ReturnBookResponseDto ReturnBookReponse = new ReturnBookResponseDto();
        ReturnBookReponse.setTransactionNumber(transaction.getTransactionNumber());
        ReturnBookReponse.setTransactionStatus(transaction.getTransactionStatus());
        ReturnBookReponse.setBookName(book.getTitle());

        return ReturnBookReponse;
    }

    @Override
    public List<TransactionResponseDto> getAllTransaction() {

        List<Transaction> transactions = transactionRepository.findAll();

        List<TransactionResponseDto> allTransaction = new ArrayList<>();

        for(Transaction transaction : transactions)
        {
            if(transaction.getBook()!=null)
            {
                TransactionResponseDto studentTransaction = new TransactionResponseDto();
                studentTransaction.setTransactionNumber(transaction.getTransactionNumber());
                studentTransaction.setTransactionDate(transaction.getTransactionDate());
                studentTransaction.setTransactionStatus(transaction.getTransactionStatus());
                studentTransaction.setStudentName(transaction.getCard().getStudent().getName());
                studentTransaction.setBookName(transaction.getBook().getTitle());
                studentTransaction.setIssueOperation(transaction.getIssueOperation());
                allTransaction.add(studentTransaction);
            }
            else
            {
                TransactionResponseDto studentTransaction = new TransactionResponseDto();
                studentTransaction.setTransactionNumber(transaction.getTransactionNumber());
                studentTransaction.setTransactionDate(transaction.getTransactionDate());
                studentTransaction.setTransactionStatus(transaction.getTransactionStatus());
                studentTransaction.setStudentName(transaction.getCard().getStudent().getName());
                studentTransaction.setBookName("Unknown");
                studentTransaction.setIssueOperation(transaction.getIssueOperation());
                allTransaction.add(studentTransaction);
            }

        }

        return allTransaction;
    }


}
