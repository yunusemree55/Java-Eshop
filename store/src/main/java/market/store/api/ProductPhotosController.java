package market.store.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import market.store.business.abstracts.ProductPhotoService;
import market.store.business.requests.photoRequests.productPhotoRequests.AddProductPhotoRequest;
import market.store.business.responses.photoResponses.productPhotoResponses.GetAllProductPhotoResponse;
import market.store.business.responses.photoResponses.productPhotoResponses.GetProductPhotoResponse;

@RestController
@RequestMapping("/api/productphotos")
@AllArgsConstructor
public class ProductPhotosController {

	private ProductPhotoService productPhotoService;
	
	@GetMapping("/getall")
	public List<GetAllProductPhotoResponse> getAll(){
		
		return productPhotoService.getAll();
	}
	
	@GetMapping("/getproductphotosbyid/{id}")
	public List<GetProductPhotoResponse> getProductPhotoByProductId(@PathVariable int id){
		
		return productPhotoService.getProductPhotoByProductId(id);
	}
	
	@PostMapping("/add")
	public void add(AddProductPhotoRequest addProductPhotoRequest) {
		
		productPhotoService.add(addProductPhotoRequest);
	}
	
}
