package io.robb.springdatatraining.partsapplication.service;

import io.robb.springdatatraining.partsapplication.entities.Part;

import java.util.List;

public interface PartService {
    List<Part> findAll();
    Object findById(int id);
    void SaveOrUpdate(Part part);
    void deleteById(int id);
}
