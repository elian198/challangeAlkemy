package com.challangeAlkemy.dto;

import com.challangeAlkemy.entities.Pelicula;
import com.challangeAlkemy.entities.Personaje;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertirDto implements Serializable {


    public PersonajeDTO entitiesADtoPersonaje(final Personaje entity) {
        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setNombre(entity.getNombre());
        personajeDTO.setImagen(entity.getImagen());
        personajeDTO.setEdad(entity.getEdad());
        personajeDTO.setPeso(entity.getPeso());
        personajeDTO.setHistoria(entity.getHistoria());
        personajeDTO.setPeliculas(entity.getPelicula());
        // set all the properties you want
        return personajeDTO;
    }


    public Personaje DtoAEntitiesPersonaje(PersonajeDTO dto) {
        Personaje personaje = new Personaje();
        personaje.setId(dto.getId());
        personaje.setNombre(dto.getNombre());
        personaje.setImagen(dto.getImagen());
        personaje.setEdad(dto.getEdad());
        personaje.setPeso(dto.getPeso());
        personaje.setHistoria(dto.getHistoria());
        personaje.setPelicula(dto.getPeliculas());
        // set all the properties you want
        return personaje;
    }

    public Pelicula DtoAEntitiesPeliculas(PeliculasDTO peliculasDTO){
        Pelicula pelicula = new Pelicula();
        pelicula.setId(peliculasDTO.getId());
        pelicula.setImagen(pelicula.getImagen());
        pelicula.setTitulo(pelicula.getTitulo());
        pelicula.setFecha((Date) peliculasDTO.getFecha());
        pelicula.setCalificacion(pelicula.getCalificacion());
        return pelicula;
    }
    public List<PersonajeDtoNyI> convertirAPersonajeDtoNyI(List<Personaje> personajeList){
        List<PersonajeDtoNyI> dto = new ArrayList<>();
        for(Personaje personaje : personajeList){
            dto.add(new PersonajeDtoNyI(personaje.getNombre(), personaje.getImagen()));
        }
        return dto;
    }

    public List<PeliculaDtoITF> convertirAPeliculaDtoITF(@NotNull List<Pelicula> peliculaList){
       List<Pelicula> lista = peliculaList;
        List<PeliculaDtoITF> dto = new ArrayList();
        for(Pelicula pelicula : lista){
            dto.add(new PeliculaDtoITF(pelicula.getImagen(),pelicula.getTitulo(), pelicula.getFecha()));
        }
      return dto;
    }
}
