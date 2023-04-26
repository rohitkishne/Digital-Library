package com.example.Student_Library_System.Controller;

import com.example.Student_Library_System.Dto.RequestDto.BookRequestDto;
import com.example.Student_Library_System.Dto.RequestDto.UpdateBookDetailRequestDto;
import com.example.Student_Library_System.Dto.ResponseDto.GetBookDetailResonseDto;
import com.example.Student_Library_System.Dto.ResponseDto.GetBookResponseDto;
import com.example.Student_Library_System.Exception.AuthorNotFoundException;
import com.example.Student_Library_System.Exception.BookNotFoundException;
import com.example.Student_Library_System.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public String addBook(@RequestBody BookRequestDto bookRequestDto) throws AuthorNotFoundException {
        return bookService.addBook(bookRequestDto);
    }

    @GetMapping("/getBookById")
    public GetBookDetailResonseDto getBookByid(@RequestParam int id) throws BookNotFoundException {
        return bookService.getBookById(id);
    }

    @GetMapping("/getAllBooks")
    public List<GetBookResponseDto> getAllBooks() throws BookNotFoundException {
        return bookService.getAllBooks();
    }

    @PutMapping("/UpdateBookDetails")
    public GetBookResponseDto updateBookDetails(@RequestBody UpdateBookDetailRequestDto updateBookRequest) throws BookNotFoundException {
        return bookService.updateBookDetails(updateBookRequest);
    }

    @DeleteMapping("/DeleteBook")
    public String deleteBook(@RequestParam int id)
    {
        return bookService.deleteBook(id);
    }

    @DeleteMapping("/DeleteAllBook")
    public String deleteAllBook()
    {
        return bookService.deleteAllBook();
    }


}
