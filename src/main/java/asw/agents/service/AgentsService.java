package asw.agents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.agents.entities.Agent;
import asw.agents.repository.AgentsRepository;


@Service
public class AgentsService {
	
	@Autowired
	private AgentsRepository agentsRepository;
	
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
	/**
	 * Metodo que actualiza el agente pasado por parametro
	 * @param agent, el agente con la informacion actualizada para ser guardado por la base de datos
	 */
	public void updateAgent(Agent agent) {
		System.out.println(agent.getPassword());
		agentsRepository.save(agent);
	}

}
