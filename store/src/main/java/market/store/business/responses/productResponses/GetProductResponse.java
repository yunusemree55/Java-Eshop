package market.store.business.responses.productResponses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import market.store.business.responses.photoResponses.productPhotoResponses.GetProductPhotoResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductResponse {

	private int id;
	private String name;
	private String categoryName;
	private String companyName;
	private double unitPrice;
	private int unitsInStock;
	private List<GetProductPhotoResponse> productPhotos;
	
	
}
