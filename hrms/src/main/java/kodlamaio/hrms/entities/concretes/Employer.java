package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employers")
public class Employer {
	
	@Id
	@GeneratedValue
	
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="website")
	private String website;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="phone_number")
	private long phoneNumber;
	
	@Column(name="verification_status")
	private boolean verificationStatus;
	
	@Column(name="admin_approval")
	private boolean adminApproval;
	
	public Employer() {}

	public Employer(int id, String companyName, String website, String email, String password,
			long phoneNumber, boolean verificationStatus, boolean adminApproval) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.website = website;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.verificationStatus = verificationStatus;
		this.adminApproval = adminApproval;
	}
	
	
}
