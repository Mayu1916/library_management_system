package com.backendProject.library_management_system.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SelectBeforeUpdate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class IsseueBookRequestDto {

    private int cardId;

    private int bookId;

}
