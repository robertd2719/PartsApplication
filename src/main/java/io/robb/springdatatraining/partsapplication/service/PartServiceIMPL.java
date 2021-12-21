package io.robb.springdatatraining.partsapplication.service;

import io.robb.springdatatraining.partsapplication.dao.PartDAO;
import io.robb.springdatatraining.partsapplication.entities.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceIMPL implements PartService {

    // Grab the DAO
    private final PartDAO partDAO;

    @Autowired
    public PartServiceIMPL(PartDAO partDAO){
        this.partDAO = partDAO;
    }

    @Override
    public List<Part> findAll() {
        return partDAO.findAll();
    }

    @Override
    public Object findById(int id) {
        return partDAO.findById(id);
    }

    @Override
    public void SaveOrUpdate(Part part) {
        partDAO.SaveOrUpdate(part);
    }

    @Override
    public void deleteById(int id) {
        partDAO.deleteById(id);
    }
}
