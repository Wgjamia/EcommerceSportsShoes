package ly.algjamia.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fullName;
	private String email;
	private String username;
	private String password;
	private boolean enabled;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "users")
	private UserProfile userProfile;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "users")
	private UsersSetting usersSetting;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "roles_users", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Roles> roles = new HashSet<>();

	@OneToMany(mappedBy = "users")
	private Set<SessionHistory> sessionHistory = new HashSet<>();

	public Set<SessionHistory> getSessionHistory() {
		return sessionHistory;
	}

	public void setSessionHistory(Set<SessionHistory> sessionHistory) {
		this.sessionHistory = sessionHistory;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public void addRoles(Roles roles) {
		this.roles.add(roles);
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public UsersSetting getUsersSetting() {
		return usersSetting;
	}

	public void setUsersSetting(UsersSetting usersSetting) {
		this.usersSetting = usersSetting;
	}

}