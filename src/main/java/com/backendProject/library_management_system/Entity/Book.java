package com.backendProject.library_management_system.Entity;

import com.backendProject.library_management_system.Enum.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlIDREF;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String title;
    private int price;

    @Enumerated(EnumType.STRING)
    private Genre gener;

    private boolean isIssued;

    @ManyToOne
    @JoinColumn
    @JsonIgnore  // this we used because we used cascade and get_authors is also applied for its authors child like book
            // and it runs in loop or recursively and give error stack overflow to avoid this error we used this
    Author author;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    LibraryCard card;

}
