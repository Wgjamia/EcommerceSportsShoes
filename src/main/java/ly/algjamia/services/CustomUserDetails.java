package ly.algjamia.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ly.algjamia.model.Roles;
import ly.algjamia.model.UserProfile;
import ly.algjamia.model.Users;

public class CustomUserDetails implements UserDetails {

	
	private static final long serialVersionUID = 1L;
	private Users users;
	private UserProfile userProfile;
	
	
	public CustomUserDetails(Users users, UserProfile userProfile) {
		this.users = users;
		this.userProfile =userProfile;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Roles> roles = users.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (Roles role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return users.getPassword();
	}

	@Override
	public String getUsername() {
		return users.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return users.isEnabled();
	}
	
	public Long getId() {
        return this.users.getId();
    }
	
	public String getFullName() {
        return this.users.getFullName();
    }
	
	public String getEmail() {
        return this.users.getEmail();
    }
	
	public String getJob() {
        return this.userProfile.getJob();
    }

	
	public String getPathOfPhoto() {
        return this.userProfile.getPathOfPhoto();
    }

}
