package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="jobseekers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id", referencedColumnName = "id")
@Inheritance(strategy = InheritanceType.JOINED)
public class Jobseeker extends User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
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
	
	@Column(name="verification_status")
	private boolean verificationStatus;	
	
	@Column(name="covering_letter")
	private String coveringLetter;
	
	@Column(name="github_link")
	private String githubLink;
	
	@Column(name="linkedin_link")
	private String linkedinLink;
	
	@Column(name="abilities")
	private String abilities;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobseeker")
	private List<Image> images;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobseeker")
	private List<ForeignLanguage> foreignLanguages;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobseeker")
	private List<GradSchool> gradSchools;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobseeker")
	private List<JobExperience> jobExperiences;
}
