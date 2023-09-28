package market.store.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import market.store.business.abstracts.CustomerService;
import market.store.business.requests.customerRequests.AddCustomerRequest;
import market.store.business.requests.customerRequests.UpdateCustomerRequest;
import market.store.business.responses.customerResponses.GetAllCustomerResponse;
import market.store.business.responses.customerResponses.GetCustomerResponse;
import market.store.core.utitilies.mappers.ModelMapperService;
import market.store.dataAccess.abstracts.CustomerRepository;
import market.store.entities.concretes.Customer;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
	
	private CustomerRepository customerRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllCustomerResponse> getAll() {
		
		List<GetAllCustomerResponse> customerResponseList = customerRepository.findAll().stream()
				.map(customer -> modelMapperService.forResponse().map(customer, GetAllCustomerResponse.class))
				.collect(Collectors.toList());
		
		return customerResponseList;
	}
	
	
	@Override
	public GetCustomerResponse getCustomerById(int id) {
		
		Customer target = customerRepository.findById(id).orElse(null);
		
		if(target != null) {
		
			GetCustomerResponse customerResponse = modelMapperService.forResponse()
					.map(target, GetCustomerResponse.class);
			
			return customerResponse;
		}
		
		return null;
	}


	@Override
	public void add(AddCustomerRequest addCustomerRequest) {

		Customer customer = modelMapperService.forRequest().map(addCustomerRequest, Customer.class);
		customer.setId(0);
		
		customerRepository.save(customer);

	}

	@Override
	public void update(UpdateCustomerRequest updateCustomerRequest) {
		
		Customer target = customerRepository.findById(updateCustomerRequest.getId()).orElseThrow();
		int accountId = target.getAccount().getId();

		target = modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
		target.getAccount().setId(accountId);
		
		customerRepository.save(target);
		
	}

	@Override
	public void delete(int id) {
		
		customerRepository.deleteById(id);
		
	}

	
}
