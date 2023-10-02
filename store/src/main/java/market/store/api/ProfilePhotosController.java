package market.store.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import market.store.business.abstracts.ProfilePhotoService;
import market.store.business.requests.photoRequests.profilePhotoRequests.AddProfilePhotoRequest;

@RestController
@RequestMapping("/api/profilephotos")
@AllArgsConstructor
public class ProfilePhotosController {

	private ProfilePhotoService profilePhotoService;
	
	
	@PostMapping("/add")
	public void add(AddProfilePhotoRequest addProfilePhotoRequest) {
		
		profilePhotoService.add(addProfilePhotoRequest);
	}
	
}
