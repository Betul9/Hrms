package kodlamaio.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="grad_schools")
@AllArgsConstructor
@NoArgsConstructor
public class GradSchool {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="jobseeker_id")
	private Jobseeker jobseeker;
	
	@Column(name="uni_name")
	private String uniName;
	
	@Column(name="department")
	private String department;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="grad_date")
	private Date gradDate;
}
