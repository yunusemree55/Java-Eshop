package market.store.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import market.store.business.abstracts.CategoryService;
import market.store.business.requests.categoryRequests.AddCategoryRequest;
import market.store.business.responses.categoryResponses.GetAllCategoryResponse;
import market.store.business.responses.categoryResponses.GetCategoryResponse;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoriesController {
	
	private CategoryService categoryService;
	
	@GetMapping("/getall")
	public List<GetAllCategoryResponse> getAll(){
		
		return categoryService.getAll();
	}
	
	@GetMapping("/getcategorybyid/{id}")
	public GetCategoryResponse getCategoryById(@PathVariable int id) {
		
		return categoryService.getCategoryById(id);
	}
	
	@PostMapping("/add")
	public void add(@RequestBody AddCategoryRequest addCategoryRequest) {
		
		categoryService.add(addCategoryRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		
		categoryService.delete(id);
	}

}
