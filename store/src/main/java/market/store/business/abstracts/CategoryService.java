package market.store.business.abstracts;

import java.util.List;

import market.store.business.requests.categoryRequests.AddCategoryRequest;
import market.store.business.responses.categoryResponses.GetAllCategoryResponse;
import market.store.business.responses.categoryResponses.GetCategoryResponse;

public interface CategoryService {
	
	List<GetAllCategoryResponse> getAll();
	GetCategoryResponse getCategoryById(int id);
	
	void add(AddCategoryRequest addCategoryRequest);
	void delete(int id);

}
