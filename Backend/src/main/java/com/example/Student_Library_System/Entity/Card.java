package com.example.Student_Library_System.Entity;

import com.example.Student_Library_System.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreationTimestamp
    private Date issueDate;
    @UpdateTimestamp
    private Date updatedOn;
    @Enumerated(EnumType.STRING)
    private CardStatus status;

    private String validTill;

    @OneToOne
    @JoinColumn
    private Student student;
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    List<Book> bookIssued = new ArrayList<>();

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();

}
