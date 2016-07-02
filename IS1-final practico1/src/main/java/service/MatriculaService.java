package service;

import domain.Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.MatriculaRepository;

import java.util.Collection;

@Service
public class MatriculaService {
    @Autowired
    MatriculaRepository matriculaRepository;

    @Transactional
    public void save(Matricula matricula) {
        if (matricula.getId() == null) {
            matriculaRepository.persist(matricula);
        } else {
            matriculaRepository.merge(matricula);
        }
    }

    public Matricula get(Long id) {
        return matriculaRepository.find(id);
    }

    public Collection<Matricula> getAll() {
        return matriculaRepository.findAll();
    }
}
