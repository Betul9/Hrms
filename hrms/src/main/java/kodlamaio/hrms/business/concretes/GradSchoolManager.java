package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.GradSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.GradSchoolDao;
import kodlamaio.hrms.entities.concretes.GradSchool;

@Service
public class GradSchoolManager implements GradSchoolService{

	private GradSchoolDao gradSchoolDao;
	
	@Override
	public Result add(GradSchool gradSchool) {
		this.gradSchoolDao.save(gradSchool);
		return new SuccessResult("graduated school added");
	}

	@Override
	public Result delete(GradSchool gradSchool) {
		this.gradSchoolDao.delete(gradSchool);
		return new SuccessResult("graduated school deleted");
	}

	@Override
	public DataResult<List<GradSchool>> getAll() {
		return new SuccessDataResult<List<GradSchool>>(this.gradSchoolDao.findAll());
	}

	public GradSchoolManager(GradSchoolDao gradSchoolDao) {
		super();
		this.gradSchoolDao = gradSchoolDao;
	}

}
