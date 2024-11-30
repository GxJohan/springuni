package com.example.utp1.service;
import com.example.utp1.model.Estudiante;
import com.example.utp1.model.Escuela;
import com.example.utp1.repository.EstudianteRepository;
import com.example.utp1.repository.EscuelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private EscuelaRepository escuelaRepository;

    //Método para obtener todos los estudiantes en una lista
    public List<Estudiante> getEstudiantes() {
        return estudianteRepository.findAll();
    }
    //Método para obtener un estudiante por su id
    public Estudiante getEstudianteId(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    //Método para crear/registrar un estudiante
    public Estudiante createEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    //Método para editar un estudiante
    public Estudiante actualizarEstudiante(Long id,Estudiante estudiante) {
        Estudiante estudianteActual = estudianteRepository.findById(id).orElse(null);
        //Saber la escuela a la que pertenece el estudiante
        Escuela escuela = escuelaRepository.findById(estudiante.getEscuela().getId()).orElse(null);
        if(estudianteActual!=null && escuela!=null) {
            estudianteActual.setCodigo(estudiante.getCodigo());
            estudianteActual.setNombre(estudiante.getNombre());
            estudianteActual.setApellido(estudiante.getApellido());
            estudianteActual.setEmail(estudiante.getEmail());
            estudianteActual.setEscuela(escuela);
            return estudianteRepository.save(estudianteActual);
        }else{
            return null;
        }

    }
    //Método para eliminar a un estudiante sabiendo su id
    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }


}
