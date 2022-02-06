package ly.algjamia.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.bridge.ISourceLocation;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	UserService userService;
	

	@RequestMapping(value = "/OverViewUser", method = RequestMethod.GET)
	public String OverViewUser(Model model, HttpServletRequest request) {
		String username=request.getUserPrincipal().getName();
		 Users users = userService.findByUsername(username);
		model.addAttribute("users", users);
		UserProfile userProfile = userProfileService.getUserProfile(users.getUserProfile().getId());
		model.addAttribute("userProfile", userProfile);
		//System.out.print("USER Session ID Controller ==>>> : "+userProfile.getId());
		UsersSetting usersSetting = userProfileService.getUserSetting(users.getUsersSetting().getId());
		model.addAttribute("usersSetting", usersSetting);
		return "profile";
	}

	@RequestMapping(value = "/ShowProfile", method = RequestMethod.GET)
	public String ShowProfileUser(Model model, HttpServletRequest request) {
		String username=request.getUserPrincipal().getName();
		 Users users = userService.findByUsername(username);
		model.addAttribute("users", users);
		UserProfile userProfile = userProfileService.getUserProfile(users.getUserProfile().getId());
		model.addAttribute("userProfile", userProfile);
		return "profile";
	}
	
	@RequestMapping(value = "/updateUserProfile", method = RequestMethod.POST)
	public String updateUserProfile(@RequestParam("profileimage") MultipartFile multipartFile
			,@ModelAttribute("userProfile") UserProfile userProfile
			,@ModelAttribute("users") Users users) throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	    userProfile.setPathOfPhoto(fileName);
	    userProfile.setUsers(users);
	    userService.UdateUsersFullNameAndEmail(users.getFullName(), users.getEmail(), users.getId());
		userProfileService.addUserProfile(userProfile);
		String uploadDir = "./profiles_images/" + userProfile.getId();
		Path uploadpath = Paths.get(uploadDir);
		if(!Files.exists(uploadpath)) {
			Files.createDirectories(uploadpath);
		}
		try(InputStream inputStream = multipartFile.getInputStream()){
			Path filePath = uploadpath.resolve(fileName);
			Files.copy(inputStream, filePath,StandardCopyOption.REPLACE_EXISTING);
		}catch (IOException e) {
			throw new IOException("Could not save uploaded file "+fileName);
		}
	
		return "redirect:/userProfile/OverViewUser";
	}
	
	@RequestMapping(value = "/ShowSetting", method = RequestMethod.GET)
	public String ShowSetting(Model model, HttpServletRequest request) {
		String username=request.getUserPrincipal().getName();
		 Users users = userService.findByUsername(username);
		model.addAttribute("users", users);
		UsersSetting usersSetting = userProfileService.getUserSetting(users.getUsersSetting().getId());
		model.addAttribute("usersSetting", usersSetting);
		return "profile";
	}
	
	@RequestMapping(value = "/updateUserSetting", method = RequestMethod.POST)
	public String updateUserSetting(@ModelAttribute("usersSetting") UsersSetting usersSetting
			,@ModelAttribute("users") Users users) throws IOException {
		usersSetting.setUsers(users);
		userProfileService.addUserSetting(usersSetting);
		return "redirect:/userProfile/OverViewUser";
	}

	@RequestMapping(value = "/ChangePassword", method = RequestMethod.POST)
	public String ChangePassword(@RequestParam("currentPassword") String oldPassword
			,@RequestParam("newPassword") String newPassword
			,Principal paPrincipal,HttpSession session
			) {
		String Username = paPrincipal.getName();
		Users users = userService.findByUsername(Username);
		if (bCryptPasswordEncoder.matches( oldPassword,users.getPassword())) {
			users.setPassword(newPassword);
			userService.save(users);
			session.setAttribute("message", new Message("Your Password has ben changed..", null, false));
		}else
		{
			session.setAttribute("message", new Message("Please Enter correct Old Password !!", null, false));
			return "redirect:/userProfile/OverViewUser";
		}
		return "profile";
	}

	
}
