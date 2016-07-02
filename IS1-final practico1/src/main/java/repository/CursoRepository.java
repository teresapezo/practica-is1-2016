package repository;

import domain.Curso;

import java.util.Collection;

public interface CursoRepository extends BaseRepository<Curso, Long> {
    Curso buscarPorCodigo(String codigo);
    Collection<Curso> buscarPorNombre(String nombre);
}
