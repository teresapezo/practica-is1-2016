package domain;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class Alumno implements BaseEntity<Long> {

	@Id
	@SequenceGenerator(name = "alumno_id_generator", sequenceName = "alumno_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alumno_id_generator")
	private Long id;

	@Column(name = "nombres")
	private String nombres;

	@Column(name = "apellidoPaterno")
	private String apellidoPaterno;

	@Column(name = "apellidoMaterno")
	private String apellidoMaterno;

	@OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY)
	private Collection<Matricula> origenmatricula;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

}
