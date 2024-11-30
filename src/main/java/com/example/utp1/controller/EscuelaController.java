package com.example.utp1.controller;

import com.example.utp1.model.Escuela;
import com.example.utp1.service.EscuelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/escuelas")
public class EscuelaController {

    @Autowired
    private EscuelaService escuelaService;

    //Obtener la lista de todas las escuelas registradas
    @GetMapping
    public List<Escuela> getAllEscuelas(){
        return escuelaService.getAllEscuelas();
    }

    //Obtener una escuela por su id
    @GetMapping("/{id}")
    public ResponseEntity<Escuela> getEscuelaById(@PathVariable Long id){
        Escuela escuela = escuelaService.getEscuelaById(id);
        if (escuela != null) {
            return ResponseEntity.ok(escuela);
        }
        return ResponseEntity.notFound().build();
    }

    //PostMapping
    @PostMapping
    public Escuela createEscuela(@RequestBody Escuela escuela){
        return escuelaService.createEscuela(escuela);
    }

    //PutMapping (Actualiza)
    @PutMapping("/{id}")
    public ResponseEntity<Escuela> updateEscuela
    (@PathVariable Long id, @RequestBody Escuela escuela){
        Escuela escuela1 = escuelaService.actualizarEscuela(id, escuela);
        if (escuela1 != null) {
            return ResponseEntity.ok(escuela1);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEscuela(@PathVariable Long id){
        escuelaService.eliminarEscuela(id);
        return ResponseEntity.noContent().build();
    }
}
