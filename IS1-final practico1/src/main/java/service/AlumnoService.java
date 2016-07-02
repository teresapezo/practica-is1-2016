package service;

import domain.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.AlumnoRepository;

import java.util.Collection;

@Service
public class AlumnoService {
    @Autowired
    AlumnoRepository alumnoRepository;

    @Transactional
    public void save(Alumno alumno) {
        if (alumno.getId() == null) {
            alumnoRepository.persist(alumno);
        } else {
            alumnoRepository.merge(alumno);
        }
    }

    public Alumno get(Long id) {
        return alumnoRepository.find(id);
    }

    public Collection<Alumno> getAll() {
        return alumnoRepository.findAll();
    }

    public Alumno buscarPorApellido(String alumno){ return alumnoRepository.buscarPorApellido(alumno);}
}
