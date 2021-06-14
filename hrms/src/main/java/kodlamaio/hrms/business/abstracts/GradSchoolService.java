package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.GradSchool;

public interface GradSchoolService {
	Result add(GradSchool gradSchool);
	Result delete(GradSchool gradSchool);
	DataResult<List<GradSchool>> getAll();
}
