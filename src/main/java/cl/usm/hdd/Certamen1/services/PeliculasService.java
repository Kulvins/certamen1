package cl.usm.hdd.Certamen1.services;

import cl.usm.hdd.Certamen1.entities.Pelicula;

import java.util.List;

public interface PeliculasService {
    Pelicula crear(Pelicula pelicula);
    List<Pelicula> ver();
    List<Pelicula> filtrar(String limite);
}
