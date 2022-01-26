package ly.algjamia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ly.algjamia.model.Roles;
import ly.algjamia.model.Users;
import ly.algjamia.services.UserService;


@Controller
@RequestMapping(value="/users")
public class AllUsersController {
	
	@Autowired
	UserService usersService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String ViewUsersList(Model model, @Param("username") String username) {
		List<Users>  listUsers = usersService.getAllUsers(username);
		model.addAttribute("listUsers",listUsers);
		model.addAttribute("username", username);
		return "users_list";
	}
	
	@RequestMapping(value = "/ShowFormUsers", method = RequestMethod.GET)
	public String ShowFormUsers(Model model) {
		Users users = new Users();
		model.addAttribute("users", users);
		List<Roles> listroles = usersService.findRoles();
		model.addAttribute("listroles", listroles);
		return "users_form";
	}
	
	@RequestMapping(value = "/AddUsers", method = RequestMethod.POST)
	public String AddUsers(@ModelAttribute("users") Users users) {
		
		usersService.saveAdmin(users);
		return "redirect:/users/list";
	}
	
	@RequestMapping(value = "/ShowFormUsersUpdate/{id}", method = RequestMethod.GET)
	public String ShowFormUsersUpdate(@PathVariable(value = "id") Long id, Model model) {
		Users users = usersService.getUsersById(id);
		model.addAttribute("users", users);
		List<Roles> listroles = usersService.findRoles();
		model.addAttribute("listroles", listroles);
		return "users_form_update";
	}
	
	@RequestMapping(value = "/DeleteUsers/{id}", method = RequestMethod.GET)
	public String DeleteUsers(@PathVariable(value = "id") Long id) {
		usersService.delete(id);
		return "redirect:/users/list";
	}
}
