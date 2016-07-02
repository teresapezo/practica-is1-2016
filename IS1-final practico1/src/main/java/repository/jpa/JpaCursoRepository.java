package repository.jpa;

import domain.Operation;
import org.springframework.stereotype.Repository;
import repository.CursoRepository;
import domain.Curso;

import javax.persistence.TypedQuery;
import java.util.Collection;

@Repository
public class JpaCursoRepository extends JpaBaseRepository<Curso, Long> implements
        CursoRepository {
        @Override
        public Curso buscarPorCodigo(String curso) {
                String squery = "SELECT a FROM Curso a WHERE a.codigoC =:codigo";
                TypedQuery<Curso> query = entityManager.createQuery(squery,Curso.class);
                query.setParameter("codigo",curso);
                return getFirstResult(query);
        }

        @Override
        public Collection<Curso> buscarPorNombre(String nombre) {
                String squery = "SELECT a FROM Curso a WHERE a.nombre like :nombre%";
                TypedQuery<Curso> query = entityManager.createQuery(squery,Curso.class);
                query.setParameter("nombre",nombre);
                return query.getResultList();
        }
}