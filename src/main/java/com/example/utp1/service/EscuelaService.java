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

}
