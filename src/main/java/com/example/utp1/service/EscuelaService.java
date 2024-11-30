package com.example.utp1.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.utp1.repository.EscuelaRepository;
import com.example.utp1.model.Escuela;

import java.util.List;

@Service
public class EscuelaService {

    @Autowired
    private EscuelaRepository escuelaRepository;

    //Método para obtener todas las escuelas en una lista
    public List<Escuela> getAllEscuelas() {
        return escuelaRepository.findAll();
    }
    //Método para obtener una escuela por su id
    public Escuela getEscuelaById(Long id) {
        return escuelaRepository.findById(id).orElse(null);
    }

    //Método para crear/registrar una escuela
    public Escuela createEscuela(Escuela escuela) {
        return escuelaRepository.save(escuela);
    }

    //Método para editar una escuela
    public Escuela actualizarEscuela(Long id,Escuela escuela) {
        Escuela escuelaActual = escuelaRepository.findById(id).orElse(null);
        if(escuelaActual!=null) {
            escuelaActual.setNombre(escuela.getNombre());
            escuelaActual.setCreditos(escuela.getCreditos());
            escuelaActual.setNumEstudiantes(escuela.getNumEstudiantes());
            return escuelaRepository.save(escuelaActual);
        }else{
            return null;
        }

    }

    //Método para eliminar a una escuela sabiendo su id
    public void eliminarEscuela(Long id) {
        escuelaRepository.deleteById(id);
    }

}
