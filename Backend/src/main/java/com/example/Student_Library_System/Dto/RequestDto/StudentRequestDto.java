package com.example.Student_Library_System.Dto.RequestDto;

import com.example.Student_Library_System.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDto {

    private String name;
    private int age;
    private Department department;
    private String mobNo;
    private String email;
}
