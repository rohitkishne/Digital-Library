package com.example.Student_Library_System.Dto.ResponseDto;

import com.example.Student_Library_System.Enum.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardResponseDto {
    private int id;

    private Date issueDate;

    private Date updatedOn;

    private CardStatus status;

    private String validTill;


}
