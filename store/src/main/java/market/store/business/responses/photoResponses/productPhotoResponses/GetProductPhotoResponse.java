package market.store.business.responses.photoResponses.productPhotoResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductPhotoResponse {

	private int id;
	private int productId;
	private String url;
	
}
