package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService{

	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll());
	}
	
	@Override
	public DataResult<Job> getById(int id) {
		return new SuccessDataResult<Job>(this.jobDao.findById(id).orElse(null));
	}
	
	@Override
	public Result add(Job job) {
		boolean result = jobExists(job);
		if(!result) {
			return new ErrorResult("Job already exists");
		}
		else {
			this.jobDao.save(job);
			return new SuccessResult("Job is added");
		}
	}

	@Override
	public Result update(Job job) {
		this.jobDao.save(job);
		return new SuccessResult("Job updated");
	}

	public boolean jobExists(Job job) {
		List<Job> jobs = this.jobDao.findAll();
		for(int i=0; i<jobs.size();i++) {
			String jobName=jobs.get(i).getJobName().toLowerCase(Locale.ROOT);
			if(job.getJobName().toLowerCase(Locale.ROOT).equals(jobName)) {
				return false;
			}
		}
		return true;
	}
}
