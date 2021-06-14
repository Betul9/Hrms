package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;

public interface ImageService {
	Result add(Image image, MultipartFile imageFile);
	Result delete(Image image);
	DataResult<List<Image>> getAll();
	DataResult<Image> getById(int imageId);
}
