package market.store.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import market.store.business.abstracts.CustomerService;
import market.store.business.requests.customerRequests.AddCustomerRequest;
import market.store.business.requests.customerRequests.UpdateCustomerRequest;
import market.store.business.responses.customerResponses.GetAllCustomerResponse;
import market.store.business.responses.customerResponses.GetCustomerResponse;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomersController {
	
	private CustomerService customerService;

	@GetMapping("/getall")
	public List<GetAllCustomerResponse> getAll(){
		
		return customerService.getAll();
	}
	
	@GetMapping("/getcustomerbyid/{id}")
	public GetCustomerResponse getCustomerById(@PathVariable int id) {
		
		return customerService.getCustomerById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody AddCustomerRequest addCustomerRequest) {
		
		customerService.add(addCustomerRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateCustomerRequest updateCustomerRequest) {
		
		customerService.update(updateCustomerRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		
		customerService.delete(id);
	}
	
}
