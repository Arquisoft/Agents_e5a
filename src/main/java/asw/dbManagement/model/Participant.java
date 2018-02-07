package asw.dbManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Participant")
public class Participant {

	// Id generado automáticamente para diferenciar cada uno (para mapear)
	@Id
	@GeneratedValue
	private Long id;

	// Atributos del participante
	private String nombre;
	//private String apellidos;
	private String password;
	//private Date fechaNacimiento;
	@Column(unique = true)
	private String email;
	
	private String ubicacion;
	//@Column(unique = true)
	//private String DNI;
	private String identificador;
	//private String direccion;
	//private String nacionalidad;
	private String kind;
	private int kindCode;
	//private boolean isAdmin;
	//private boolean isPolitician;

	/**
	 * Constructor vacío (ya que es para mapear)
	 */
	Participant() {
	}

	/**
	 * Constructor
	 * 
	 * @param nombre
	 * @param password
	 * @param email
	 * @param dNI
	 * @param kind
	 * @param kindCode
	 */
	public Participant(String nombre, String password, String email, String identificador, String ubicacion,
			String kind, int kindCode) {
		super();
		this.nombre = nombre;
		//this.apellidos = apellidos;
		this.password = password;
		//this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.identificador = identificador;
		//this.direccion = direccion;
		//this.nacionalidad = nacionalidad;
		//this.isAdmin = isAdmin;
		//this.isPolitician = isPolitician;
		this.ubicacion = ubicacion;
		this.kind = kind;
		this.kindCode = kindCode;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

//	public String getApellidos() {
//		return apellidos;
//	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public Date getFechaNacimiento() {
//		return fechaNacimiento;
//	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
//
//	public String getDNI() {
//		return DNI;
//	}

//	public String getDireccion() {
//		return direccion;
//	}
//
//	public String getNacionalidad() {
//		return nacionalidad;
//	}

//	public boolean isAdmin() {
//		return isAdmin;
//	}
//
//	public void setAdmin(boolean isAdmin) {
//		this.isAdmin = isAdmin;
//	}
//
//	public boolean isPolitician() {
//		return isPolitician;
//	}
//
//	public void setPolitician(boolean isPolitician) {
//		this.isPolitician = isPolitician;
//	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getKindCode() {
		return kindCode;
	}

	public void setKindCode(int kindCode) {
		this.kindCode = kindCode;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participant other = (Participant) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", nombre=" + nombre + ", password=" + password + ", email=" + email
				+ ", ubicacion=" + ubicacion + ", identificador=" + identificador + ", kind=" + kind + ", kindCode="
				+ kindCode + "]";
	}

	



}