package com.example.Student_Library_System.Entity;

import com.example.Student_Library_System.Enum.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private int noOfPages;
    private int price;

    private String imageLink;
    @Lob
    private String description;
    private boolean isIssued;
    @ManyToOne
    @JoinColumn
    private Author author;
    @ManyToOne
    @JoinColumn
    Card card;

    @OneToMany(mappedBy="book", cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();

}
