package ly.algjamia.services;

import org.springframework.data.repository.query.Param;

import ly.algjamia.model.UserProfile;
import ly.algjamia.model.Users;
import ly.algjamia.model.UsersSetting;

public interface UserProfileService {

	public UserProfile getUserProfile(Long user_id);
	
	public Users getUsers(Long user_id);
	
	public void addUserProfile(UserProfile userProfile);
	
	public void addUsers(Users users);

	public UsersSetting getUserSetting(Long user_id);
	
	public void addUserSetting(UsersSetting userSetting);
	



}
