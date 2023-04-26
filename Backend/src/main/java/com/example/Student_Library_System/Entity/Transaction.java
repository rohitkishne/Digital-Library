package com.example.Student_Library_System.Entity;

import com.example.Student_Library_System.Enum.IssueOperation;
import com.example.Student_Library_System.Enum.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String transactionNumber;

    @CreationTimestamp
    private Date transactionDate;

    @Enumerated(EnumType.STRING)
    private IssueOperation issueOperation;
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    @ManyToOne
    @JoinColumn
    private Card card;

    @ManyToOne
    @JoinColumn
    private Book book;
}
