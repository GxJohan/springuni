package com.example.utp1.controller;
import com.example.utp1.model.Estudiante;
import com.example.utp1.repository.EstudianteRepository;
import com.example.utp1.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    //Obtener la lista de todos los estudiantes registrados
    @GetMapping
    public List<Estudiante> getAllEstudiantes(){
        return estudianteService.getEstudiantes();
    }
    //Obtener un estudiante por su id
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable Long id){
        Estudiante estudiante = estudianteService.getEstudianteId(id);
        if (estudiante != null) {
            return ResponseEntity.ok(estudiante);
        }
        return ResponseEntity.notFound().build();
    }
    //PostMapping
    @PostMapping
    public Estudiante createEstudiante(@RequestBody Estudiante estudiante){
        return estudianteService.createEstudiante(estudiante);
    }
    //PutMapping (Actualiza)
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante){
        Estudiante estudiante1 = estudianteService.actualizarEstudiante(id, estudiante);
        if (estudiante1 != null) {
            return ResponseEntity.ok(estudiante1);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Long id){
        Estudiante estudiante = estudianteService.getEstudianteId(id);
        if (estudiante != null) {
            estudianteService.eliminarEstudiante(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
