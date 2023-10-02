package market.store.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import market.store.business.abstracts.ProductService;
import market.store.business.requests.productRequests.AddProductRequest;
import market.store.business.requests.productRequests.UpdateProductRequest;
import market.store.business.responses.productResponses.GetAllProductResponse;
import market.store.business.responses.productResponses.GetProductResponse;
import market.store.core.utitilies.mappers.ModelMapperService;
import market.store.dataAccess.abstracts.ProductRepository;
import market.store.entities.concretes.Product;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
	
	private ProductRepository productRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllProductResponse> getAll() {
		
		List<GetAllProductResponse> productResponseList = productRepository.findAll().stream().map(product ->
		modelMapperService.forResponse().map(product, GetAllProductResponse.class)).collect(Collectors.toList());
		
		return productResponseList;
	}

	@Override
	public GetProductResponse getProductById(int id) {
		
		Product target = productRepository.findById(id).orElse(null);
		
		if(target != null) {
			
			GetProductResponse productResponse = modelMapperService.forResponse()
					.map(target, GetProductResponse.class);
			
			return productResponse;
			
		}
		
		return null;
	}

	@Override
	public void add(AddProductRequest addProductRequest) {

		Product product = modelMapperService.forRequest().map(addProductRequest, Product.class);
		product.setId(0);
		
		productRepository.save(product);
		

	}

	@Override
	public void update(UpdateProductRequest updateProductRequest) {
		
		Product target = productRepository.findById(updateProductRequest.getId()).orElse(null);
		
		if(target != null) {
			
			target = modelMapperService.forRequest().map(updateProductRequest, Product.class);
			productRepository.save(target);
		}
		

	}

	@Override
	public void delete(int id) {
		
		
		productRepository.deleteById(id);
		

	}

}
