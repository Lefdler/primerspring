package avanzadautadeo.primerspring.services;

import avanzadautadeo.primerspring.models.EstudianteModel;
import avanzadautadeo.primerspring.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    public ArrayList<EstudianteModel> obtenerEstudiantes(){
        return (ArrayList<EstudianteModel>) estudianteRepository.findAll();
    }

    public EstudianteModel guardarEstudiante(EstudianteModel estudiante){
        return estudianteRepository.save(estudiante);
    }

    public Optional<EstudianteModel> obtenerPorId(Long id){
        return estudianteRepository.findById(id);
    }

    public ArrayList<EstudianteModel> obtenerPorNombre(String nombre){
        return estudianteRepository.findByNombre(nombre);
    }

    public boolean eliminarEstudiante(Long id){
        try{
            estudianteRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
