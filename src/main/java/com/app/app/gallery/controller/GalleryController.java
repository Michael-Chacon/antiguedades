package com.app.app.gallery.controller;

import com.app.app.gallery.domain.service.IGallery;
import com.app.app.gallery.persistence.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.app.consts.GeneralConst.ID_IN_PATH;

@RestController
@RequestMapping("/gallery")
public class GalleryController {
    @Autowired
    private IGallery service;

    @GetMapping
    public ResponseEntity<List<Gallery>> getAllGallery(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<Gallery> getGalleryByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Gallery> createGallery(@RequestBody Gallery gallery){
        return ResponseEntity.ok(service.save(gallery));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<Gallery> updateGallery(@PathVariable Long id, @RequestBody Gallery gallery){
        return ResponseEntity.ok(service.update(id, gallery));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}