package market.store.business.abstracts;

import java.util.List;

import market.store.business.requests.productRequests.AddProductRequest;
import market.store.business.requests.productRequests.UpdateProductRequest;
import market.store.business.responses.productResponses.GetAllProductResponse;
import market.store.business.responses.productResponses.GetProductResponse;

public interface ProductService {
	
	List<GetAllProductResponse> getAll();
	GetProductResponse getProductById(int id);
	void add(AddProductRequest addProductRequest);
	void update(UpdateProductRequest updateProductRequest);
	void delete(int id);

}
