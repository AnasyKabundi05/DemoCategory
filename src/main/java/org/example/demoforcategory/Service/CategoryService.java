package org.example.demoforcategory.Service;

import org.example.demoforcategory.DTOs.CategoryUpdateDTO;
import org.example.demoforcategory.Domain.Category;
import org.example.demoforcategory.Repository.CategoryRepository;
import org.example.demoforcategory.Repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final EquipmentRepository equipmentRepository;

    public CategoryService(CategoryRepository categoryRepository, EquipmentRepository equipmentRepository) {
        this.categoryRepository = categoryRepository;
        this.equipmentRepository = equipmentRepository;
    }

    public List<Category> viewAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public Category addCategory(CategoryUpdateDTO request){

        Category category = new Category();

        category.setName(request.getName());
        category.setCode(request.getCode());

        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, CategoryUpdateDTO request){

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        if(request.getName() != null) category.setName(request.getName());
        if(request.getCode() != null) category.setCode(request.getCode());

        return categoryRepository.save(category);
    }

    public void deleteCategoryById(Long id){
        Category category = getCategoryById(id);

        if (equipmentRepository.existsByCategory(category)) {
            throw new RuntimeException("Category still has equipment. Move or delete those items first.");
        }

        categoryRepository.delete(category);
    }
}
