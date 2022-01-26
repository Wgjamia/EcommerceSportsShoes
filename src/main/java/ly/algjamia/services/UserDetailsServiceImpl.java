package ly.algjamia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ly.algjamia.model.UserProfile;
import ly.algjamia.model.Users;
import ly.algjamia.repository.UserProfileRepository;
import ly.algjamia.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private UserProfileRepository userProfileRepository;
	
	@Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        Users users = userRepository.findByUsername(username);
        UserProfile userProfile = userProfileRepository.getUserProfile(users.getId());
        return new CustomUserDetails(users,userProfile);
    }
    
   
    
}