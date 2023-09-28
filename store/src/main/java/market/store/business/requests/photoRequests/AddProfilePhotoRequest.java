package market.store.business.requests.photoRequests;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProfilePhotoRequest {

	private MultipartFile photo;
	private int accountId;
	
}
