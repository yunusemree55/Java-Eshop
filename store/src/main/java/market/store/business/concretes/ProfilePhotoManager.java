package market.store.business.concretes;

import java.io.IOException;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import market.store.business.abstracts.ProfilePhotoService;
import market.store.business.requests.photoRequests.AddProfilePhotoRequest;
import market.store.core.cloudinary.CloudinaryService;
import market.store.core.utitilies.mappers.ModelMapperService;
import market.store.dataAccess.abstracts.ProfilePhotoRepository;
import market.store.entities.concretes.ProfilePhoto;

@Service
@AllArgsConstructor
public class ProfilePhotoManager implements ProfilePhotoService {

	private ProfilePhotoRepository photoRepository;
	private ModelMapperService modelMapperService;
	private CloudinaryService cloudinaryService;
	
	@Override
	public void add(AddProfilePhotoRequest addProfilePhotoRequest) {
	
		ProfilePhoto photo = modelMapperService.forRequest().map(addProfilePhotoRequest, ProfilePhoto.class);
		photo.setId(0);
		
		try {
			
			photo.setUrl(cloudinaryService.uploadFile(addProfilePhotoRequest.getPhoto()));
			
			
			photoRepository.save(photo);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
