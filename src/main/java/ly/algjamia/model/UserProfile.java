package ly.algjamia.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "user_profiles")
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "dob")
	private String dateOfBirth;
	private String job;
	private String address;
	private String street;
	private String city;
	private String state;
	private String country;
	@Column(name = "zip_code")
	private String zipCode;
	private String pathOfPhoto;
	@Column(name = "twitter_profile")
	private String twitterProfile;
	@Column(name = "facebook_profile")
	private String facebookProfile;
	@Column(name = "instagram_profile")
	private String instagramProfile;
	@Column(name = "linkedin_profile")
	private String linkedinProfile;

	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private Users users;

	public UserProfile() {

	}

	public UserProfile(String phoneNumber, String dateOfBirth, String job, String address, String street, String city,
			String state, String country, String zipCode, String pathOfPhoto) {
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
		this.pathOfPhoto = pathOfPhoto;
		this.job = job;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getTwitterProfile() {
		return twitterProfile;
	}

	public void setTwitterProfile(String twitterProfile) {
		this.twitterProfile = twitterProfile;
	}

	public String getFacebookProfile() {
		return facebookProfile;
	}

	public void setFacebookProfile(String facebookProfile) {
		this.facebookProfile = facebookProfile;
	}

	public String getInstagramProfile() {
		return instagramProfile;
	}

	public void setInstagramProfile(String instagramProfile) {
		this.instagramProfile = instagramProfile;
	}

	public String getLinkedinProfile() {
		return linkedinProfile;
	}

	public void setLinkedinProfile(String linkedinProfile) {
		this.linkedinProfile = linkedinProfile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getPathOfPhoto() {
		return pathOfPhoto;
	}

	public void setPathOfPhoto(String pathOfPhoto) {
		this.pathOfPhoto = pathOfPhoto;
	}
	
	@Transient
	public String getLogoImageOfProfile() {
		if ( this.pathOfPhoto == null ) {
			return "java.jpg";
		}else
			return "/profiles_images/"+id+ "/"+this.pathOfPhoto;
		
	}

}
