package service;

import domain.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CursoRepository;

import java.util.Collection;

@Service
public class CursoService {
    @Autowired
    CursoRepository cursoRepository;

    @Transactional
    public void save(Curso curso) {
        if (curso.getId() == null) {
            cursoRepository.persist(curso);
        } else {
            cursoRepository.merge(curso);
        }
    }

    public Curso get(Long id) {
        return cursoRepository.find(id);
    }

    public Collection<Curso> getAll() {
        return cursoRepository.findAll();
    }

    public Curso buscarPorCodigo(String curso){ return cursoRepository.buscarPorCodigo(curso);}

    public Collection<Curso> buscarPorNombre(String curso){ return cursoRepository.buscarPorNombre(curso);}
}
