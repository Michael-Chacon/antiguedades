package com.app.app.antiquity.domain.service;

import com.app.app.antiquity.DTO.AvailableDTO;
import com.app.app.antiquity.persistence.Antiquity;

import java.util.List;
import java.util.Objects;

public interface IAntiquity {
    List<Antiquity> findAll();
    Antiquity findById(Long id);
    Antiquity save(Antiquity antiquity);
    Antiquity update(Long id, Antiquity antiquity);
    void delete(Long id);
    List<AvailableDTO> availableForSold();
}
