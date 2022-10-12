package com.challangeAlkemy.controllers;
import com.challangeAlkemy.dto.ConvertirDto;
import com.challangeAlkemy.dto.PeliculaDtoITF;
import com.challangeAlkemy.dto.PeliculasDTO;
import com.challangeAlkemy.entities.Pelicula;
import com.challangeAlkemy.service.PeliculasServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PeliculaController {

    @Autowired
    PeliculasServiceImpl peliculasService;

    public PeliculaController(PeliculasServiceImpl ppeliculasService) {
        this.peliculasService = ppeliculasService;
    }

    @GetMapping("/")
    @ApiOperation("Inicio de la Api")
    public String inicio(){
        return "Bienvenido a Disney";
    }

    @GetMapping("/movies")
    @ApiOperation("Muestra todas las peliculas si las hay")
    public List<PeliculaDtoITF> listarPeliculas(){
        return peliculasService.listadoPeliculas();
    }
    @GetMapping("movies/detalle")
    @ApiOperation("Detalle : Muestra todos lo detalles de cada pelicula")
    public List<Pelicula> detalle(){
        return peliculasService.detalle();
    }
   @ApiOperation("Permite agregar peliculas")
   @PostMapping( value = "/movies")
    public ResponseEntity<Optional<Pelicula>> crearPelicula(@RequestBody Pelicula peliculaOserie){
        if(peliculasService.crearPelicula(peliculaOserie)){
            peliculasService.crearPelicula(peliculaOserie);
            return ResponseEntity.ok(peliculasService.encontrarPorId(peliculaOserie.getId()));
        }
            return ResponseEntity.badRequest().build();
   }

   @PutMapping(value = "/movies")
   @ApiOperation("Permite actualizar los datos de una pelicula, si enviamos un id que ya exista")
   @ApiParam("Pelicula")
    public Optional<Pelicula> actualizarPelicula(@RequestBody PeliculasDTO peliculasDTO){
       ConvertirDto convertirDto = new ConvertirDto();
        Pelicula pelicula = convertirDto.DtoAEntitiesPeliculas(peliculasDTO);
        return peliculasService.actualizarPelicula(pelicula);
   }
   @DeleteMapping(value = "/movies/{id}")
   @ApiOperation("Elimina peliculas enviando el id")
   @ApiParam("id")
    public List<Pelicula> eliminar(@PathVariable Long id){
       return peliculasService.eliminarPelicula(id);
   }

   @GetMapping(value = "/movies", params = "name")
   @ApiOperation("Busca pelicula por nombre")
   @ApiParam("name")
    public List<PeliculaDtoITF> buscarNombre(@RequestParam String name){

       return  peliculasService.buscarPorTitulo(name);
   }

    @GetMapping(value = "/movies",params = "order")
    @ApiOperation("Ordena las peliculas por fecha")
    @ApiParam("order")
    public ResponseEntity<List<PeliculaDtoITF>> ordenarPorFecha(@RequestParam String order){
        if((peliculasService.ordenar(order) == null)){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(peliculasService.ordenar(order), HttpStatus.OK);
    }

    @PostMapping(value = "/movies/{idMovie}/characters/{idCharacter}")
    @ApiOperation("Agrega personajes")
    public Optional<Pelicula> agregarPersonaje(@PathVariable Long idMovie,@PathVariable Long idCharacter){
       peliculasService.agregarPersonaje(idMovie, idCharacter);
        return peliculasService.encontrarPorId(idMovie);
        }

    @DeleteMapping("/movies/{idMovie}/characters/{idCharacter}")
    @ApiOperation("Eliminar personajes")
    public Optional<Pelicula> eliminarPersonaje(@PathVariable Long idMovie,@PathVariable Long idCharacter){
        peliculasService.eliminarPersonaje(idMovie, idCharacter);
        return peliculasService.encontrarPorId(idMovie);
    }
}
