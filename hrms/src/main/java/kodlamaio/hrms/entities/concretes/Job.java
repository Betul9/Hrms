package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="jobs")
@AllArgsConstructor
@NoArgsConstructor
public class Job{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name="job_name")
	private String jobName;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="city")
	private String city;
	
	@Column(name="min_salary")
	private Integer minSalary;
	
	@Column(name="max_salary")
	private Integer maxSalary;
	
	@Column(name="employee_number")
	private int employeeNumber;
	
	@Column(name="last_appeal_date")
	private Date lastAppeal;
	
	@Column(name="job_status")
	private boolean jobStatus;
	
	@ManyToOne()
	@JoinColumn(name="owner_id")
	private Employer employer;
}
