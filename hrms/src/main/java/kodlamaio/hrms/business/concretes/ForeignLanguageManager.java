package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ForeignLanguageDao;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;

@Service
public class ForeignLanguageManager implements ForeignLanguageService{

	private ForeignLanguageDao foreignLanguageDao;

	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
		super();
		this.foreignLanguageDao = foreignLanguageDao;
	}

	@Override
	public Result add(ForeignLanguage foreignLanguage) {
		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("Foreign language added");
	}

	@Override
	public Result delete(ForeignLanguage foreignLanguage) {
		this.foreignLanguageDao.delete(foreignLanguage);
		return new SuccessResult("Foreign language deleted");
	}

	@Override
	public DataResult<List<ForeignLanguage>> getAll() {
		return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.findAll());
	}
}
