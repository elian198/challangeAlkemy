package com.challangeAlkemy.controllers;

import com.challangeAlkemy.dto.GeneroDTO;
import com.challangeAlkemy.entities.Genero;
import com.challangeAlkemy.service.GeneroServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GeneroControllers {

    @Autowired
    private GeneroServiceImpl generos;

    public GeneroControllers(GeneroServiceImpl generos) {
        this.generos = generos;
    }
    @GetMapping( value = "/movies", params = "genre")
    @ApiOperation("Busca el genero por id")
    @ApiParam("genre")
    private Optional<Genero> buscarPorId(@RequestParam Long genre){
        return generos.buscarPorId(genre);
    }
    @PostMapping( value = "/genero")
    @ApiOperation("Crea nuevos generos")
    @ApiParam("Genero")
    public ResponseEntity<Genero> crearGenero(@RequestBody Genero genero){


        generos.crear(genero);
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "/genero")
    @ApiOperation("Muestra todos los generos que hay")
    public List<Genero> listarGenero(){
        return generos.listar();
    }

}
