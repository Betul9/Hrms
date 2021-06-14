package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;
import kodlamaio.hrms.entities.concretes.Image;

@RestController
@RequestMapping("/api/images")
public class ImagesController {

	ImageService imageService;

	public ImagesController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Image>> getall() {
		return this.imageService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Image image, MultipartFile imageFile) {
		return this.imageService.add(image, imageFile);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody Image image) {
		return this.imageService.delete(image);
	}
}
