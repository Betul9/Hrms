package kodlamaio.hrms.business.concretes;

import java.time.Year;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.business.abstracts.JobseekerService;
import kodlamaio.hrms.business.abstracts.MernisService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobseekerDao;
import kodlamaio.hrms.entities.concretes.Jobseeker;

@Service
public class JobseekerManager implements JobseekerService{

	private JobseekerDao jobseekerDao;
	private MernisService mernisService;
	private EmailService emailService;
	private UserService userService;
	
	@Autowired
	public JobseekerManager(JobseekerDao jobseekerDao, MernisService mernisService, 
			EmailService emailService, UserService userService) {
		super();
		this.jobseekerDao = jobseekerDao;
		this.mernisService = mernisService;
		this.emailService = emailService;
		this.userService = userService;
	}

	@Override
	public DataResult<List<Jobseeker>> getAll() {
		return new SuccessDataResult<List<Jobseeker>>(this.jobseekerDao.findAll());
	}

	@Override
	public Result add(Jobseeker jobseeker) {
		List<Result> results = new ArrayList<Result>(Arrays.asList(allAreasFilled(jobseeker), 
				checkIfEmailExists(jobseeker.getEmail()),
				checkIfTrNoExists(jobseeker.getTrIdentityNo())));
		for(int i=0; i<results.toArray().length;i++) {
			if(!results.get(i).IsSuccess()) {
				return results.get(i);
			}
		}
		
		if(!this.mernisService.mernisVerification(jobseeker).IsSuccess()) {
			return new ErrorResult("Mernis verification is unsuccessful");
		}
		
		this.emailService.emailVerification(jobseeker.getEmail()).IsSuccess();
		
		this.jobseekerDao.save(jobseeker);
		return new SuccessResult("Mernis and email verification is completed successfully, jobseeker added");
	}
	
	private Result allAreasFilled(Jobseeker jobseeker) {
		if(!jobseeker.getFirstName().trim().equals("") && jobseeker.getFirstName().trim() != null
				&& !jobseeker.getLastName().trim().equals("") && jobseeker.getLastName().trim() != null
				&& Year.now().getValue() - jobseeker.getBirthYear() >= 18 
				&& !jobseeker.getEmail().trim().equals("") && jobseeker.getEmail().trim() != null
				&& jobseeker.getTrIdentityNo() != 0) 
		{
			return new SuccessResult();
		}
		return new ErrorResult("Please fill all areas");
	}
	
	private Result checkIfEmailExists(String email) {
		if(this.userService.getByEmail(email) != null) {
			return new ErrorResult("The email address is taken");
		}

		return new SuccessResult();
	}
	
	private Result checkIfTrNoExists(long trNo) {
		List<Jobseeker> jobseekers = this.jobseekerDao.findAll();
		
		for(int i=0; i<jobseekers.toArray().length; i++) {
			if(trNo == jobseekers.get(i).getTrIdentityNo()) {
				return new ErrorResult("The Tr Identity No is taken");
			}
		}
		return new SuccessResult();
	}
}
