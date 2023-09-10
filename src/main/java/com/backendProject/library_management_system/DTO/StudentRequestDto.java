package com.backendProject.library_management_system.DTO;

import com.backendProject.library_management_system.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentRequestDto {
    private String name;
    private String email;
    private int age;
    private Department department;
}
