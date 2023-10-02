package market.store.business.abstracts;

import market.store.business.requests.photoRequests.profilePhotoRequests.AddProfilePhotoRequest;

public interface ProfilePhotoService {

	void add(AddProfilePhotoRequest addPhotoRequest);
	
}
