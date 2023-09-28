package market.store.business.abstracts;

import market.store.business.requests.photoRequests.AddProfilePhotoRequest;

public interface ProfilePhotoService {

	void add(AddProfilePhotoRequest addPhotoRequest);
	
}
