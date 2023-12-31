package com.backendProject.library_management_system.Entity;


import com.backendProject.library_management_system.Enum.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNo;

    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;

    @CreationTimestamp
    private Date creationDate;

    @UpdateTimestamp
    private Date updationDate;



    @OneToOne
    @JoinColumn
    Student student;


    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Book> bookIssued = new ArrayList<>();


}
