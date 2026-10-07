package org.example.demoforcategory.Repository;

import org.example.demoforcategory.Domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
