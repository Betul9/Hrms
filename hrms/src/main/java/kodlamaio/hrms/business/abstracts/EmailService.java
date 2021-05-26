package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface EmailService {
	public Result emailVerificationForEmployer(String email);
	public Result emailVerificationForJobseeker(String email);
}
