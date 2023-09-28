package market.store.business.abstracts;

import java.util.List;

import market.store.business.requests.customerRequests.AddCustomerRequest;
import market.store.business.requests.customerRequests.UpdateCustomerRequest;
import market.store.business.responses.customerResponses.GetAllCustomerResponse;
import market.store.business.responses.customerResponses.GetCustomerResponse;

public interface CustomerService {

	List<GetAllCustomerResponse> getAll();
	GetCustomerResponse getCustomerById(int id);
	void add(AddCustomerRequest addCustomerRequest);
	void update(UpdateCustomerRequest updateCustomerRequest);
	void delete(int id);
	
}
