package com.app.app.antiquity.domain.service;

import com.app.app.antiquity.domain.repository.AntiquityRepository;
import com.app.app.antiquity.persistence.Antiquity;
import com.app.app.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AntiquityImpl implements IAntiquity {
     @Autowired
    private AntiquityRepository repository;

    @Override
    public List<Antiquity> findAll() {
        return repository.findAll();
    }

    @Override
    public Antiquity findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Antiquity.class.getName(), id));
    }

    @Override
    public Antiquity save(Antiquity antiquity) {
        return repository.save(antiquity);
    }

    @Override
    public Antiquity update(Long id, Antiquity antiquity) {
        return repository.findById(id).map(existElement -> {
            existElement.setName(antiquity.getName());
            existElement.setCategory(antiquity.getCategory());
            existElement.setPeriod(antiquity.getPeriod());
            existElement.setConservationStatus(antiquity.getConservationStatus());
            existElement.setAvailability(antiquity.getAvailability());
            existElement.setBranch(antiquity.getBranch());
            return repository.save(existElement);
        }).orElseThrow(() -> new ResourceNotFoundException(Antiquity.class.getName(), id));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}