package domain;

import java.util.Collection;
import java.util.List;

import javax.persistence.*;
import java.util.List;

@Entity
public class Curso implements BaseEntity<Long> {

	@Id
	@SequenceGenerator(name = "curso_id_generator", sequenceName = "curso_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_id_generator")
	private Long id;

	@Column(name = "codigo")
	private String codigoC;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "creditos")
	private Integer creditos;

	@OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
	private List<Matricula> matriculaCurso;

	//private List<Curso> prerequisitos;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigoC;
	}

	public void setCodigo(String codigo) {
		this.codigoC = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	/*public List<Curso> getPrerequisitos() {
		return prerequisitos;
	}

	public void setPrerequisitos(List<Curso> prerequisitos) {
		this.prerequisitos = prerequisitos;
	}*/

}
