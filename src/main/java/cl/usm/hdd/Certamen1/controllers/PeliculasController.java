package cl.usm.hdd.Certamen1.controllers;

import cl.usm.hdd.Certamen1.entities.Pelicula;
import cl.usm.hdd.Certamen1.services.PeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
public class PeliculasController {
    @Autowired
    private PeliculasService peliculasService;
    private boolean validLimit(String tipoLimite){
        String [] limites = {"Menor_edad","Adolescentes","Mayor"};
        return Stream.of(limites).anyMatch(l->l.equals(tipoLimite));
    }

    @PostMapping("/crearPelicula")
    public ResponseEntity<Pelicula> crear(@RequestBody Pelicula pelicula){
        try{
            Pelicula peli = peliculasService.crear(pelicula);
            return ResponseEntity.ok(peli);
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("/verPeliculas")
    public ResponseEntity<List<Pelicula>> ver(){
        try{
            return ResponseEntity.ok(this.peliculasService.ver());
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/peliculas/{tipo}")
    public ResponseEntity<List<Pelicula>> filtrar(@PathVariable String tipo){
        if (!validLimit(tipo)){
            ResponseEntity.badRequest().build();
        }
        try{
            return ResponseEntity.ok(this.peliculasService.filtrar(tipo));
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }
}
