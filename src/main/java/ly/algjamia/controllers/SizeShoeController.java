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
import ly.algjamia.model.SizeShoe;
import ly.algjamia.services.SizeShoeService;



@Controller
@RequestMapping(value="/admin/sizeshoe")
public class SizeShoeController {
	
	@Autowired
	SizeShoeService sizeShoeService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String ViewSizeShoeList(Model model, @Param("Keyword") String Keyword) {
		List<SizeShoe>  listSizeShoe = sizeShoeService.getAllSizeShoe(Keyword);
		model.addAttribute("listSizeShoe",listSizeShoe);
		model.addAttribute("Keyword", Keyword);
		return "sizeshoe_list";
	}
	
	@RequestMapping(value = "/ShowFormSizeShoe", method = RequestMethod.GET)
	public String ShowFormSizeShoe(Model model) {
		SizeShoe sizeShoe = new SizeShoe();
		model.addAttribute("sizeShoe", sizeShoe);
		return "sizeshoe_form";
	}
	
	@RequestMapping(value = "/AddSizeShoe", method = RequestMethod.POST)
	public String AddSizeShoe(@ModelAttribute("sizeshoe") SizeShoe sizeShoe) {
		sizeShoeService.addSizeShoe(sizeShoe);
		return "redirect:/admin/sizeshoe/list";
	}
	
	@RequestMapping(value = "/ShowFormSizeShoeUpdate/{id}", method = RequestMethod.GET)
	public String ShowFormSizeShoeUpdate(@PathVariable(value = "id") Long id, Model model) {
		SizeShoe sizeShoe = sizeShoeService.getSizeShoeById(id);
		model.addAttribute("sizeShoe", sizeShoe);
		return "sizeshoe_form_update";
	}
	
	@RequestMapping(value = "/DeleteSizeShoe/{id}", method = RequestMethod.GET)
	public String DeleteSizeShoe(@PathVariable(value = "id") Long id) {
		sizeShoeService.deleteSizeShoe(id);
		return "redirect:/admin/sizeshoe/list";
	}
}
