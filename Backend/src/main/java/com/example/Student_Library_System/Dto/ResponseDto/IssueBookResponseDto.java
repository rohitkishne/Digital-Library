package com.example.Student_Library_System.Dto.ResponseDto;

import com.example.Student_Library_System.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IssueBookResponseDto {

    private String transactionNumber;
    private TransactionStatus transactionStatus;
    private String bookName;
}
