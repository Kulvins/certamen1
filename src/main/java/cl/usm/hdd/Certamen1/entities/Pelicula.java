package cl.usm.hdd.Certamen1.entities;

import lombok.*;

@Getter
@Setter
@ToString
public class Pelicula {
    private String nombre;
    private String nombreAbreviado;
    private int edadMinima;
    private String genero;
}
