package com.example.Student_Library_System.Dto.RequestDto;

import com.example.Student_Library_System.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDto {

    private String title;
    private Genre genre;
    private int noOfPages;
    private int price;

    private String imageLink;
    private String description;

    private int authorId;
}
