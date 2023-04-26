package com.example.Student_Library_System.Service.Impl;

import com.example.Student_Library_System.Dto.RequestDto.BookRequestDto;
import com.example.Student_Library_System.Dto.RequestDto.UpdateBookDetailRequestDto;
import com.example.Student_Library_System.Dto.ResponseDto.GetBookDetailResonseDto;
import com.example.Student_Library_System.Dto.ResponseDto.GetBookResponseDto;
import com.example.Student_Library_System.Entity.Author;
import com.example.Student_Library_System.Entity.Book;
import com.example.Student_Library_System.Exception.AuthorNotFoundException;
import com.example.Student_Library_System.Exception.BookNotFoundException;
import com.example.Student_Library_System.Repository.AuthorRepository;
import com.example.Student_Library_System.Repository.BookRepository;
import com.example.Student_Library_System.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookImpl implements BookService {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;
    @Override
    public String addBook(BookRequestDto bookRequestDto) throws AuthorNotFoundException {

        try{

            Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();

            Book book = new Book();
            book.setTitle(bookRequestDto.getTitle());
            book.setGenre(bookRequestDto.getGenre());
            book.setNoOfPages(bookRequestDto.getNoOfPages());
            book.setPrice(bookRequestDto.getPrice());
            book.setImageLink(bookRequestDto.getImageLink());
            book.setDescription(bookRequestDto.getDescription());

            book.setAuthor(author);

            author.getBook().add(book);

            authorRepository.save(author);

            return "Book Added";

        }catch(Exception e)
        {
            throw new AuthorNotFoundException("Author is not Found");
        }
    }

    @Override
    public GetBookDetailResonseDto getBookById(int id) throws BookNotFoundException {

        try {

            Book book = bookRepository.findById(id).get();

            GetBookDetailResonseDto getBookDetail = new GetBookDetailResonseDto();
            getBookDetail.setId(book.getId());
            getBookDetail.setTitle(book.getTitle());
            getBookDetail.setGenre(book.getGenre());
            getBookDetail.setNoOfPages(book.getNoOfPages());
            getBookDetail.setPrice(book.getPrice());
            getBookDetail.setImageLink(book.getImageLink());
            getBookDetail.setDescription(book.getDescription());
            getBookDetail.setAuthorName(book.getAuthor().getName());

            return getBookDetail;

        }catch(Exception e)
        {
            throw new BookNotFoundException("Book is not found");
        }
    }

    @Override
    public List<GetBookResponseDto> getAllBooks() throws BookNotFoundException {
        try {

            List<Book> books = bookRepository.findAll();

            List<GetBookResponseDto> allBooks = new ArrayList<>();

            for(Book book : books)
            {
                GetBookResponseDto getBookDetail = new GetBookResponseDto();
                getBookDetail.setId(book.getId());
                getBookDetail.setTitle(book.getTitle());
                getBookDetail.setGenre(book.getGenre());
                getBookDetail.setNoOfPages(book.getNoOfPages());
                getBookDetail.setPrice(book.getPrice());
                getBookDetail.setAuthorName(book.getAuthor().getName());
                allBooks.add(getBookDetail);
            }

            return allBooks;

        }catch(Exception e)
        {
            throw new BookNotFoundException("No book present in library");
        }
    }

    @Override
    public GetBookResponseDto updateBookDetails(UpdateBookDetailRequestDto updateBookRequest) throws BookNotFoundException {

        try{
            Book book = bookRepository.findById(updateBookRequest.getId()).get();
            book.setNoOfPages(updateBookRequest.getNoOfPages());
            book.setPrice(updateBookRequest.getPrice());
            book.setImageLink(updateBookRequest.getImageLink());
            book.setDescription(updateBookRequest.getDescription());

            Book updatedBook = bookRepository.save(book);

            GetBookResponseDto getUpdatedBook = new GetBookResponseDto();
            getUpdatedBook.setId(updatedBook.getId());
            getUpdatedBook.setTitle(updatedBook.getTitle());
            getUpdatedBook.setGenre(updatedBook.getGenre());
            getUpdatedBook.setPrice(updatedBook.getPrice());
            getUpdatedBook.setNoOfPages(updatedBook.getNoOfPages());
            getUpdatedBook.setAuthorName(updatedBook.getAuthor().getName());

            return getUpdatedBook;


        }catch(Exception e)
        {
            throw new BookNotFoundException("Book Does not exist");
        }
    }

    @Override
    public String deleteBook(int id) {
        bookRepository.deleteById(id);
        return "Book deleted Successfully";
    }

    @Override
    public String deleteAllBook() {
        bookRepository.deleteAll();
        return "All Books deleted Successfully";
    }


}

