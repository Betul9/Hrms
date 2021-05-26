package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.MernisService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Jobseeker;

@Service
public class MernisManager implements MernisService{

	@Override
	public Result mernisVerification(Jobseeker jobseeker) {
		return new SuccessResult("Mernis verification is successfully completed");
	}

}
