package com.example.Student_Library_System.Dto.ResponseDto;

import com.example.Student_Library_System.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentByDepartmentResponseDto {
    private int id;
    private String name;
    private int age;
    private String mobNo;
    private Department department;

    private String email;
}
