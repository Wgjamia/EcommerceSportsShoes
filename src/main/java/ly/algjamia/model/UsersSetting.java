package ly.algjamia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_setting")
public class UsersSetting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "changes_made")
	private boolean changesMade = false;
	@Column(name = "info_products")
	private boolean infoProducts = false;
	@Column(name = "marketing_offers")
	private boolean marketingOffers = false;
	@Column(name = "security_alerts")
	private boolean securityAlerts = true;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private Users users;

	public UsersSetting(Long id, boolean changesMade, boolean infoProducts, boolean marketingOffers,
			boolean securityAlerts, Users users) {
		super();
		this.id = id;

		this.changesMade = changesMade;
		this.infoProducts = infoProducts;
		this.marketingOffers = marketingOffers;
		this.securityAlerts = securityAlerts;
		this.users = users;
	}

	public UsersSetting() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isChangesMade() {
		return changesMade;
	}

	public void setChangesMade(boolean changesMade) {
		this.changesMade = changesMade;
	}

	public boolean isInfoProducts() {
		return infoProducts;
	}

	public void setInfoProducts(boolean infoProducts) {
		this.infoProducts = infoProducts;
	}

	public boolean isMarketingOffers() {
		return marketingOffers;
	}

	public void setMarketingOffers(boolean marketingOffers) {
		this.marketingOffers = marketingOffers;
	}

	public boolean isSecurityAlerts() {
		return securityAlerts;
	}

	public void setSecurityAlerts(boolean securityAlerts) {
		this.securityAlerts = securityAlerts;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
