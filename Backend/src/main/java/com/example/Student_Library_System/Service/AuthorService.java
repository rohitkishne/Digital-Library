package com.example.Student_Library_System.Service;

import com.example.Student_Library_System.Dto.RequestDto.AuthorRequestDto;
import com.example.Student_Library_System.Dto.RequestDto.UpdateAuthorRequestDto;
import com.example.Student_Library_System.Dto.ResponseDto.AuthorResponseDto;
import com.example.Student_Library_System.Dto.ResponseDto.UpdateAuthorResponseDto;
import com.example.Student_Library_System.Exception.AuthorNotFoundException;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface AuthorService {

    public String addAuthor(@RequestBody AuthorRequestDto authorRequestDto);

    public AuthorResponseDto getAuthorById(int id) throws AuthorNotFoundException;

    public List<AuthorResponseDto> getAllAuthor();

    public UpdateAuthorResponseDto updateAuthorDetails(UpdateAuthorRequestDto updatedAuthorRequestDto);

    public String deleteAuthorById(int id);

    public String deleteAllAuthors();
}
