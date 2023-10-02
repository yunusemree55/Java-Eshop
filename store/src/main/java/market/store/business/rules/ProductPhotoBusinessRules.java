package market.store.business.rules;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import market.store.business.responses.photoResponses.productPhotoResponses.GetAllProductPhotoResponse;
import market.store.core.utitilies.exceptions.BusinessException;
import market.store.core.utitilies.mappers.ModelMapperService;
import market.store.dataAccess.abstracts.ProductPhotoRepository;

@Service
@AllArgsConstructor
public class ProductPhotoBusinessRules {

	private ProductPhotoRepository productPhotoRepository;
	private ModelMapperService modelMapperService;
	
	public void checkProductPhotoSize(int productId) {
		
		List<GetAllProductPhotoResponse> productPhotoResponse = productPhotoRepository.getProductPhotosByProductId(productId).stream()
				.map(productPhoto -> modelMapperService.forResponse()
				.map(productPhoto, GetAllProductPhotoResponse.class)).collect(Collectors.toList());
		
		
		
		if(productPhotoResponse.size() >= 5) {
			
			throw new BusinessException("İlgili ürüne en fazla 5 fotoğraf eklenilebilir");
			
		}
		
	}
	
}
