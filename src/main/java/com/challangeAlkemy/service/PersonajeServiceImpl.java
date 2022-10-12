package com.challangeAlkemy.service;

import com.challangeAlkemy.dto.ConvertirDto;
import com.challangeAlkemy.dto.PersonajeDtoNyI;
import com.challangeAlkemy.entities.Personaje;
import com.challangeAlkemy.excepciones.PeliculaNoExiste;
import com.challangeAlkemy.excepciones.UsuarioNoExiste;
import com.challangeAlkemy.repository.PersonajeRepositorio;
import com.challangeAlkemy.service.service.PersonajeService;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@ApiModel("Clase de tipo servicio donde se implemanta toda la logica de los Personajes ")

public class PersonajeServiceImpl implements PersonajeService {
    @Autowired
    private PersonajeRepositorio personajeRepositorio;

    public PersonajeServiceImpl(PersonajeRepositorio personajeRepositorio) {
        this.personajeRepositorio = personajeRepositorio;
    }

    @Override
    public List<PersonajeDtoNyI> buscarNombre(String name) {
        if(personajeRepositorio.buscarPorNombre(name)== null){
            throw new PeliculaNoExiste(HttpStatus.NOT_FOUND,"la pelicula no existe");
        }
        ConvertirDto convertirDto = new ConvertirDto();
        return convertirDto.convertirAPersonajeDtoNyI(personajeRepositorio.buscarPorNombre(name));
    }

    @Override
    public List<PersonajeDtoNyI> buscarEdad(Integer age) {
        ConvertirDto convertirDto = new ConvertirDto();
        return  convertirDto.convertirAPersonajeDtoNyI(personajeRepositorio.buscarPorEdad(age));
    }
    @Override
    public List<PersonajeDtoNyI> buscarPorPeso(Double peso) {
        ConvertirDto convertirDto = new ConvertirDto();
        return convertirDto.convertirAPersonajeDtoNyI(personajeRepositorio.buscarPorPeso(peso));
    }

    @Override
    public Optional<Personaje> buscarPorId(Long id) {
        if(id.equals(null)){
            return  null;
        }
        return personajeRepositorio.findById(id);
    }

    @Override
    public List<PersonajeDtoNyI> listaPersonajes() {
       ConvertirDto convertirDto = new ConvertirDto();
     return convertirDto.convertirAPersonajeDtoNyI(personajeRepositorio.findAll());
    }
    @Override
    public List<Personaje> detalle(){
        return personajeRepositorio.findAll();
    }
    @Override
    public Optional<Personaje> actualizar(Personaje personaje){
        if(personajeRepositorio.existsById(personaje.getId()) && filtrarCamposVacios(personaje)){
            personajeRepositorio.save(personaje);
            return personajeRepositorio.findById(personaje.getId());
        }
        return null;
    }
    @Override
     public Personaje crear(Personaje personaje){
        if(filtrarCamposVacios(personaje)){
            personajeRepositorio.save(personaje);
            return personaje;
        }
        return null;
   }
    private Boolean filtrarCamposVacios(Personaje personaje){
        if(personaje.getNombre().equalsIgnoreCase(null) ||
                personaje.getImagen().equalsIgnoreCase(null)||
                personaje.getHistoria().equalsIgnoreCase(null) ||
                personaje.getEdad().equals(null) ||
                personaje.getPeso().equals(null)){
            throw  new NullPointerException();
        }
        return true;
    }

    @Override
    public List<Personaje> eliminar(Long id) {
        personajeRepositorio.deleteById(id);
        return personajeRepositorio.findAll();
    }

}

