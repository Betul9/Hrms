package kodlamaio.hrms.core.business.abstracts;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
	Map uploadImageFile(MultipartFile imageFile);
}
