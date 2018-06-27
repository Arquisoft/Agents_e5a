package uo.asw.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import uo.asw.entities.Agent;





@Repository
public interface AgentsRepository extends MongoRepository<Agent, ObjectId> {
	
	
	public Agent findByEmail(String email);
	
}
