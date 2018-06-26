package asw.agents.entities;

import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "agentes")
public class Agent implements AgentInterface{

	@Id
	private ObjectId id;
	private String nombre;
	private String password;
	private String email;
	private String ubicacion;
	private String identificador;
	private String kind;
	private int kindCode;

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
	
	public Agent()
	{
		
	}
	public Agent(String nombre, String password, String email, String identificador, String ubicacion,
			String kind, int kindCode) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.identificador = identificador;
		this.ubicacion = ubicacion;
		this.kind = kind;
		this.kindCode = kindCode;
	}
	
	public Agent(String nombre, String kind, int kindCode) {
		super();
		this.nombre = nombre;
		this.kind = kind;
		this.kindCode = kindCode;
	}

	public String getNombre() {
		return nombre;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
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
	public String toString() {
		return "Agent [nombre=" + nombre + ", email=" + email
				+ ", ubicacion=" + ubicacion + ", identificador=" + identificador + ", kind=" + kind + ", kindCode="
				+ kindCode + "]";
	}
	

	



}
