package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private EmailService emailService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailService emailService) {
		super();
		this.employerDao = employerDao;
		this.emailService = emailService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}
	
	@Override
	public Result add(Employer employer) {
		List<Result> results = new ArrayList<Result>(Arrays.asList(allAreasFilled(employer), 
				checkIfEmailExists(employer.getEmail()),
				checkDomain(employer.getEmail(), employer.getWebsite())));
		
		for(int i=0; i<results.size();i++) {
			if(!results.get(i).IsSuccess()) {
				return results.get(i);
			}
		}
		
		employer.setVerificationStatus(false);
		this.employerDao.save(employer);
		return new SuccessResult("Employer added, plese verify your email");
	}
	
	private Result checkDomain(String email, String website) {
		if(website.indexOf('.') != -1) {
			String domain = website.substring(website.indexOf('.')+1);
			if(email.endsWith(domain)) {
				return new SuccessResult();
			}
		}
		return new ErrorResult("The website and the email address should have the same domain.");
	}
	
	private Result allAreasFilled(Employer employer) {
		if(!employer.getCompanyName().trim().equals("") && employer.getCompanyName().trim() != null
				&& !employer.getEmail().trim().equals("") && employer.getEmail().trim() != null
				&& employer.getPhoneNumber() != 0
				&& !employer.getWebsite().trim().equals("") && employer.getWebsite().trim() != null
				) {
			return new SuccessResult();
		}
		return new ErrorResult("All areas should be filled");
	}
	
	private Result checkIfEmailExists(String email) {
		List<Employer> employers = this.employerDao.findAll();
		for(int i=0;i<employers.size();i++) {
			if(employers.get(i).getEmail().equals(email)) {
				return new ErrorResult("The email address is already taken");
			}
		}
		
		return new SuccessResult();
	}
}
