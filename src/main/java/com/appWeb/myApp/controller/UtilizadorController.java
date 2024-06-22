package com.appWeb.myApp.controller;

import com.appWeb.myApp.controller.dto.UtilizadorDTO;
import com.appWeb.myApp.domain.Utilizador;
import com.appWeb.myApp.service.IServiceUtilizador;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/utilizador/")
public class UtilizadorController {

    @Autowired
    IServiceUtilizador iServiceUtilizador;

    @Autowired
    ModelMapper modelMapper;


    @PostMapping
    public Utilizador adicionarUtilizador(@RequestBody Utilizador utilizador) {
        return iServiceUtilizador.adicionarUtilizador(utilizador );
    }

    @GetMapping
    public List<UtilizadorDTO>getAll(){
        return iServiceUtilizador.getAll().stream()
                .map(u -> convertToDTO(u))
                .collect(Collectors.toList());

    }

    private UtilizadorDTO convertToDTO(Object utilizador){
        return modelMapper.map(utilizador,UtilizadorDTO.class);
    }
}
