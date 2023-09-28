package market.store.core.cloudinary;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
	
	
	String uploadFile(MultipartFile multipartFile) throws IOException;

}
