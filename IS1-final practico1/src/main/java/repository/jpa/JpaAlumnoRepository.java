package repository.jpa;

import org.springframework.stereotype.Repository;
import repository.AlumnoRepository;
import domain.Alumno;

import javax.persistence.TypedQuery;

@Repository
public class JpaAlumnoRepository extends JpaBaseRepository<Alumno, Long> implements
        AlumnoRepository {
        @Override
        public Alumno buscarPorApellido(String alumno) {
                String squery = "SELECT a FROM Alumno a WHERE a.apellidoPaterno = :apellido";
                TypedQuery<Alumno> query = entityManager.createQuery(squery, Alumno.class);
                query.setParameter("apellido", alumno);
                return getFirstResult(query);
        }
}
