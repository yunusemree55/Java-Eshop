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
import market.store.business.abstracts.CompanyService;
import market.store.business.requests.companyRequests.AddCompanyRequest;
import market.store.business.requests.companyRequests.UpdateCompanyRequest;
import market.store.business.responses.companyResponses.GetAllCompanyResponse;
import market.store.business.responses.companyResponses.GetCompanyResponse;

@RestController
@RequestMapping("/api/companies")
@AllArgsConstructor
public class CompaniesController {

	private CompanyService companyService;
	
	@GetMapping("/getall")
	public List<GetAllCompanyResponse> getAll(){
		
		return companyService.getAll();
		
	}
	
	@GetMapping("/getcompanybyid/{id}")
	public GetCompanyResponse getCompanyById(@PathVariable int id) {
		
		return companyService.getCompanyById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody AddCompanyRequest addCompanyRequest) {
		
		companyService.add(addCompanyRequest);
		
	}
	
	@PutMapping("/update")
	public void update(UpdateCompanyRequest updateCompanyRequest) {
		
		companyService.update(updateCompanyRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		
		companyService.delete(id);
		
	}
	
}
