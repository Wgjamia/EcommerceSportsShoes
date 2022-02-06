package ly.algjamia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ly.algjamia.model.UserProfile;
import ly.algjamia.model.Users;
import ly.algjamia.model.UsersSetting;
import ly.algjamia.repository.UserProfileRepository;
import ly.algjamia.repository.UserRepository;
import ly.algjamia.repository.UsersSettingRepository;

@Service
public class UserProfileServicImpl implements UserProfileService {

	@Autowired
	UserProfileRepository userProfileRepository;
	
	@Autowired
	UsersSettingRepository usersSettingRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public UserProfile getUserProfile(Long user_id) {
		return userProfileRepository.getUserProfile(user_id);
	}

	@Override
	public Users getUsers(Long user_id) {
		return userProfileRepository.getUsers(user_id);
	}

	@Override
	public void addUserProfile(UserProfile userProfile) {
			userProfileRepository.save(userProfile);
	}

	@Override
	public UsersSetting getUserSetting(Long user_id) {
		return usersSettingRepository.getUserSetting(user_id);
	}

	@Override
	public void addUserSetting(UsersSetting userSetting) {
		usersSettingRepository.save(userSetting);
		
	}

	@Override
	public void addUsers(Users users) {
		userRepository.save(users);
		
	}

	

	
}
