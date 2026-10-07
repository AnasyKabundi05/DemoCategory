package org.example.demoforcategory.DTOs;

import lombok.Data;

@Data
public class EquipmentUpdateDTO {
    private Long id;
    private String assetId;
    private String name;
    private Long categoryId;
    private String makeModel;
    private String status;
}
