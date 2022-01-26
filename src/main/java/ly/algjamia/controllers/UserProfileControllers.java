package ly.algjamia.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ly.algjamia.model.UserProfile;
import ly.algjamia.model.Users;
import ly.algjamia.model.UsersSetting;
import ly.algjamia.services.UserProfileService;
import ly.algjamia.services.UserService;

@Controller
@RequestMapping(value="/userProfile")
public class UserProfileControllers {
	@Autowired
	UserProfileService userProfileService;

	@Autowired
	UserService userService;
	

	@RequestMapping(value = "/OverViewUser", method = RequestMethod.GET)
	public String OverViewUser(Model model, HttpServletRequest request) {
		String username=request.getUserPrincipal().getName();
		 Users users = userService.findByUsername(username);
		model.addAttribute("users", users);
		UserProfile userProfile = userProfileService.getUserProfile(users.getId());
		model.addAttribute("userProfile", userProfile);
		UsersSetting usersSetting = userProfileService.getUserSetting(users.getId());
		model.addAttribute("usersSetting", usersSetting);
		return "profile";
	}

	@RequestMapping(value = "/ShowProfile", method = RequestMethod.GET)
	public String ShowProfileUser(Model model, HttpServletRequest request) {
		String username=request.getUserPrincipal().getName();
		 Users users = userService.findByUsername(username);
		model.addAttribute("users", users);
		UserProfile userProfile = userProfileService.getUserProfile(users.getId());
		model.addAttribute("userProfile", userProfile);
		return "profile";
	}
	
	@RequestMapping(value = "/updateUserProfile", method = RequestMethod.GET)
	public String updateUserProfile(Model model, HttpServletRequest request) {
		String username=request.getUserPrincipal().getName();
		 Users users = userService.findByUsername(username);
		model.addAttribute("users", users);
		UserProfile userProfile = userProfileService.getUserProfile(users.getId());
		model.addAttribute("userProfile", userProfile);
		return "profile";
	}
	@RequestMapping(value = "/ShowSetting", method = RequestMethod.GET)
	public String ShowSettingUser(Model model, HttpServletRequest request) {
		String username=request.getUserPrincipal().getName();
		 Users users = userService.findByUsername(username);
		model.addAttribute("users", users);
		UsersSetting userSetting = userProfileService.getUserSetting(users.getId());
		model.addAttribute("userSetting", userSetting);
		return "profile";
	}
	@RequestMapping(value = "/ShowChangePassword", method = RequestMethod.GET)
	public String ShowChangePassword(Model model, HttpServletRequest request) {
		String username=request.getUserPrincipal().getName();
		 Users users = userService.findByUsername(username);
		model.addAttribute("users", users);
		return "profile";
	}

	
}
