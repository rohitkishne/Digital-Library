package com.example.Student_Library_System.Dto.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBookDetailRequestDto {

    private int id;
    private int noOfPages;
    private int price;
    private String imageLink;
    private String description;

}
