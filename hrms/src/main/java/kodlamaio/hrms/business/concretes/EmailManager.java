package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobseekerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.Jobseeker;


@Service
public class EmailManager implements EmailService{

	private EmployerDao employerDao;
	private JobseekerDao jobseekerDao;
	
	public EmailManager(EmployerDao employerDao, JobseekerDao jobseekerDao) {
		this.employerDao = employerDao;
		this.jobseekerDao = jobseekerDao;
	}
	
	@Override
	public Result emailVerificationForEmployer(String email) {
		List<Employer> employers = employerDao.findAll();
		for(int i=0;i<employers.size();i++) {
			if(employers.get(i).getEmail().equals(email)){
				Employer employer = employers.get(i);
				employer.setVerificationStatus(true);
				return new SuccessResult("Email verification is successfully completed");
			}
		}
		return new ErrorResult("Email verification is not successful");
	}

	@Override
	public Result emailVerificationForJobseeker(String email) {
		List<Jobseeker> jobseekers = jobseekerDao.findAll();
		for(int i=0;i<jobseekers.size();i++) {
			if(jobseekers.get(i).getEmail().equals(email)){
				Jobseeker jobseeker = jobseekers.get(i);
				jobseeker.setVerificationStatus(true);
				return new SuccessResult("Email verification is successfully completed");
			}
		}
		return new ErrorResult("Email verification is not successful");
	}
	
}
