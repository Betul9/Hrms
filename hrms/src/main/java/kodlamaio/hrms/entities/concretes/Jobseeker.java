package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="jobseekers")
public class Jobseeker {
	@Id
	@GeneratedValue
	
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@Column(name="tr_identity_no")
	private long trIdentityNo;
	
	@Column(name="birth_year")
	private int birthYear;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="verification_status")
	private boolean verificationStatus;
	
	public Jobseeker() {}

	public Jobseeker(int id, String firstName, String lastName, long trIdentityNo, int birthYear, String email,
			String password, boolean verificationStatus) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.trIdentityNo = trIdentityNo;
		this.birthYear = birthYear;
		this.email = email;
		this.password = password;
		this.verificationStatus = verificationStatus;
	}

	
}
