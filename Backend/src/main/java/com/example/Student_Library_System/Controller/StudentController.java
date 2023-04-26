package com.example.Student_Library_System.Controller;

import com.example.Student_Library_System.Dto.RequestDto.StudentRequestDto;
import com.example.Student_Library_System.Dto.RequestDto.UpdatedStudentRequestDto;
import com.example.Student_Library_System.Dto.ResponseDto.StudentBookingResponseDto;
import com.example.Student_Library_System.Dto.ResponseDto.StudentByDepartmentResponseDto;
import com.example.Student_Library_System.Dto.ResponseDto.StudentResponseDto;
import com.example.Student_Library_System.Dto.ResponseDto.UpdatedStudentResponseDto;
import com.example.Student_Library_System.Enum.Department;
import com.example.Student_Library_System.Exception.StudentIsNotFoundException;
import com.example.Student_Library_System.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto)
    {
        return studentService.addStudent(studentRequestDto);
    }

    @GetMapping("/getStudentById")
    public StudentResponseDto getStudentById(@RequestParam int id) throws StudentIsNotFoundException {
        return studentService.getStudentById(id);
    }

    @GetMapping("/getAllStudent")
    public List<StudentResponseDto> getAllStudent()
    {
        return studentService.getAllStudent();
    }

    @GetMapping("/getStudentByDepartment")
    public List<StudentByDepartmentResponseDto> getStudentByDepartment(@RequestParam Department department){
        return studentService.getStudentByDepartment(department);
    }

    @PutMapping("/updateStudentDetails")
    public UpdatedStudentResponseDto updateStudentDetails(@RequestBody UpdatedStudentRequestDto updateStudentRequestDto) throws StudentIsNotFoundException {
        return studentService.updateStudentDetails(updateStudentRequestDto);
    }
    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestParam int id) {
        return studentService.deleteStudent(id);
    }

    @DeleteMapping("/deleteAllStudent")
    public String deleteAllStudent() {
        return studentService.deleteAllStudent();
    }

    @GetMapping("/studentAllBooking")
    public List<StudentBookingResponseDto> studentAllBooking(@RequestParam int id)
    {
        return studentService.studentAllBooking(id);
    }
}
