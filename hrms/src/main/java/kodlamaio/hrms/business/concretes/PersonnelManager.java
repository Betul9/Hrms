package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.PersonnelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PersonnelDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.concretes.Personnel;

@Service
public class PersonnelManager implements PersonnelService{

	private PersonnelDao personnelDao;
	private EmployerService employerService;
	
	@Autowired
	public PersonnelManager(PersonnelDao personnelDao, EmployerService employerService) {
		super();
		this.personnelDao = personnelDao;
		this.employerService = employerService;
	}

	@Override
	public DataResult<List<Personnel>> getAll() {
		return new SuccessDataResult<List<Personnel>>(this.personnelDao.findAll());
	}

	public Result approveEmployer(Employer employer) {
		employer.setAdminApproval(true);
		this.employerService.update(employer);
		return new SuccessResult("admin approval is completed, employer status is active");
	}

	@Override
	public Result add(Personnel personnel) {
		this.personnelDao.save(personnel);
		return new SuccessResult("personnel added");
	}
}
