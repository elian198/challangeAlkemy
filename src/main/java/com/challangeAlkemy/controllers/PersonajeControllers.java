package com.challangeAlkemy.controllers;

import com.challangeAlkemy.dto.ConvertirDto;
import com.challangeAlkemy.dto.PersonajeDTO;
import com.challangeAlkemy.dto.PersonajeDtoNyI;
import com.challangeAlkemy.entities.Personaje;
import com.challangeAlkemy.security.payload.MessageResponse;
import com.challangeAlkemy.service.PersonajeServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.DataOutput;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonajeControllers {

    @Autowired
    PersonajeServiceImpl personajeServiceImpl;

    public PersonajeControllers(PersonajeServiceImpl personajeServiceImpl) {
        this.personajeServiceImpl = personajeServiceImpl;
    }

    @GetMapping("/characters")
    @ApiOperation("Muestra todos los personajes y peliculas asociadas")
    public List<PersonajeDtoNyI> listaPersonaje() {
        return personajeServiceImpl.listaPersonajes();
    }
    @GetMapping("/characters/detalle")
    @ApiOperation("Permite ver todos los detalles de los personajes")
    public List<Personaje> detalle(){
        return personajeServiceImpl.detalle();
    }
    @PostMapping("/characters")
    @ApiOperation("Permite crear personajes")
    @ApiParam("Personaje")
    public ResponseEntity<MessageResponse> crearPersonaje(@RequestBody PersonajeDTO personajeDTO){
        if(personajeDTO == null){
            return ResponseEntity.badRequest().body(new MessageResponse("Error!!! No puede enviar campo vacios"));
        }
        ConvertirDto convertirDto = new ConvertirDto();
        Personaje personaje  = convertirDto.DtoAEntitiesPersonaje(personajeDTO);
        personajeServiceImpl.crear(personaje);
        return ResponseEntity.ok(new MessageResponse("Personaje creado exitosamente"));
    }
    @DeleteMapping(value = "/characters/{id}")
    @ApiOperation("Eliminar personajes ingresando el ID")
    @ApiParam("id")
    public List<Personaje> eliminarPersonaje(@PathVariable Long id) {
        return personajeServiceImpl.eliminar(id);
    }

    @PutMapping("/characters")
    @ApiOperation("Permite actualizar un personaje")
    @ApiParam("Personaje")
    public ResponseEntity<Optional<Personaje>> actualizarPersoaje(@RequestBody PersonajeDTO personajeDTO){
        ConvertirDto convertirDto = new ConvertirDto();
        Personaje personaje = convertirDto.DtoAEntitiesPersonaje(personajeDTO);
        return ResponseEntity.ok(personajeServiceImpl.actualizar(personaje));
    }
    @GetMapping(value = "/characters", params = "age")
    @ApiOperation("Permite ver los datos del personaje ingresando la edad")
    @ApiParam("age")
    public List<PersonajeDtoNyI> buscarPorEdad(@RequestParam Integer age){

        return personajeServiceImpl.buscarEdad(age);
    }

    @GetMapping(value = "/characters", params = "name")
    @ApiOperation("Busca el personaje ingresando el nombre")
    @ApiParam("name")
    public List<PersonajeDtoNyI> buscarPorNombre(@RequestParam String name){
    return personajeServiceImpl.buscarNombre(name);
    }
    @GetMapping(value = "/characters", params = "peso")
    @ApiOperation("Permite ver el personaje ingresando el peso")
    @ApiParam("peso")
    public List<PersonajeDtoNyI> buscarPorPeso(@RequestParam Double peso){

        return personajeServiceImpl.buscarPorPeso(peso);
    }

}
