package ly.algjamia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ly.algjamia.model.Roles;
import ly.algjamia.model.Users;
import ly.algjamia.repository.RolesRepository;
import ly.algjamia.repository.UserRepository;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RolesRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(Users users) {
		users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
		users.setEnabled(true);
		Roles userRole = roleRepository.findByRole("SITE_USER");
		users.addRoles(userRole);
		userRepository.save(users);
	}

	@Override
	public void saveAdmin(Users users) {

		if (!users.getPassword().isEmpty()) {
			users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
		} else {
			users.setPassword(userRepository.getPassOfUser(users.getId()));
		}

		users.setEnabled(true);
		for (Roles role : users.getRoles()) {
			users.addRoles(role);
		}

		userRepository.save(users);
	}

	@Override
	public Users findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<Roles> findRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Long getIdBYUserName(String userName) {
		return userRepository.GetIdByUsername(userName);
	}

	@Override
	public List<Users> getAllUsers(String username) {
		if (username != null) {
			return userRepository.findAll(username);
		}
		return (List<Users>) userRepository.findAll();
	}

	@Override
	public Users getUsersById(Long id) {
		return userRepository.getById(id);
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);

	}
}