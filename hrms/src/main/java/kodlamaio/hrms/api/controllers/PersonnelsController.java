package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.PersonnelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.Personnel;

@RestController
@RequestMapping("/api/personnels")
@CrossOrigin
public class PersonnelsController {
	
	private PersonnelService personnelService;
	
	@Autowired
	public PersonnelsController(PersonnelService personnelService) {
		super();
		this.personnelService = personnelService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Personnel>> getAll(){
		return this.personnelService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Personnel personnel) {
		return this.personnelService.add(personnel);
	}
	
	@PostMapping("/approveemployer")
	public Result approveEmployer(@RequestBody Employer employer) {
		return this.personnelService.approveEmployer(employer);
	}
}
