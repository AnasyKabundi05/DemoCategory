package org.example.demoforcategory.Repository;

import org.example.demoforcategory.Domain.Category;
import org.example.demoforcategory.Domain.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    boolean existsByCategory(Category category);
}
