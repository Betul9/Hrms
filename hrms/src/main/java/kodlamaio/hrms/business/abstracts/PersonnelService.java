package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.Job;
import kodlamaio.hrms.entities.concretes.Personnel;

public interface PersonnelService {
	DataResult<List<Personnel>> getAll();
	Result add(Personnel personnel);
	Result approveEmployer(Employer employer);
	Result approveJob(Job job);
}
