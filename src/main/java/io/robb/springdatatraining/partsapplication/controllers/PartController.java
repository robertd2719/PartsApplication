package io.robb.springdatatraining.partsapplication.controllers;

import io.robb.springdatatraining.partsapplication.entities.Part;
import io.robb.springdatatraining.partsapplication.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class PartController {

    private final PartService partService;

    @Autowired
    public PartController(@Qualifier("partServiceIMPL") PartService partService){
        this.partService = partService;
    }

    // Get all of our parts out of the d.base
    @GetMapping("/getAll")
    public List<Part> findAll(){
        return partService.findAll();
    }

    @GetMapping("/getOne/{id}")
    public Part findbyId(@PathVariable int id){
        return  (Part) partService.findById(id);
    }

    // this will do both the saving and the updating, but we will make two routes anyway
    @PostMapping("/createOne")
    public void createOne(@RequestBody Part part){
        partService.SaveOrUpdate(part);
    }

    @PutMapping("/updateOne")
    public void updateOne(@RequestBody Part part){
        partService.SaveOrUpdate(part);
    }

    @DeleteMapping("/deleteOne/{id}")
    public void deleteOneByID(@PathVariable int id){
        partService.deleteById(id);
    }

}
