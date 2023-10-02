package market.store.business.requests.photoRequests.productPhotoRequests;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductPhotoRequest {
	
	private MultipartFile url;
	private int productId;

}
