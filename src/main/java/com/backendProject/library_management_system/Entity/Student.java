package com.backendProject.library_management_system.Entity;

import com.backendProject.library_management_system.Enum.CardStatus;
import com.backendProject.library_management_system.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private Department department;

    private String email;

    // cascade = cascadeType.ALL means all the crud opration i will
    // perfrom on this class this should be applied for my child card also
    // is short when parent is save child is auomatically save.

    //mappedBy means child class mai konse varible se map hai

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    LibraryCard card;

}
