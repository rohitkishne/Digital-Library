package com.example.Student_Library_System.Dto.ResponseDto;

import com.example.Student_Library_System.Enum.Genre;
import com.example.Student_Library_System.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentBookingResponseDto {

    private String title;
    private String author;
    private Genre genre;
    private String transactionNo;
    private Date transactionDate;
    private TransactionStatus transactionStatus;

}
