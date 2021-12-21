package io.robb.springdatatraining.partsapplication.dao;

import io.robb.springdatatraining.partsapplication.entities.Part;

import java.util.List;

public interface PartDAO {
    List<Part> findAll();
    Object findById(int id);
    void SaveOrUpdate(Part part);
    void deleteById(int id);
}
