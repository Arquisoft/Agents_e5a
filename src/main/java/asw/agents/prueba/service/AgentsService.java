package asw.agents.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.agents.prueba.entities.Agent;
import asw.agents.prueba.repository.AgentsRepository;

@Service
public class AgentsService {
	
	@Autowired
	private AgentsRepository agentsRepository;
	
//	public String encripta(String usuario, String password, String kind) {
//		String pass = password + kind + usuario;
//		return String.valueOf(pass.hashCode());
//	}
	
	/**
	 * Método que devuelve el Agente buscado por email
	 * Hace uso del método findByEmail (mapeador)
	 */
	public Agent getAgent(String email) {
		
		return agentsRepository.findByEmail(email);
	}

	public Agent findAgent(String email, String password, String kind) {
		Agent a = getAgent(email);
		if(a == null)
			return null;
		
		else
		{
			if(a.getPassword().equals(password) && a.getKind().equals(kind))
				return a;
			else
				return null;
		}
	}

}
