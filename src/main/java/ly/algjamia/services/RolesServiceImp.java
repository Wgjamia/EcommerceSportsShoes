package ly.algjamia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ly.algjamia.model.Roles;
import ly.algjamia.repository.RolesRepository;

@Service
public class RolesServiceImp implements RolesService {

	@Autowired
	RolesRepository rolesRepository;

	@Override
	public List<Roles> getAllRoles(String Keyword) {
		if (Keyword != null) {
			return rolesRepository.findAll(Keyword);
		}
			return (List<Roles>) rolesRepository.findAll();
	}

	@Override
	public Roles getRolesById(Long id) {
		Optional<Roles> optional = rolesRepository.findById(id);
		Roles roles = null;
		if (optional.isPresent()) {
			roles = optional.get();
		} else {
			throw new RuntimeException("Roles not found by ID " + id);
		}
		return roles;
	}

	@Override
	public void addRoles(Roles roles) {
		rolesRepository.save(roles);

	}

	@Override
	public void deleteRoles(Long id) {
		rolesRepository.deleteById(id);

	}

	@Override
	public Roles findByRole(String role) {
		return rolesRepository.findByRole(role);
	}

	

}