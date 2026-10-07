package org.example.demoforcategory.Controller;

import jdk.jfr.Registered;
import org.example.demoforcategory.DTOs.CategoryUpdateDTO;
import org.example.demoforcategory.Domain.Category;
import org.example.demoforcategory.Service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/allCategories")
    public List<Category> viewAllCategories(){
        return categoryService.viewAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public Category addCategory(@RequestBody CategoryUpdateDTO request){
        return categoryService.addCategory(request);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id,@RequestBody CategoryUpdateDTO request){
        return categoryService.updateCategory(id,request);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
    }
}
