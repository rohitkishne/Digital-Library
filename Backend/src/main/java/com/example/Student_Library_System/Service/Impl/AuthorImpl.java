package com.example.Student_Library_System.Service.Impl;

import com.example.Student_Library_System.Dto.RequestDto.AuthorRequestDto;
import com.example.Student_Library_System.Dto.RequestDto.UpdateAuthorRequestDto;
import com.example.Student_Library_System.Dto.ResponseDto.AuthorResponseDto;
import com.example.Student_Library_System.Dto.ResponseDto.UpdateAuthorResponseDto;
import com.example.Student_Library_System.Entity.Author;
import com.example.Student_Library_System.Entity.Book;
import com.example.Student_Library_System.Exception.AuthorNotFoundException;
import com.example.Student_Library_System.Repository.AuthorRepository;
import com.example.Student_Library_System.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public String addAuthor(AuthorRequestDto authorRequestDto)
    {
        Author author = new Author();
        author.setName(authorRequestDto.getName());
        author.setAge(authorRequestDto.getAge());
        author.setEmail(authorRequestDto.getEmail());

        authorRepository.save(author);

        return "Author added successfully";
    }

    @Override
    public AuthorResponseDto getAuthorById(int id) throws AuthorNotFoundException {
        try
        {
            Author author = authorRepository.findById(id).get();

            AuthorResponseDto authorResponse = new AuthorResponseDto();
            authorResponse.setName(author.getName());
            authorResponse.setAge(author.getAge());
            authorResponse.setEmail(author.getEmail());
            return authorResponse;

        }catch(Exception e)
        {
            throw new AuthorNotFoundException("Author is not found");
        }

    }

    @Override
    public List<AuthorResponseDto> getAllAuthor() {
        List<Author> authors = authorRepository.findAll();

        List<AuthorResponseDto> allAuthors = new ArrayList<>();
        for(Author author : authors)
        {
            AuthorResponseDto authorResponse = new AuthorResponseDto();
            authorResponse.setName(author.getName());
            authorResponse.setAge(author.getAge());
            authorResponse.setEmail(author.getEmail());
            allAuthors.add(authorResponse);
        }

        return allAuthors;
    }

    @Override
    public UpdateAuthorResponseDto updateAuthorDetails(UpdateAuthorRequestDto updatedAuthorRequestDto) {
        Author author = authorRepository.findById(updatedAuthorRequestDto.getId()).get();
        author.setName(updatedAuthorRequestDto.getName());
        author.setAge(updatedAuthorRequestDto.getAge());
        author.setEmail(updatedAuthorRequestDto.getEmail());

        Author updatedAuthor = authorRepository.save(author);

        UpdateAuthorResponseDto authorResponse = new UpdateAuthorResponseDto();
        authorResponse.setName(updatedAuthor.getName());
        authorResponse.setAge(updatedAuthor.getAge());
        authorResponse.setEmail(updatedAuthor.getEmail());

        return authorResponse;
    }

    @Override
    public String deleteAuthorById(int id) {
        authorRepository.deleteById(id);
        return "Author Successfully Deleted";
    }

    @Override
    public String deleteAllAuthors() {
        authorRepository.deleteAll();
        return "All Author Successfully Deleted";
    }


}
