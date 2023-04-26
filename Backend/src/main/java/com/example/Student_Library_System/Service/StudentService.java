package com.example.Student_Library_System.Service;

import com.example.Student_Library_System.Dto.RequestDto.StudentRequestDto;
import com.example.Student_Library_System.Dto.RequestDto.UpdatedStudentRequestDto;
import com.example.Student_Library_System.Dto.ResponseDto.StudentBookingResponseDto;
import com.example.Student_Library_System.Dto.ResponseDto.StudentByDepartmentResponseDto;
import com.example.Student_Library_System.Dto.ResponseDto.StudentResponseDto;
import com.example.Student_Library_System.Dto.ResponseDto.UpdatedStudentResponseDto;
import com.example.Student_Library_System.Enum.Department;
import com.example.Student_Library_System.Exception.StudentIsNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StudentService {

    public String addStudent(@RequestBody StudentRequestDto studentRequestDto);
    public StudentResponseDto getStudentById(@RequestParam int id) throws StudentIsNotFoundException;
    public List<StudentResponseDto> getAllStudent();
    public List<StudentByDepartmentResponseDto> getStudentByDepartment(@RequestParam Department department);

    public UpdatedStudentResponseDto updateStudentDetails(UpdatedStudentRequestDto updateStudentRequestDto) throws StudentIsNotFoundException;

    public String deleteStudent(int id);

    public String deleteAllStudent();

    public List<StudentBookingResponseDto> studentAllBooking(int id);
}
