package asw.agents.prueba.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import asw.agents.prueba.entities.Agent;




@Repository
public interface AgentsRepository extends MongoRepository<Agent, Long> {
	
	
	public Agent findByEmail(String email);
	
}
