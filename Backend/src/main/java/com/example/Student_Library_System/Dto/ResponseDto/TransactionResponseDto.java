package com.example.Student_Library_System.Dto.ResponseDto;

import com.example.Student_Library_System.Enum.IssueOperation;
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
public class TransactionResponseDto {

    private String transactionNumber;
    private Date transactionDate;
    private IssueOperation issueOperation;
    private TransactionStatus transactionStatus;

    private String studentName;
    private String bookName;
}
