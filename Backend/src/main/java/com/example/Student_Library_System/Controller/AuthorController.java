package com.example.Student_Library_System.Controller;

import com.example.Student_Library_System.Dto.RequestDto.AuthorRequestDto;
import com.example.Student_Library_System.Dto.RequestDto.UpdateAuthorRequestDto;
import com.example.Student_Library_System.Dto.ResponseDto.AuthorResponseDto;
import com.example.Student_Library_System.Dto.ResponseDto.UpdateAuthorResponseDto;
import com.example.Student_Library_System.Exception.AuthorNotFoundException;
import com.example.Student_Library_System.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/addAuthor")
    public String addAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        return authorService.addAuthor(authorRequestDto);
    }

    @GetMapping("/getAuthorById")
    public AuthorResponseDto getAuthorById(@RequestParam int id) throws AuthorNotFoundException {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/getAllAuthor")
    public List<AuthorResponseDto> getAllAuthor(){
        return authorService.getAllAuthor();
    }

    @PutMapping("/updateAuthorDetail")
    public UpdateAuthorResponseDto updateAuthorDetails(@RequestBody UpdateAuthorRequestDto updatedAuthorRequestDto)
    {
        return authorService.updateAuthorDetails(updatedAuthorRequestDto);
    }

    @DeleteMapping("/deleteAuthorById")
    public String deleteAuthorById(@RequestParam int id)
    {
        return authorService.deleteAuthorById(id);
    }

    @DeleteMapping("/deleteAllAuthors")
    public String deleteAllAuthor()
    {
        return authorService.deleteAllAuthors();
    }
 }
