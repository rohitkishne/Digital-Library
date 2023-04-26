package com.example.Student_Library_System.Service;

import com.example.Student_Library_System.Dto.RequestDto.BookRequestDto;
import com.example.Student_Library_System.Dto.RequestDto.UpdateBookDetailRequestDto;
import com.example.Student_Library_System.Dto.ResponseDto.GetBookDetailResonseDto;
import com.example.Student_Library_System.Dto.ResponseDto.GetBookResponseDto;
import com.example.Student_Library_System.Exception.AuthorNotFoundException;
import com.example.Student_Library_System.Exception.BookNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BookService {
    public String addBook(@RequestBody BookRequestDto bookRequestDto) throws AuthorNotFoundException;

    public GetBookDetailResonseDto getBookById(int id) throws BookNotFoundException;


    public List<GetBookResponseDto> getAllBooks() throws BookNotFoundException;

    public GetBookResponseDto updateBookDetails(UpdateBookDetailRequestDto updateBookRequest) throws BookNotFoundException;

    public String deleteBook(int id);

    public String deleteAllBook();
}
