package com.example.Student_Library_System.Dto.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAuthorRequestDto {
    private int id;
    private String name;
    private int age;
    private String email;
}
