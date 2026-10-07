package org.example.demoforcategory.DTOs;

import lombok.Data;

@Data
public class CategoryUpdateDTO {
    private Long id;
    private String name;
    private String code;
}
