package asw.agents.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import asw.agents.entities.Agent;





@Repository
public interface AgentsRepository extends MongoRepository<Agent, ObjectId> {
	
	
	public Agent findByEmail(String email);
	
}
