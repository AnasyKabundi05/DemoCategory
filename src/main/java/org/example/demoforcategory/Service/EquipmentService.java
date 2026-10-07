package org.example.demoforcategory.Service;


import org.example.demoforcategory.DTOs.EquipmentUpdateDTO;
import org.example.demoforcategory.Domain.Category;
import org.example.demoforcategory.Domain.Equipment;
import org.example.demoforcategory.Repository.CategoryRepository;
import org.example.demoforcategory.Repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final CategoryRepository categoryRepository;

    public EquipmentService(EquipmentRepository equipmentRepository, CategoryRepository categoryRepository) {
        this.equipmentRepository = equipmentRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Equipment> viewEquipmentCatalogue(){
        return equipmentRepository.findAll();
    }

    public Equipment createEquipment(EquipmentUpdateDTO request){

        Equipment equipment = new Equipment();

        equipment.setName(request.getName());
        equipment.setAssetId(request.getAssetId());
        equipment.setCategory(findCategory(request.getCategoryId()));
        equipment.setMakeModel(request.getMakeModel());
        equipment.setStatus(request.getStatus());

        return equipmentRepository.save(equipment);
    }

    public Equipment getEquipmentById(Long id){
        return equipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found"));
    }

    private Category findCategory(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public Equipment updateEquipment(Long id, EquipmentUpdateDTO request){

        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found"));

        if(request.getName() != null) equipment.setName(request.getName());
        if(request.getAssetId() != null) equipment.setAssetId(request.getAssetId());
        if (request.getCategoryId() != null) equipment.setCategory(findCategory(request.getCategoryId()));
        if(request.getMakeModel() != null) equipment.setMakeModel(request.getMakeModel());
        if(request.getStatus() != null) equipment.setStatus(request.getStatus());

        return equipmentRepository.save(equipment);
    }

    public void deleteEquipmentById(Long id){
        equipmentRepository.deleteById(id);
    }
}

