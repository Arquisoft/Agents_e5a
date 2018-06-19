package asw.agents.prueba.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import asw.agents.prueba.entities.Agent;
import asw.agents.prueba.entities.AgentInterface;
import asw.agents.prueba.entities.RESTError;
import asw.agents.prueba.service.AgentsService;

@Controller
public class AgentsController {
	
	@Autowired
	AgentsService agentsService;
	
	@RequestMapping(value = "/info", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AgentInterface> showInfo(@RequestBody Map<String, Object> payload) {
		String login = (String) payload.get("login");
		String password = (String) payload.get("password");
		String kind = (String) payload.get("kind");
		RESTError e;
		if (payload.get("login") == null || payload.get("password") == null || payload.get("kind") == null) {
			e = new RESTError("406", "Faltan algunos parametros");
			return new ResponseEntity<AgentInterface>(e, HttpStatus.NOT_ACCEPTABLE);
		}
		Agent a = agentsService.findAgent(login, password, kind);
		e = new RESTError("404", "Usuario no encontrado");
		if (a != null)
			return new ResponseEntity<AgentInterface>(a, HttpStatus.OK);
		else
			return new ResponseEntity<AgentInterface>(e, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "login";
	}
	
	

}
