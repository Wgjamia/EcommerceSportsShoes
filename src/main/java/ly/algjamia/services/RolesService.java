package ly.algjamia.services;

import java.util.List;

import ly.algjamia.model.Roles;

public interface RolesService {
	public List<Roles> getAllRoles(String Keyword);

	public Roles getRolesById(Long id);
	
	public void addRoles(Roles roles);
	
	public void deleteRoles(Long id);
	
	public Roles findByRole(String role);

}
