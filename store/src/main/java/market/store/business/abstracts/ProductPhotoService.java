package market.store.business.abstracts;

import java.util.List;

import market.store.business.requests.photoRequests.productPhotoRequests.AddProductPhotoRequest;
import market.store.business.responses.photoResponses.productPhotoResponses.GetAllProductPhotoResponse;
import market.store.business.responses.photoResponses.productPhotoResponses.GetProductPhotoResponse;

public interface ProductPhotoService {
	
	List<GetAllProductPhotoResponse> getAll();
	List<GetProductPhotoResponse> getProductPhotoByProductId(int id);
	
	void add(AddProductPhotoRequest addProductPhotoRequest);
	void deleteProductPhotosByProductId(int id);

}
