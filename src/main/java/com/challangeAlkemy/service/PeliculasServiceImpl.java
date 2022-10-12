package com.challangeAlkemy.service;
import com.challangeAlkemy.dto.ConvertirDto;
import com.challangeAlkemy.dto.PeliculaDtoITF;
import com.challangeAlkemy.entities.Pelicula;
import com.challangeAlkemy.entities.Personaje;
import com.challangeAlkemy.repository.PeliculaOserieRepositorio;
import com.challangeAlkemy.repository.PersonajeRepositorio;
import com.challangeAlkemy.service.service.PeliculasService;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@ApiModel("Clase de tipo servicio donde se implemanta toda la logica de las peliculas ")
public class PeliculasServiceImpl implements PeliculasService {
    @Autowired
    PeliculaOserieRepositorio peliculas;

    @Autowired
    PersonajeRepositorio personajeRepositorio;
    public PeliculasServiceImpl(PeliculaOserieRepositorio peliculas) {
        this.peliculas = peliculas;
    }
    @Override
    public Boolean crearPelicula(Pelicula peliculaOserie){
        if(peliculaOserie.getCalificacion()<6 && peliculaOserie.getCalificacion()>0) {
            peliculas.save(peliculaOserie);
            return true;
        }
        return false;
    }
    @Override
    public List<PeliculaDtoITF> listadoPeliculas(){
        ConvertirDto convertirDto = new ConvertirDto();
         return  convertirDto.convertirAPeliculaDtoITF(peliculas.findAll());
    }
    @Override
    public List<Pelicula> detalle(){
        return peliculas.findAll();
    }

    @Override
    public Optional<Pelicula> encontrarPorId(Long id) {
        return peliculas.findById(id);
    }


    public List<Pelicula> eliminarPelicula(Long id){
      peliculas.deleteById(id);
      return peliculas.findAll();

    }
    public Optional<Pelicula> actualizarPelicula(Pelicula peliculaOserie){
      if(!peliculas.existsById(peliculaOserie.getId())){
          return null;
      }
      peliculas.save(peliculaOserie);
        return peliculas.findById(peliculaOserie.getId());
    }

    public List<PeliculaDtoITF> buscarPorTitulo(String nombre) {
        ConvertirDto convertirDto = new ConvertirDto();
        return convertirDto.convertirAPeliculaDtoITF(peliculas.buscarPorTitulo(nombre));
    }
    public List<PeliculaDtoITF> ordenar(String nombre){
        ConvertirDto convertirDto = new ConvertirDto();
        if(nombre.equalsIgnoreCase("desc")) {
            return convertirDto.convertirAPeliculaDtoITF(peliculas.ordenarDESC());
        }
        else if(nombre.equalsIgnoreCase("asc")){
            return convertirDto.convertirAPeliculaDtoITF(peliculas.ordenarASC());
        }
        return null;
      }

    public void agregarPersonaje(Long idMovie, Long idPersonaje){
        Pelicula pelicula = peliculas.findById(idMovie).get();
        Personaje personaje = personajeRepositorio.findById(idPersonaje).get();
        pelicula.getPersonaje().add(personaje);
        peliculas.save(pelicula);
       }
    public void eliminarPersonaje(Long idMovie, Long idPersonaje){
        Pelicula pelicula = peliculas.findById(idMovie).get();
        Personaje personaje = personajeRepositorio.findById(idPersonaje).get();
        pelicula.getPersonaje().remove(personaje);
        peliculas.save(pelicula);
    }
    }


