package ly.algjamia.controllers;



import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;

import ly.algjamia.model.Roles;
import ly.algjamia.model.SessionHistory;
import ly.algjamia.model.Users;
import ly.algjamia.services.SessionHistoryService;
import ly.algjamia.services.UserService;
import ly.algjamia.valeditor.UserValidator;

@Controller

public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private SessionHistoryService sessionHistoryService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new Users());
		List<Roles> listroles = userService.findRoles();
		model.addAttribute("listroles", listroles);
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") Users userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		
		userService.save(userForm);
		return "redirect:/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request,HttpSession session, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			
		}
		SessionHistory sessionHistory = sessionHistoryService.findSessionHistoryBySessionId(RequestContextHolder.currentRequestAttributes().getSessionId());
		sessionHistory.setEndOfSession(new Date());
		sessionHistoryService.save(sessionHistory);
		return "redirect:/login";
	}

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String welcome(Model model,HttpSession session,HttpServletRequest request) {
		SessionHistory sessionHistory = new SessionHistory();
		sessionHistory.setSessionId(session.getId());
		sessionHistory.setDateOfLogin(new Date());
		sessionHistory.setTimeOfLogin(new Date());
		sessionHistory.setDeviceOfLogin(request.getHeader("referer"));
		sessionHistory.setIPOfLogin(request.getRemoteAddr());
		sessionHistory.setToolsOfLogin(request.getHeader("User-Agent"));
		String UserName = request.getUserPrincipal().getName();
		sessionHistory.setUsers(userService.findByUsername(UserName));
		sessionHistoryService.save(sessionHistory);
		return "index";
	}
	
	
	@GetMapping("/access-denied")
    public String getAccessDenied() {
		return "accessdenied";
    }
	/*
	 * @RequestMapping(value = { "/access-denied" }, method = RequestMethod.GET)
	 * public String accessDenied(HttpServletResponse response , HttpServletRequest
	 * request) { return "redirect:/accessdenied"; }
	 */
	
}