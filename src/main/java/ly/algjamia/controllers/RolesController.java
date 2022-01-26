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
import ly.algjamia.services.RolesService;


@Controller
@RequestMapping(value="/roles")
public class RolesController {
	
	@Autowired
	RolesService rolesService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String ViewRolesList(Model model, @Param("Keyword") String Keyword) {
		List<Roles>  listRoles = rolesService.getAllRoles(Keyword);
		model.addAttribute("listRols",listRoles);
		model.addAttribute("Keyword", Keyword);
		return "roles_list";
	}
	
	@RequestMapping(value = "/ShowFormRoles", method = RequestMethod.GET)
	public String ShowFormRoles(Model model) {
		Roles roles = new Roles();
		model.addAttribute("roles", roles);
		return "roles_form";
	}
	
	@RequestMapping(value = "/AddRoles", method = RequestMethod.POST)
	public String AddRoles(@ModelAttribute("roles") Roles roles) {
		rolesService.addRoles(roles);
		return "redirect:/roles/list";
	}
	
	@RequestMapping(value = "/ShowFormRolesUpdate/{id}", method = RequestMethod.GET)
	public String ShowFormRolesUpdate(@PathVariable(value = "id") Long id, Model model) {
		Roles roles = rolesService.getRolesById(id);
		model.addAttribute("roles", roles);
		return "roles_form_update";
	}
	
	@RequestMapping(value = "/DeleteRoles/{id}", method = RequestMethod.GET)
	public String DeleteRoles(@PathVariable(value = "id") Long id) {
		rolesService.deleteRoles(id);
		return "redirect:/roles/list";
	}
}
