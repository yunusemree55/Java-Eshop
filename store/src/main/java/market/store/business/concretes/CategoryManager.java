package market.store.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import market.store.business.abstracts.CategoryService;
import market.store.business.requests.categoryRequests.AddCategoryRequest;
import market.store.business.responses.categoryResponses.GetAllCategoryResponse;
import market.store.business.responses.categoryResponses.GetCategoryResponse;
import market.store.core.utitilies.mappers.ModelMapperService;
import market.store.dataAccess.abstracts.CategoryRepository;
import market.store.entities.concretes.Category;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
	
	private CategoryRepository categoryRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllCategoryResponse> getAll() {
		
		List<GetAllCategoryResponse> categoryResponse = categoryRepository.findAll().stream().map(category ->
		modelMapperService.forResponse().map(category, GetAllCategoryResponse.class)).collect(Collectors.toList());
		
		return categoryResponse;
	}

	@Override
	public GetCategoryResponse getCategoryById(int id) {
		
		Category target = categoryRepository.findById(id).orElse(null);
	
		if(target != null) {
			
			GetCategoryResponse categoryResponse = modelMapperService.forResponse().map(target, GetCategoryResponse.class);
			return categoryResponse;
		}
		
		return null;
	}

	@Override
	public void add(AddCategoryRequest addCategoryRequest) {

		Category category = modelMapperService.forRequest().map(addCategoryRequest, Category.class);
		
		categoryRepository.save(category);

	}

	@Override
	public void delete(int id) {
		
		categoryRepository.deleteById(id);

	}

}
