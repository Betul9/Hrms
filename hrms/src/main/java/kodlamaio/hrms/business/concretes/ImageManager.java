package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.business.abstracts.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Image;

@Service
public class ImageManager implements ImageService{

	private ImageDao imageDao;
	private CloudinaryService cloudinaryService;
	
	public ImageManager(ImageDao imageDao, CloudinaryService cloudinaryService) {
		super();
		this.imageDao = imageDao;
		this.cloudinaryService = cloudinaryService;
	}
	
	@Override
	public Result add(Image image, MultipartFile imageFile) {
		 @SuppressWarnings("unchecked")
	     Map<String, String> uploadPhoto = this.cloudinaryService.uploadImageFile(imageFile);

	     image.setImageUrl(uploadPhoto.get("url"));
	     this.imageDao.save(image);
	     return new SuccessResult("Image Added");
	}

	@Override
	public Result delete(Image image) {
		this.imageDao.delete(image);
		return new SuccessResult("Image deleted");
	}

	@Override
	public DataResult<Image> getById(int imageId) {
		return new SuccessDataResult<Image>(this.imageDao.findById(imageId));
	}

	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll());
	}
}
