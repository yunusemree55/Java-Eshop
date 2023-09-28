package market.store.core.cloudinary;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CloudinaryManager implements CloudinaryService{

	private Cloudinary cloudinary;

	@Override
	public String uploadFile(MultipartFile multipartFile) throws IOException {
		
		return cloudinary.uploader().upload(multipartFile.getBytes(), null).get("url").toString();
	}
	
	
}
