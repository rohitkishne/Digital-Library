package com.example.Student_Library_System.Dto.ResponseDto;

import com.example.Student_Library_System.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class GetBookDetailResonseDto {

    private int id;
    private String title;
    private Genre genre;
    private int price;
    private int noOfPages;
    private String imageLink;

    private String description;
    private String authorName;




}
