package com.backendProject.library_management_system.Repository;

import com.backendProject.library_management_system.Entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<LibraryCard,Integer> {
}
