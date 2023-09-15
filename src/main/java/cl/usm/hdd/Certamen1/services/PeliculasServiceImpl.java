package cl.usm.hdd.Certamen1.services;

import cl.usm.hdd.Certamen1.entities.Pelicula;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeliculasServiceImpl implements PeliculasService{
    private static List<Pelicula> peliculas = new ArrayList<>();
    @Override
    public Pelicula crear(Pelicula pelicula) {
        peliculas.add(pelicula);
        return pelicula;
    }

    @Override
    public List<Pelicula> ver() {
        return peliculas;
    }

    @Override
    public List<Pelicula> filtrar(String limite) {
        switch (limite){
            case "Menor_edad":
                return peliculas.stream().filter(p->p.getEdadMinima()<=15).collect(Collectors.toList());
            case ("Adolescentes"):
                return peliculas.stream().filter(p->p.getEdadMinima()>15 && p.getEdadMinima()<18).collect(Collectors.toList());
            case ("Mayor") :
                return peliculas.stream().filter(p -> p.getEdadMinima() >= 18).collect(Collectors.toList());
            default:
                return null;
        }
    }
}
