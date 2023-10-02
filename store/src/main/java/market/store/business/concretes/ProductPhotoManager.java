package market.store.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import market.store.business.abstracts.ProductPhotoService;
import market.store.business.requests.photoRequests.productPhotoRequests.AddProductPhotoRequest;
import market.store.business.responses.photoResponses.productPhotoResponses.GetAllProductPhotoResponse;
import market.store.business.responses.photoResponses.productPhotoResponses.GetProductPhotoResponse;
import market.store.business.rules.ProductPhotoBusinessRules;
import market.store.core.cloudinary.CloudinaryService;
import market.store.core.utitilies.mappers.ModelMapperService;
import market.store.dataAccess.abstracts.ProductPhotoRepository;
import market.store.entities.concretes.photos.ProductPhoto;

@Service
@AllArgsConstructor
public class ProductPhotoManager implements ProductPhotoService {

	private ProductPhotoRepository productPhotoRepository;
	private CloudinaryService cloudinaryService;
	private ModelMapperService modelMapperService;
	private ProductPhotoBusinessRules productPhotoBusinessRules;
	
	
	@Override
	public List<GetAllProductPhotoResponse> getAll() {
		
		List<GetAllProductPhotoResponse> productPhotoResponse = productPhotoRepository.findAll().stream()
				.map(productPhoto -> modelMapperService.forResponse().map(productPhoto, GetAllProductPhotoResponse.class))
				.collect(Collectors.toList());
		
		return productPhotoResponse;
	}


	@Override
	public List<GetProductPhotoResponse> getProductPhotoByProductId(int id) {
		
		List<GetProductPhotoResponse> productPhotoResponse = productPhotoRepository.getProductPhotosByProductId(id)
				.stream().map(productPhoto -> modelMapperService.forResponse().map(productPhoto, GetProductPhotoResponse.class))
				.collect(Collectors.toList());
		
		
		return productPhotoResponse;
	}

	
	
	@Override
	public void add(AddProductPhotoRequest addProductPhotoRequest) {
		
		productPhotoBusinessRules.checkProductPhotoSize(addProductPhotoRequest.getProductId());
		
		ProductPhoto productPhoto = modelMapperService.forRequest().map(addProductPhotoRequest, ProductPhoto.class);
		productPhoto.setId(0);
		
		
		try {
		
			productPhoto.setUrl(cloudinaryService.uploadFile(addProductPhotoRequest.getUrl()));
			
			productPhotoRepository.save(productPhoto);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}


	@Override
	public void deleteProductPhotosByProductId(int id) {
		
		
		
	}


	
}
