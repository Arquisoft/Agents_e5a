package asw.agents.prueba.controller;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import asw.agents.prueba.entities.Agent;
import asw.agents.prueba.entities.AgentInterface;
import asw.agents.prueba.entities.RESTError;
import asw.agents.prueba.service.AgentsService;
import asw.agents.prueba.service.SecurityService;

@Controller
public class AgentsController {

	@Autowired
	AgentsService agentsService;

	@Autowired
	SecurityService securityService;

	/**
	 * Implementa la respuesta a la peticion rest de inicio de sesion retornando los
	 * errores que se especifican a continuacion en caso de login incorrecto
	 * 
	 * @param payload,
	 *            el cuerpo de la peticion que se recibe
	 * @return 406, en caso de que falten algunos parametros en la peticion
	 * @return 404, en caso de que no se encuentre el usuario
	 * @return 200, y la informacion del usuario, en caso de que el usuario exista y
	 *         los datos sean correctos
	 */
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

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String perfilUsuario(Principal agente, Model model) {
		Agent agent = agentsService.getAgent(agente.getName());
		model.addAttribute(agent);
		return "profile";
	}
	
	@PostMapping(value="/profile/cambiarContraseña")
	public String cambiarContraseña(Model model, @ModelAttribute Agent agente, @RequestParam String email, @RequestParam String password)
	{
		Agent original=agentsService.getAgent(email);
		original.setPassword(password);
		agentsService.updateAgent(original);
		return "redirect:/";
				
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(@RequestParam String email, @RequestParam String password, @RequestParam String type) {
		Agent agent = agentsService.getAgent(email);
		if (agent == null || !agent.getKind().equals(type))
			return "redirect:/login?error";
		try {
			securityService.autoLogin(email, password);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/login?error";
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/userLogout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}

}
