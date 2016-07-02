package domain;

import javax.persistence.*;

@Entity
public class Matricula implements BaseEntity<Long> {

	@Id
	@SequenceGenerator(name = "matricula_id_generator", sequenceName = "matricula_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matricula_id_generator")
	private Long id;

	@Column(name = "nota")
	private Double nota;

	@Column(name = "Semestre")
	private String semestre;

	@ManyToOne
	private Curso curso;

	@ManyToOne
	private Alumno alumno;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

}
