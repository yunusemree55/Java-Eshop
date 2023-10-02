package market.store.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import market.store.business.abstracts.ProductService;
import market.store.business.requests.productRequests.AddProductRequest;
import market.store.business.requests.productRequests.UpdateProductRequest;
import market.store.business.responses.productResponses.GetAllProductResponse;
import market.store.business.responses.productResponses.GetProductResponse;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsController {
	
	private ProductService productService;
	
	
	@GetMapping("/getall")
	public List<GetAllProductResponse> getAll(){
		
		return productService.getAll();
	}
	
	@GetMapping("/getproductbyid/{id}")
	public GetProductResponse getProductById(@PathVariable int id) {
		
		return productService.getProductById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid AddProductRequest addProductRequest) {
		
		productService.add(addProductRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdateProductRequest updateProductRequest) {
		
		productService.update(updateProductRequest);
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable int id) {
		
		productService.delete(id);
	}

}
