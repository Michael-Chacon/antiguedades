package com.app.app.user.controller;

import com.app.app.user.domain.service.IUsers;
import com.app.app.user.persistence.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.app.consts.GeneralConst.ID_IN_PATH;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private IUsers service;

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<Users> getUsersByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Users> createUsers(@RequestBody Users users){
        return ResponseEntity.ok(service.save(users));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<Users> updateUsers(@PathVariable Long id, @RequestBody Users users){
        return ResponseEntity.ok(service.update(id, users));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}