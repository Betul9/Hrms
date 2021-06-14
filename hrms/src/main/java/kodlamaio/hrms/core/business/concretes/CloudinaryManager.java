package kodlamaio.hrms.core.business.concretes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.business.abstracts.CloudinaryService;


@Service
public class CloudinaryManager implements CloudinaryService{

	Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryManager() {
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name","dyipksepm",
				"api_key", "375969418915715",
				"api_secret","PmEo8xMCOoNReaWyr6XYnd6y-SM"));
		this.cloudinary = cloudinary;
	}

	@Override
	public Map uploadImageFile(MultipartFile imageFile) {
		try {
            @SuppressWarnings("unchecked")
            Map<String, String> resultMap = (Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
            return resultMap;
        } catch (IOException e){
            e.printStackTrace();
        }

        return null;
	}

}
