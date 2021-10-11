package avanzadautadeo.primerspring.controllers;

import avanzadautadeo.primerspring.models.EstudianteModel;
import avanzadautadeo.primerspring.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
    @Autowired
    EstudianteService estudianteService;

    @GetMapping()
    public ArrayList<EstudianteModel> obtenerEstudiantes(){
        return estudianteService.obtenerEstudiantes();
    }

    @PostMapping()
    public EstudianteModel guardarEstudiante(@RequestBody EstudianteModel estudiante){
        return this.estudianteService.guardarEstudiante(estudiante);
    }

    @GetMapping(path = "/{id}")
    public Optional<EstudianteModel> obtenerEstudiantePorId(@PathVariable("id") Long id){
        return this.estudianteService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<EstudianteModel> obtenerEstudiantePorNombre(@RequestParam("nombre") String nombre){
        return this.estudianteService.obtenerPorNombre(nombre);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.estudianteService.eliminarEstudiante(id);
        if (ok){
            return "Se elimino el usuario" + id;
        }else{
            return "No se pudo eliminar el usuario" + id;
        }
    }
}
