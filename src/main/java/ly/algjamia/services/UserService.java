package ly.algjamia.services;

import java.util.List;

import ly.algjamia.model.Roles;
import ly.algjamia.model.Users;

public interface UserService {
	
	public Users getUsersById(Long id);
   
	public List<Users> getAllUsers(String username);
	
	public void save(Users users);

	public Users findByUsername(String username);
    
    public List<Roles> findRoles();
    
    public Long getIdBYUserName(String userName);
    
    public void delete(Long id);

	void saveAdmin(Users users);
	
	
}