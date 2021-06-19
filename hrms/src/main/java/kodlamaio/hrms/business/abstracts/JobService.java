package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Job;

public interface JobService {
	DataResult<List<Job>> getAll();
	Result add(Job job);
	Result update(Job job);
	DataResult<Job> getById(int id);
	DataResult<List<Job>> getByJobStatusTrue();
	DataResult<List<Job>> getByJobStatusFalse();
}
