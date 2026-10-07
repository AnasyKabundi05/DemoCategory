package org.example.demoforcategory.Controller;

import org.example.demoforcategory.DTOs.EquipmentUpdateDTO;
import org.example.demoforcategory.Domain.Equipment;
import org.example.demoforcategory.Service.EquipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/viewCatalogue")
    public List<Equipment> viewEquipmentCatalogue(){
        return equipmentService.viewEquipmentCatalogue();
    }

    @PostMapping
    public Equipment createEquipment(@RequestBody EquipmentUpdateDTO request){
        return equipmentService.createEquipment(request);
    }

    @GetMapping("/{id}")
    public Equipment getEquipmentById(@PathVariable Long id){
        return equipmentService.getEquipmentById(id);
    }

    @PutMapping("/{id}")
    public Equipment updateEquipment(@PathVariable Long id, @RequestBody EquipmentUpdateDTO request){
        return equipmentService.updateEquipment(id,request);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipmentById(@PathVariable Long id){
        equipmentService.deleteEquipmentById(id);
    }
}
