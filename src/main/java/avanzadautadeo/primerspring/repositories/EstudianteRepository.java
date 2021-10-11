package avanzadautadeo.primerspring.repositories;

import avanzadautadeo.primerspring.models.EstudianteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface EstudianteRepository extends CrudRepository<EstudianteModel, Long> {
    public abstract ArrayList<EstudianteModel> findByNombre(String nombre);


}
