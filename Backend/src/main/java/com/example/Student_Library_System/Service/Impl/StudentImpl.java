package com.example.Student_Library_System.Service.Impl;

import com.example.Student_Library_System.Dto.RequestDto.StudentRequestDto;
import com.example.Student_Library_System.Dto.RequestDto.UpdatedStudentRequestDto;
import com.example.Student_Library_System.Dto.ResponseDto.*;
import com.example.Student_Library_System.Entity.Book;
import com.example.Student_Library_System.Entity.Card;
import com.example.Student_Library_System.Entity.Student;
import com.example.Student_Library_System.Entity.Transaction;
import com.example.Student_Library_System.Enum.CardStatus;
import com.example.Student_Library_System.Enum.Department;
import com.example.Student_Library_System.Exception.StudentIsNotFoundException;
import com.example.Student_Library_System.Repository.BookRepository;
import com.example.Student_Library_System.Repository.StudentRepository;
import com.example.Student_Library_System.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    BookRepository bookRepository;
    @Override
    public String addStudent(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMobNo(studentRequestDto.getMobNo());
        student.setEmail(studentRequestDto.getEmail());

        Card card = new Card();
        card.setStatus(CardStatus.ACTIVATED);
        card.setValidTill("2023-01-01");
        card.setStudent(student);

        student.setCard(card);

        studentRepository.save(student);

        return "Added Student";
    }

    @Override
    public StudentResponseDto getStudentById(int id) throws StudentIsNotFoundException {

        try {
            Student student = studentRepository.findById(id).get();

            StudentResponseDto studentResponseDto = new StudentResponseDto();
            studentResponseDto.setId(student.getId());
            studentResponseDto.setName(student.getName());
            studentResponseDto.setAge(student.getAge());
            studentResponseDto.setMobNo(student.getMobNo());
            studentResponseDto.setEmail(student.getEmail());
            studentResponseDto.setDepartment(student.getDepartment());

            CardResponseDto cardDetail = new CardResponseDto();
            cardDetail.setId(student.getCard().getId());
            cardDetail.setIssueDate(student.getCard().getIssueDate());
            cardDetail.setUpdatedOn(student.getCard().getUpdatedOn());
            cardDetail.setValidTill(student.getCard().getValidTill());
            cardDetail.setStatus(student.getCard().getStatus());

            studentResponseDto.setCardResponseDto(cardDetail);

            return studentResponseDto;
        }
        catch(Exception e)
        {
            throw new StudentIsNotFoundException("Student is not found");
        }
    }

    @Override
    public List<StudentResponseDto> getAllStudent() {

        List<Student> students = studentRepository.findAll();

        List<StudentResponseDto> getAllStudents = new ArrayList<>();
        for(Student student : students)
        {
            StudentResponseDto studentResponseDto = new StudentResponseDto();
            studentResponseDto.setId(student.getId());
            studentResponseDto.setName(student.getName());
            studentResponseDto.setAge(student.getAge());
            studentResponseDto.setMobNo(student.getMobNo());
            studentResponseDto.setEmail(student.getEmail());
            studentResponseDto.setDepartment(student.getDepartment());
            getAllStudents.add(studentResponseDto);
        }
        return getAllStudents;
    }

    @Override
    public List<StudentByDepartmentResponseDto> getStudentByDepartment(Department department) {

        List<Student> students = studentRepository.findByDepartment(department);

        List<StudentByDepartmentResponseDto> studentByDepartment = new ArrayList<>();

        for(Student student : students)
        {
            StudentByDepartmentResponseDto studentResponseDto = new StudentByDepartmentResponseDto();
            studentResponseDto.setId(student.getId());
            studentResponseDto.setName(student.getName());
            studentResponseDto.setAge(student.getAge());
            studentResponseDto.setMobNo(student.getMobNo());
            studentResponseDto.setEmail(student.getEmail());
            studentResponseDto.setDepartment(student.getDepartment());
            studentByDepartment.add(studentResponseDto);
        }
        return studentByDepartment;
    }

    @Override
    public UpdatedStudentResponseDto updateStudentDetails(UpdatedStudentRequestDto updateStudentRequestDto) throws StudentIsNotFoundException {

        try{
            Student student = studentRepository.findById(updateStudentRequestDto.getId()).get();
            student.setName(updateStudentRequestDto.getName());
            student.setAge(updateStudentRequestDto.getAge());
            student.setDepartment(updateStudentRequestDto.getDepartment());
            student.setMobNo(updateStudentRequestDto.getMobNo());
            student.setEmail(updateStudentRequestDto.getEmail());
            Student updatedStudent = studentRepository.save(student);

            UpdatedStudentResponseDto updatedStudentDto = new UpdatedStudentResponseDto();
            updatedStudentDto.setName(updatedStudent.getName());
            updatedStudentDto.setAge(updatedStudent.getAge());
            updatedStudentDto.setDepartment(updatedStudent.getDepartment());
            updatedStudentDto.setMobNo(updatedStudent.getMobNo());
            updatedStudentDto.setEmail(updatedStudent.getEmail());
            return updatedStudentDto;

        }
        catch(Exception e)
        {
            throw new StudentIsNotFoundException("Student is not Found");
        }

    }



    @Override
    public String deleteStudent(int id) {
        studentRepository.deleteById(id);
        return "Student Successfully Deleted";
    }

    @Override
    public String deleteAllStudent() {
        studentRepository.deleteAll();
        return "All Student Successfully Deleted";
    }

    @Override
    public List<StudentBookingResponseDto> studentAllBooking(int id) {

        Student student = studentRepository.findById(id).get();

        Card  card = student.getCard();

        List<Transaction> transactions = card.getTransactions();

        List<StudentBookingResponseDto> Bookings = new ArrayList<>();
        for(Transaction transaction : transactions)
        {
            if(transaction.getBook()!=null)
            {
                StudentBookingResponseDto studentBooking = new StudentBookingResponseDto();
                studentBooking.setTitle(transaction.getBook().getTitle());
                studentBooking.setGenre(transaction.getBook().getGenre());
                studentBooking.setAuthor(transaction.getBook().getAuthor().getName());
                studentBooking.setTransactionNo(transaction.getTransactionNumber());
                studentBooking.setTransactionStatus(transaction.getTransactionStatus());
                studentBooking.setTransactionDate(transaction.getTransactionDate());
                Bookings.add(studentBooking);
            }


        }


        return Bookings;
    }


}
