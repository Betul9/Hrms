package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Jobseeker;

public interface MernisService {
	Result mernisVerification(Jobseeker jobseeker);
}
