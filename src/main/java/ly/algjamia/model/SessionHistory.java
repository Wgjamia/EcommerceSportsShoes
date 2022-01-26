package ly.algjamia.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "session_history")
public class SessionHistory {
	@Id
	@GeneratedValue
	private Long id;
	private String sessionId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private Users users;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_login")
	private Date DateOfLogin;

	@Temporal(TemporalType.TIME)
	@Column(name = "time_of_login")
	private Date TimeOfLogin;

	@Column(name = "tools_of_login")
	private String ToolsOfLogin;

	@Column(name = "device_of_login")
	private String DeviceOfLogin;
	@Column(name = "ip_of_login")
	private String IPOfLogin;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_of_date")
	private Date EndOfSession;

	public SessionHistory() {
		super();
	}

	public SessionHistory(Long id, String sessionId, Users users, Date dateOfLogin, Date timeOfLogin,
			String toolsOfLogin, String deviceOfLogin, String iPOfLogin, Date endOfSession) {
		super();
		this.id = id;
		this.sessionId = sessionId;
		this.users = users;
		DateOfLogin = dateOfLogin;
		TimeOfLogin = timeOfLogin;
		ToolsOfLogin = toolsOfLogin;
		DeviceOfLogin = deviceOfLogin;
		IPOfLogin = iPOfLogin;
		EndOfSession = endOfSession;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Date getDateOfLogin() {
		return DateOfLogin;
	}

	public void setDateOfLogin(Date dateOfLogin) {
		DateOfLogin = dateOfLogin;
	}

	public Date getTimeOfLogin() {
		return TimeOfLogin;
	}

	public void setTimeOfLogin(Date timeOfLogin) {
		TimeOfLogin = timeOfLogin;
	}

	public String getToolsOfLogin() {
		return ToolsOfLogin;
	}

	public void setToolsOfLogin(String toolsOfLogin) {
		ToolsOfLogin = toolsOfLogin;
	}

	public String getDeviceOfLogin() {
		return DeviceOfLogin;
	}

	public void setDeviceOfLogin(String deviceOfLogin) {
		DeviceOfLogin = deviceOfLogin;
	}

	public String getIPOfLogin() {
		return IPOfLogin;
	}

	public void setIPOfLogin(String iPOfLogin) {
		IPOfLogin = iPOfLogin;
	}

	public Date getEndOfSession() {
		return EndOfSession;
	}

	public void setEndOfSession(Date endOfSession) {
		EndOfSession = endOfSession;
	}

}
